package com.yang.srb.sms.client;

import com.yang.srb.sms.client.fallback.CoreUserInfoClientFallback;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yang
 * @date 2023/6/4 22:25
 */
@FeignClient(value = "service-core",fallback = CoreUserInfoClientFallback.class)
public interface CoreUserInfoClient {
    @ApiOperation("校验手机号是否注册")
    @GetMapping("/api/core/userInfo/checkMobile/{mobile}")
    Boolean checkMobile(@PathVariable String mobile);
}
