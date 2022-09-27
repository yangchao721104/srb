package com.yang.srb.core.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
@Api(tags = "网站等级接口")
@RestController
@RequestMapping("/api/core/integralGrade")
public class IntegralGradeController {

    @ApiOperation(value = "测试接口")
    @GetMapping("/test")
    public String test(){
        return "hello";
    }


}

