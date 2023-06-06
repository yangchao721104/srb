package com.yang.srb.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yang.srb.core.mapper.DictMapper;
import com.yang.srb.core.pojo.dto.ExcelDictDTO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * @date 2022/10/13 22:51
 */
@Slf4j
@NoArgsConstructor
public class ExcelDictDTOLinstener extends AnalysisEventListener<ExcelDictDTO> {

    @Resource
    private DictMapper dictMapper;

    public ExcelDictDTOLinstener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    //数据列表
    private List<ExcelDictDTO> list = new ArrayList<>();

    //每5条记录批量存储一次数据
    private static final int BATCH_COUNT = 5;

    @Override
    public void invoke(ExcelDictDTO data, AnalysisContext analysisContext) {
        log.info("解析到一条记录：{}",data);
        //调用mapper层的save方法
        list.add(data);
        if (list.size() >= BATCH_COUNT){
            saveData();
            list.clear();
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //当最后剩余的数据记录数不足BATCH_COUNT时，我们最终一次性存储剩余数量
        saveData();
        list.clear();
        log.info("所有数据解析完成！");
    }


    private void saveData() {
        log.info("{} 条数据存储到数据库",list.size());
        //调用mapper层的save方法,批量保存list对象
        dictMapper.insertBatch(list);
        log.info("{} 条数据存储到数据库成功",list.size());
    }
}
