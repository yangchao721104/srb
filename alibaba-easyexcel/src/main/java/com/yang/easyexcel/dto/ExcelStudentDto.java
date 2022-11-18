package com.yang.easyexcel.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author yang
 * @date 2022/10/13 0:20
 */
@Data
public class ExcelStudentDto {
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("生日")
    private Date birthday;
    @ExcelProperty("yueXin")
    private Double salary;
//    @ExcelIgnore(忽略某字段)
}
