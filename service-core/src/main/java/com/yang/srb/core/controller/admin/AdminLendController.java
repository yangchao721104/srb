package com.yang.srb.core.controller.admin;


import com.yang.common.result.R;
import com.yang.srb.base.util.JwtUtils;
import com.yang.srb.core.pojo.entity.Lend;
import com.yang.srb.core.service.LendService;
import com.yang.srb.core.service.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的准备表 前端控制器
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
@Api(tags = "标的管理")
@RestController
@RequestMapping("/admin/core/lend")
@Slf4j
public class AdminLendController {

    @Resource
    private LendService lendService;

    @ApiOperation("放款")
    @GetMapping("/makeLoan/{id}")
    public R makeLoan(
            @ApiParam(value = "标的id", required = true)
            @PathVariable("id") Long id) {
        lendService.makeLoan(id);
        return R.ok().message("放款成功");
    }

    @ApiOperation("获取标的信息")
    @GetMapping("/show/{id}")
    public R show(
            @ApiParam(value = "标的id", required = true)
            @PathVariable Long id) {
        Map<String, Object> result = lendService.getLendDetail(id);
        return R.ok().data("lendDetail", result);
    }

    @ApiOperation("标的列表")
    @GetMapping("/list")
    public R list() {
        List<Lend> lendList = lendService.selectList();
        return R.ok().data("list", lendList);
    }

}

