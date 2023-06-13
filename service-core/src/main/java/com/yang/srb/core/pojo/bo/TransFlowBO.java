package com.yang.srb.core.pojo.bo;

import com.yang.srb.core.enums.TransTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author yang
 * @date 2023/6/13 21:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransFlowBO {
    private String agentBillNo;
    private String bindCode;
    private BigDecimal amount;
    private TransTypeEnum transTypeEnum;
    private String memo;
}
