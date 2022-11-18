package com.yang.easyexcel.linstener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yang.easyexcel.dto.ExcelStudentDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yang
 * @date 2022/10/13 22:22
 */
@Slf4j
public class ExcelStudentDTOListener extends AnalysisEventListener<ExcelStudentDto> {
    @Override
    public void invoke(ExcelStudentDto excelStudentDto, AnalysisContext analysisContext) {
        log.info("解析到一条记录：{}",excelStudentDto);
        //调用mapper层的save方法
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }
}
