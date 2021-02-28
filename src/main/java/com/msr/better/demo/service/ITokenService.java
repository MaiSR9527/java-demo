package com.msr.better.demo.service;

import com.msr.better.demo.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gztravelsky
 * @author MaiShuRen
 * @date 2020-09-30
 */
public interface ITokenService {

    /**
     * 创建token
     *
     * @return 返回
     */
    ServerResponse createToken();

    /**
     * 检查token
     *
     * @param request HttpServletRequest对象
     */
    void checkToken(HttpServletRequest request);

}
