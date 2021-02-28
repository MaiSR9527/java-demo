package com.msr.better.demo.controller;

import com.msr.better.demo.annotation.ApiIdempotent;
import com.msr.better.demo.common.ServerResponse;
import com.msr.better.demo.service.ITestService;
import com.msr.better.demo.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author MaiShuRen
 * @date 2020-10-14
 */
@RestController
@RequestMapping("token")
public class TestController {

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private ITestService testService;

    @GetMapping
    public ServerResponse token(){
        return tokenService.createToken();
    }

    @ApiIdempotent
    @PostMapping("test")
    public ServerResponse testIdempotent(){
        return testService.testIdempotent();
    }
}
