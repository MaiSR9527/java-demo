package com.msr.better.demo.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 相应状态码
 * @author MaiShuRen
 * @date 2020-10-14
 */
@Getter
public enum ResponseCode {

    // 系统模块
    SUCCESS(0, "操作成功"),
    ERROR(1, "操作失败"),
    SERVER_ERROR(500, "服务器异常"),

    // 通用模块 1xxxx
    ILLEGAL_ARGUMENT(10000, "参数不合法"),
    REPETITIVE_OPERATION(10001, "请勿重复操作"),
    ACCESS_LIMIT(10002, "请求太频繁, 请稍后再试"),
    ILLEGAL_token(10003, "token无效"),

    // 用户模块 2xxxx
    NEED_LOGIN(20001, "登录失效"),
    USERNAME_OR_PASSWORD_EMPTY(20002, "用户名或密码不能为空"),
    USERNAME_OR_PASSWORD_WRONG(20003, "用户名或密码错误"),
    USER_NOT_EXISTS(20004, "用户不存在"),
    WRONG_PASSWORD(20005, "密码错误"),
    ;

    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
