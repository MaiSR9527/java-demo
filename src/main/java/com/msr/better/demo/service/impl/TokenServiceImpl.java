package com.msr.better.demo.service.impl;

import com.msr.better.demo.common.Constant;
import com.msr.better.demo.common.ResponseCode;
import com.msr.better.demo.common.ServerResponse;
import com.msr.better.demo.exception.ServiceException;
import com.msr.better.demo.service.ITokenService;
import com.msr.better.demo.utils.RandomUtil;
import com.msr.better.demo.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author MaiShuRen
 * @date 2020-09-30
 */
@Slf4j
@Service
public class TokenServiceImpl implements ITokenService {


    private static final String TOKEN_NAME = "token";

    @Resource
    private RedisUtils redisUtils;

    @Override
    public ServerResponse createToken() {
        String str = RandomUtil.UUID32();
        StrBuilder token = new StrBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);
        redisUtils.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);
        log.info("create a token ---> {}", token);
        return ServerResponse.success(token.toString());
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        log.info("request header token: {}", token);
        // 判断header是否存在token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(TOKEN_NAME);
            log.info("request header token: {}", token);
            // 判断请求参数中是否存在token
            if (StringUtils.isBlank(token)) {
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }
        if (!redisUtils.hasKey(token)) {
            log.error("redis doesn't has key:{}", token);
            throw new ServiceException(ResponseCode.ILLEGAL_token.getMsg());
        }
        boolean delFlag = redisUtils.del(token);

        if (!delFlag) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }

}
