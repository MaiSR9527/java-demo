package com.msr.better.demo.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author gztravelsky
 * @author MaiShuRen
 * @date 2020-10-14
 */
@Getter
@Setter
public class ServiceException extends RuntimeException {

    private String code;
    private String msg;

    public ServiceException() {
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
