package com.yang.srb.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.srb.core.pojo.entity.BorrowerAttach;
import com.yang.srb.core.mapper.BorrowerAttachMapper;
import com.yang.srb.core.pojo.vo.BorrowerAttachVo;
import com.yang.srb.core.service.BorrowerAttachService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 借款人上传资源表 服务实现类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
@Service
public class BorrowerAttachServiceImpl extends ServiceImpl<BorrowerAttachMapper, BorrowerAttach> implements BorrowerAttachService {

    @Override
    public List<BorrowerAttachVo> selectBorrowerAttachVoList(Long borrowerId) {
        QueryWrapper<BorrowerAttach> borrowerAttachQueryWrapper = new QueryWrapper<>();
        borrowerAttachQueryWrapper.eq("borrower_id", borrowerId);
        List<BorrowerAttach> borrowerAttachList = baseMapper.selectList(borrowerAttachQueryWrapper);

        List<BorrowerAttachVo> borrowerAttachVOList = new ArrayList<>();
        borrowerAttachList.forEach(borrowerAttach -> {
            BorrowerAttachVo borrowerAttachVO = new BorrowerAttachVo();
            borrowerAttachVO.setImageType(borrowerAttach.getImageType());
            borrowerAttachVO.setImageUrl(borrowerAttach.getImageUrl());

            borrowerAttachVOList.add(borrowerAttachVO);
        });

        return borrowerAttachVOList;
    }
}
