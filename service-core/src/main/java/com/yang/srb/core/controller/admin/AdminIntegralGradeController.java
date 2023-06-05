package com.yang.srb.core.controller.admin;

import com.yang.common.exception.Assert;
import com.yang.common.result.R;
import com.yang.common.result.ResponseEnum;
import com.yang.srb.core.pojo.entity.IntegralGrade;
import com.yang.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @author yang
 * @date 2022/7/17 13:36
 */
@Api(tags = "积分等级管理")
//解决跨域
//@CrossOrigin
@RestController
@RequestMapping("/admin/core/integralGrade")
@Slf4j
public class AdminIntegralGradeController {

    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation(value = "更新积分等级")
    @PutMapping("/update")
    public R updateById(
                @ApiParam(value = "积分等级对象",required = true)
                @RequestBody IntegralGrade integralGrade){
        boolean result = integralGradeService.updateById(integralGrade);
        if (result){
            return R.ok().message("更新成功");
        }else {
            return R.ok().message("更新失败");
        }
    }

    @ApiOperation("根据id获取积分等级")
    @GetMapping("/get/{id}")
    public R getById(
            @ApiParam(value = "数据id",required = true,example = "1")
            @PathVariable Long id){
        IntegralGrade integralGrade = integralGradeService.getById(id);
        if (!StringUtils.isEmpty(integralGrade)){
            return R.ok().data("record",integralGrade);
        }else {
            return R.ok().message("数据获取失败");
        }
    }

    @ApiOperation(value = "新增积分等级")
    @PostMapping ("/save")
    public R save(
                  @ApiParam(value = "积分等级对象",required = true)
                  @RequestBody IntegralGrade integralGrade){

//        if (integralGrade.getBorrowAmount() == null){
//            throw new BusinessException(ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
//        }

        Assert.notNull(integralGrade.getBorrowAmount(), ResponseEnum.BORROW_AMOUNT_NULL_ERROR);


        boolean result = integralGradeService.save(integralGrade);
        if (result){
            return R.ok().message("保存成功");
        }else {
            return R.ok().message("保存失败");
        }


    }

    @ApiOperation(value = "根据id删除数据记录",notes = "逻辑删除数据记录")
    @DeleteMapping("/remove/{id}")
    public R removeById(
            @ApiParam(value = "数据id",example = "100",required = true)
            @PathVariable Long id){
        boolean b = integralGradeService.removeById(id);
        if (b){
            return R.ok().message("删除成功");
        }else {
            return R.error().message("删除失败");
        }
    }


    @ApiOperation(value = "积分等级列表")
    @GetMapping("/list")
    public R listAll(){


        log.info("hi this is log info");
        log.error("hi this is log error");
        log.warn("hi this is log warn");

        List<IntegralGrade> list = integralGradeService.list();
        return R.ok().data("list",list).message("获取列表成功");
    }
}
