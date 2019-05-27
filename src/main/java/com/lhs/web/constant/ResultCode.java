package com.lhs.web.constant;

public class ResultCode {
    /**
     * 成功
     */
    public static final Integer SUCCESS = 200;
    /**
     * 错误
     */
    public static final Integer ERROR = -1;
    /**
     * 未登录
     */
    public static final Integer NO_LOGIN = -401;
    /**
     * 异常
     */
    public static final Integer EXCEPTION = 500;

    /**
     * 验证失败
     */
    public static final Integer VERIFY_FAIL = 10001;
    /**
     * 没有结果
     */
    public static final Integer NO_RESULT = 20003;

    /**
     * 参数缺失
     */
    public static final Integer PARAM_MISS = 40001;

    /**
     * 参数非法/参数格式不正确/参数不正确
     */
    public static final Integer PARAM_ILLEGAL = 40002;
    /**
     * 未找到数据/查询无信息/某某数据不存在
     */
    public static final Integer NOT_FOUND = 40003;

    /**
     * 没有权限
     */
    public static final Integer NO_PERMISSIONS = 40004;

    /**
     * 不能操作/不能修改（因为某种限制或状态，不能进行操作或修改）
     */
    public static final Integer CANNOT_OPERATE = 40005;

    /**
     * 调用依赖服务失败（调用别的项目服务时失败）
     */
    public static final Integer CALL_SERVICE_FAIL = 40006;


}
