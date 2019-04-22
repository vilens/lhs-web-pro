package com.lhs.web;

import com.alibaba.fastjson.JSONObject;
import com.lhs.annotation.NoAuth;
import com.lhs.web.form.ResultForm;
import jodd.http.HttpRequest;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.weixin4j.WeixinException;
import org.weixin4j.component.SnsComponent;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;
import org.weixin4j.model.pay.PayNotifyResult;
import org.weixin4j.model.pay.UnifiedOrder;
import org.weixin4j.model.pay.UnifiedOrderResult;
import org.weixin4j.spring.WeixinTemplate;
import org.weixin4j.util.PayUtil;
import org.weixin4j.util.SignUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/wechat")
public class WechatController {
    private static Logger logger = LoggerFactory.getLogger(WechatController.class);

    private static final String grant_type = "authorization_code";
    @Autowired
    private WeixinTemplate weixinTemplate;

    @RequestMapping("/getAccessToken")
    public Object getAccessToken() {
        try {
            return weixinTemplate.getToken().getAccess_token();
        } catch (WeixinException e) {
            return "";
        }
    }


    /**
     * 小程序后台登录，向微信平台发送获取access_token请求，并返回openId
     *
     * @param code
     * @return openid
     * @throws WeixinException
     * @throws IOException
     * @since Weixin4J 1.0.0
     */
    @RequestMapping("login")
    public Object login(String code, HttpServletRequest request) throws WeixinException, IOException {
        Map<String, Object> ret = new HashMap<String, Object>();
        if (code == null || code.equals("")) {
            throw new WeixinException("invalid null, code is null.");
        }
        SnsComponent sns = weixinTemplate.sns();
        ret.put("openid", sns.getOpenId(code));
        return ret;
    }

    @NoAuth
    @RequestMapping("jscode2session")
    public Object jscode2session(@RequestBody(required = false) JSONObject jsonRequestBody, HttpServletRequest request,
                                 HttpServletResponse response) throws WeixinException {
        String code = jsonRequestBody.getString("code");
        String jscode2session = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session")
                .query("grant_type", grant_type, "appid", weixinTemplate.getAppId(), "secret",
                        weixinTemplate.getWeixinConfig().getSecret(), "js_code", code)
                .send().body();
        return ResultForm.createSuccess("请求成功", JSONObject.parseObject(jscode2session));
    }

    @RequestMapping("sendMiniMsg")
    public Object sendMiniMsg(@RequestBody(required = false) JSONObject jsonRequestBody, HttpServletRequest request,
                              HttpServletResponse response) throws WeixinException {
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="
                + weixinTemplate.getToken().getAccess_token(), jsonRequestBody);
        return ResultForm.createSuccess("请求成功", res.asJSONObject());
    }

    @RequestMapping("sendTempMsg")
    public Object sendTempMsg(@RequestBody(required = false) JSONObject jsonRequestBody, HttpServletRequest request,
                              HttpServletResponse response) throws WeixinException {
        HttpsClient http = new HttpsClient();
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/uniform_send?access_token="
                + weixinTemplate.getToken().getAccess_token(), jsonRequestBody);
        return ResultForm.createSuccess("请求成功", res.asJSONObject());
    }

    /**
     * @param openid
     * @param request
     * @throws WeixinException
     * @Description: 发起微信支付
     * @author: vilens
     * @date: 2019年3月24日
     */
    @RequestMapping("wxPay")
    public Object wxPay(@RequestBody(required = false) JSONObject jsonRequestBody, HttpServletRequest request,
                        HttpServletResponse response) throws WeixinException {
        String openid = jsonRequestBody.getString("openid");
        String orderCode = jsonRequestBody.getString("orderCode");
        String totalFee = jsonRequestBody.getString("totalFee");
        if (StringUtil.isNotEmpty(openid) && StringUtil.isNotEmpty(orderCode) && StringUtil.isNotEmpty(totalFee)) {
            String nonceStr = getRandomStringByLength(32);
            UnifiedOrder unifiedorder = new UnifiedOrder();
            unifiedorder.setAppid(weixinTemplate.getAppId());
            unifiedorder.setMch_id(weixinTemplate.getWeixinPayConfig().getPartnerId());
            unifiedorder.setNonce_str(nonceStr);
            unifiedorder.setBody("鹿回山订单");
            unifiedorder.setOut_trade_no(orderCode);
            // 订单金额为元转换为分
//            unifiedorder.setTotal_fee("1");
            unifiedorder.setTotal_fee(totalFee);
            unifiedorder.setSpbill_create_ip(getIpAddr(request));
            unifiedorder.setNotify_url(weixinTemplate.getWeixinPayConfig().getNotifyUrl());
            unifiedorder.setTrade_type("JSAPI");
            unifiedorder.setOpenid(openid);
            String sign = SignUtil.getSign(unifiedorder.toMap(), weixinTemplate.getWeixinPayConfig().getPartnerKey());
            unifiedorder.setSign(sign);
            UnifiedOrderResult unifiedOrderResult = weixinTemplate.pay().payUnifiedOrder(unifiedorder);
            return PayUtil.getBrandWCPayRequest(unifiedOrderResult.getAppid(), unifiedOrderResult.getPrepay_id(),
                    weixinTemplate.getWeixinPayConfig().getPartnerKey());
        } else {
            return ResultForm.createError("订单不可用！");
        }

    }

    /**
     * @return
     * @throws Exception
     * @throws WeixinException
     * @Description:微信支付
     * @author vilens
     * @date 2019年3月24日
     */
    @RequestMapping(value = "/wxNotify")
    public String wxNotify(@RequestBody(required = false) String notityXml, HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        String resXml = "";
        Boolean ret = PayUtil.verifySign(notityXml, weixinTemplate.getWeixinPayConfig().getPartnerKey());
        if (ret) {
            // 通知微信服务器已经支付成功
            resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                    + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            JAXBContext context = JAXBContext.newInstance(PayNotifyResult.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PayNotifyResult result = (PayNotifyResult) unmarshaller.unmarshal(new StringReader(notityXml));
            // 获取到订单信息改为支付完成
            String orderCode = result.getOut_trade_no();
            //TODO 更新订单信息
//            orderService.updateStatusByCode(orderCode, 1);
        } else {
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        return resXml;
    }

    /**
     * 获得客户端真实IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
