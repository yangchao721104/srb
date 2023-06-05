package com.yang.srb.core.service;

import com.yang.srb.core.pojo.entity.BorrowerAttach;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.srb.core.pojo.entity.vo.BorrowerAttachVo;

import java.util.List;

/**
 * <p>
 * 借款人上传资源表 服务类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
public interface BorrowerAttachService extends IService<BorrowerAttach> {

    List<BorrowerAttachVo> selectBorrowerAttachVoList(Long id);
}
