package com.yang.srb.sms.client.fallback;

import com.yang.srb.sms.client.CoreUserInfoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yang
 * @date 2023/6/5 0:11
 */
@Service
@Slf4j
public class CoreUserInfoClientFallback implements CoreUserInfoClient {
    @Override
    public Boolean checkMobile(String mobile) {
        log.error("远程掉用失败，服务熔断，手机号不存在");
        return false;
    }
}
