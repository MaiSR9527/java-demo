package com.msr.better.demo.service;

import com.msr.better.demo.common.ServerResponse;

/**
 * @author MaiShuRen
 * @date 2020-10-16
 */
public interface ITestService {
    ServerResponse testIdempotent();
}
