package com.parking.fee.service.impl;


import com.parking.common.core.utils.DateUtils;
import com.parking.fee.entity.MembershipCardInformation;
import com.parking.fee.mapper.MembershipCardInformationMapper;
import com.parking.fee.service.MembershipCardInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 会员卡信息Service业务层处理
 *
 * @author ljx
 * @date 2022-09-28
 */
@Service
public class MembershipCardInformationServiceImpl implements MembershipCardInformationService
{
    @Autowired
    private MembershipCardInformationMapper membershipCardInformationMapper;

    /**
     * 查询会员卡信息
     *
     * @param membershipCardInformationId 会员卡信息主键
     * @return 会员卡信息
     */
    @Override
    public MembershipCardInformation selectMembershipCardInformationByMembershipCardInformationId(Long membershipCardInformationId)
    {
        return membershipCardInformationMapper.selectMembershipCardInformationByMembershipCardInformationId(membershipCardInformationId);
    }

    /**
     * 查询会员卡信息列表
     *
     * @param membershipCardInformation 会员卡信息
     * @return 会员卡信息
     */
    @Override
    public List<MembershipCardInformation> selectMembershipCardInformationList(MembershipCardInformation membershipCardInformation)
    {
        return membershipCardInformationMapper.selectMembershipCardInformationList(membershipCardInformation);
    }

    /**
     * 新增会员卡信息
     *
     * @param membershipCardInformation 会员卡信息
     * @return 结果
     */
    @Override
    public int insertMembershipCardInformation(MembershipCardInformation membershipCardInformation)
    {
        membershipCardInformation.setCreateTime(DateUtils.getNowDate());
        return membershipCardInformationMapper.insertMembershipCardInformation(membershipCardInformation);
    }

    /**
     * 修改会员卡信息
     *
     * @param membershipCardInformation 会员卡信息
     * @return 结果
     */
    @Override
    public int updateMembershipCardInformation(MembershipCardInformation membershipCardInformation)
    {
        membershipCardInformation.setUpdateTime(DateUtils.getNowDate());
        return membershipCardInformationMapper.updateMembershipCardInformation(membershipCardInformation);
    }

    /**
     * 批量删除会员卡信息
     *
     * @param membershipCardInformationIds 需要删除的会员卡信息主键
     * @return 结果
     */
    @Override
    public int deleteMembershipCardInformationByMembershipCardInformationIds(Long[] membershipCardInformationIds)
    {
        return membershipCardInformationMapper.deleteMembershipCardInformationByMembershipCardInformationIds(membershipCardInformationIds);
    }

    /**
     * 删除会员卡信息信息
     *
     * @param membershipCardInformationId 会员卡信息主键
     * @return 结果
     */
    @Override
    public int deleteMembershipCardInformationByMembershipCardInformationId(Long membershipCardInformationId)
    {
        return membershipCardInformationMapper.deleteMembershipCardInformationByMembershipCardInformationId(membershipCardInformationId);
    }
}
