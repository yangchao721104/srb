package com.yang.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.yang.easyexcel.dto.ExcelStudentDto;
import com.yang.easyexcel.linstener.ExcelStudentDTOListener;
import org.junit.Test;

import java.io.File;

/**
 * @author yang
 * @date 2022/10/13 22:25
 */
public class ExcelReadTest {

    @Test
    public void readTest(){
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "C:\\Users\\Administrator\\Desktop\\simpleWrite1665672045430.xls";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, ExcelStudentDto.class, new ExcelStudentDTOListener())
                .excelType(ExcelTypeEnum.XLS).sheet().doRead();

    }
}
