package com.yang.srb.core.controller.api;


import com.yang.common.exception.Assert;
import com.yang.common.result.R;
import com.yang.common.result.ResponseEnum;
import com.yang.common.util.RegexValidateUtils;
import com.yang.srb.core.pojo.entity.vo.LoginVo;
import com.yang.srb.core.pojo.entity.vo.RegisterVo;
import com.yang.srb.core.pojo.entity.vo.UserInfoVo;
import com.yang.srb.core.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
@Api(tags = "会员接口")
@RestController
@RequestMapping("/api/core/userInfo")
@Slf4j
@CrossOrigin
public class UserInfooController {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserInfoService userInfoService;

    @ApiOperation("会员登录")
    @PostMapping("/login")
    public R login(@RequestBody LoginVo loginVo, HttpServletRequest request){

        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        Assert.notEmpty(mobile,ResponseEnum.MOBILE_NULL_ERROR);
        Assert.notEmpty(password,ResponseEnum.PASSWORD_NULL_ERROR);

        String addr = request.getRemoteAddr();
        UserInfoVo userInfoVo = userInfoService.login(loginVo,addr);

        return R.ok().data("userInfo",userInfoVo);
    }


    @ApiOperation("会员注册")
    @PostMapping("/register")
    public R register(@RequestBody RegisterVo registerVo){
        String mobile = registerVo.getMobile();
        String code = registerVo.getCode();
        String password = registerVo.getPassword();

        Assert.notEmpty(mobile,ResponseEnum.MOBILE_NULL_ERROR);
        Assert.notEmpty(password,ResponseEnum.CODE_NULL_ERROR);
        Assert.notEmpty(code,ResponseEnum.CODE_NULL_ERROR);
        Assert.isTrue(RegexValidateUtils.checkCellphone(mobile),ResponseEnum.MOBILE_ERROR);

        String codeGen = (String) redisTemplate.opsForValue().get("srb:sms:code:" +mobile);
        Assert.equals(code,codeGen, ResponseEnum.CODE_ERROR);

        userInfoService.register(registerVo);

        return R.ok().message("注册成功");
    }
}

