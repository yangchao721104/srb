package com.yang.srb.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.srb.core.pojo.entity.Borrower;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.srb.core.pojo.vo.BorrowerApprovalVO;
import com.yang.srb.core.pojo.vo.BorrowerDetailVo;
import com.yang.srb.core.pojo.vo.BorrowerVo;

/**
 * <p>
 * 借款人 服务类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
public interface BorrowerService extends IService<Borrower> {

    void saveBorrowerVOByUserId(BorrowerVo borrowerVO, Long userId);

    Integer getStatusByUserId(Long userId);

    IPage<Borrower> listPage(Page<Borrower> pageParam, String keyword);

    BorrowerDetailVo getBorrowerDetailVoById(Long id);

    void approval(BorrowerApprovalVO borrowerApprovalVO);
}
