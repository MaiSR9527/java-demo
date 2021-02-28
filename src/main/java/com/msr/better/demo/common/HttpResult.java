package com.msr.better.demo.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author MaiShuRen
 * @date 2020-09-30
 */
public class HttpResult {

    private static final String SUCCESS = "success";

    private Integer code;

    private String msg;

    private Object data;

    public HttpResult(String msg) {
        this.msg = msg;
    }

    public HttpResult(Object data) {
        this.data = data;
    }

    public HttpResult(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public HttpResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static HttpResult success(String msg, Object data) {
        return new HttpResult(HttpStatus.OK.value(), msg, data);
    }

    public static HttpResult success(Object data) {
        return new HttpResult(HttpStatus.OK.value(), SUCCESS, data);
    }

    public static HttpResult error(String msg, Object data) {
        return new HttpResult(HttpStatus.BAD_REQUEST.value(), msg, data);
    }
}
