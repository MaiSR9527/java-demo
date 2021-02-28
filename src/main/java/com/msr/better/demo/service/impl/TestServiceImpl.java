package com.msr.better.demo.service.impl;

import com.msr.better.demo.common.ServerResponse;
import com.msr.better.demo.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * @author MaiShuRen
 * @date 2020-10-16
 */
@Service
public class TestServiceImpl implements ITestService {
    @Override
    public ServerResponse testIdempotent() {
        return ServerResponse.success("testIdempotent:success");
    }
}
