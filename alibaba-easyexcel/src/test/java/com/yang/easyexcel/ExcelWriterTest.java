package com.yang.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.yang.easyexcel.dto.ExcelStudentDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yang
 * @date 2022/10/13 0:22
 */
@Slf4j
public class ExcelWriterTest {

    /**
     * 1048576行
     */
    @Test
    public void simpleWriterTestXlsx(){
                    // 写法2
            String fileName =  "C:\\Users\\Administrator\\Desktop\\simpleWrite" + System.currentTimeMillis() + ".xlsx";
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            // 如果这里想使用03 则 传入excelType参数即可
            EasyExcel.write(fileName, ExcelStudentDto.class).sheet("模板").doWrite(data());

    }

    /**
     * 65535行
     */
    @Test
    public void simpleWriterTestXls(){
        // 写法2
        String fileName =  "C:\\Users\\Administrator\\Desktop\\simpleWrite" + System.currentTimeMillis() + ".xls";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExcelStudentDto.class)
                .excelType(ExcelTypeEnum.XLS).sheet("模板").doWrite(data());

    }

    @Test
    public void cc(){
        /**
         * 最简单的写
         * <p>
         * 1. 创建excel对应的实体对象 参照{@link DemoData}
         * <p>
         * 2. 直接写即可
         */
//        @Test
//        public void simpleWrite() {
//            // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入
//
//            // 写法1 JDK8+
//            // since: 3.0.0-beta1
//            String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//            // 如果这里想使用03 则 传入excelType参数即可
//            EasyExcel.write(fileName, DemoData.class)
//                    .sheet("模板")
//                    .doWrite(() -> {
//                        // 分页查询数据
//                        return data();
//                    });
//
//            // 写法2
//            fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//            // 如果这里想使用03 则 传入excelType参数即可
//            EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
//
//            // 写法3:使用 try-with-resources @since 3.1.0
//            fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//            // 这里 需要指定写用哪个class去写
//            try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
//                WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//                excelWriter.write(data(), writeSheet);
//            }
//
//            // 写法4: 不使用 try-with-resources
//            fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//            // 这里 需要指定写用哪个class去写
//            ExcelWriter excelWriter = null;
//            try {
//                excelWriter = EasyExcel.write(fileName, DemoData.class).build();
//                WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//                excelWriter.write(data(), writeSheet);
//            } finally {
//                // 千万别忘记close 会帮忙关闭流
//                if (excelWriter != null) {
//                    excelWriter.close();
//                }
//            }
//        }
    }

    private List<ExcelStudentDto> data() {
        List<ExcelStudentDto> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ExcelStudentDto data = new ExcelStudentDto();
            data.setName("字符串" + i);
            data.setBirthday(new Date());
            data.setSalary(0.56);
            list.add(data);
        }
        return list;
    }
}
