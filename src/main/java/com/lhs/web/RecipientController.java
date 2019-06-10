package com.lhs.web;

import com.lhs.entity.RecipientInfo;
import com.lhs.entity.User;
import com.lhs.entity.vo.RecipientInfoVO;
import com.lhs.service.RecipientInfoService;
import com.lhs.service.UserService;
import com.lhs.web.constant.ResultCode;
import com.lhs.web.form.ResultForm;
import com.lhs.web.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Leonid on 2018/7/13.
 */
@RestController
@RequestMapping("/recipient")
public class RecipientController {

    private static Logger logger = LoggerFactory.getLogger(RecipientController.class);

    @Autowired
    RecipientInfoService recipientInfoService;

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public Object add(@RequestBody RecipientInfoVO recipientInfoVO) {
        ResultForm<?> resultForm = null;
        try {
            RecipientInfo recipientInfo = recipientInfoVO.getRecipientInfo();
            if (recipientInfo != null && recipientInfo.getUserId() != null) {
                recipientInfoService.insertOrUpdate(recipientInfo);
                resultForm = ResultForm.createSuccess("保存成功", recipientInfo);
            } else {
                if (recipientInfoVO != null && StringUtils.isNotEmpty(recipientInfoVO.getWxOpenid())) {
                    User user = new User();
                    user.setWxOpenid(recipientInfoVO.getWxOpenid());
                    user = userService.findUser(user);
                    if (user == null) {
                        resultForm = ResultForm.createError(ResultCode.NO_RESULT, "用户不在系统中");
                        return resultForm;
                    } else {
                        recipientInfo.setUserId(user.getId());
                        recipientInfoService.insertOrUpdate(recipientInfo);
                        resultForm = ResultForm.createSuccess("保存成功", recipientInfo);
                    }
                } else {
                    resultForm = ResultForm.createError(ResultCode.NO_RESULT, "没有openid");
                    return resultForm;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

    @PostMapping("/findAll")
    public Object findAll(String wxOpenid) {
        ResultForm<?> resultForm = null;
        try {
            if (StringUtils.isNotEmpty(wxOpenid)) {
                List<RecipientInfo> result = recipientInfoService.findByOpenid(wxOpenid);
                if (result != null && result.size() > 0) {
                    resultForm = ResultForm.createSuccess("查询成功", result);
                } else {
                    resultForm = ResultForm.createError(ResultCode.NO_RESULT, "没有查找到结果");
                }
            } else {
                resultForm = ResultForm.createError("没有openid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            resultForm = ResultForm.createError(e.getMessage());
        }
        return resultForm;
    }

}
