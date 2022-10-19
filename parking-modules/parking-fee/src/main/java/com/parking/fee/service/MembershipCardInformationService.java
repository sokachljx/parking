package com.parking.fee.service;


import com.parking.fee.entity.MembershipCardInformation;

import java.util.List;

/**
 * 会员卡信息Service接口
 *
 * @author ljx
 * @date 2022-09-28
 */
public interface MembershipCardInformationService
{
    /**
     * 查询会员卡信息
     *
     * @param membershipCardInformationId 会员卡信息主键
     * @return 会员卡信息
     */
    public MembershipCardInformation selectMembershipCardInformationByMembershipCardInformationId(Long membershipCardInformationId);

    /**
     * 查询会员卡信息列表
     *
     * @param membershipCardInformation 会员卡信息
     * @return 会员卡信息集合
     */
    public List<MembershipCardInformation> selectMembershipCardInformationList(MembershipCardInformation membershipCardInformation);

    /**
     * 新增会员卡信息
     *
     * @param membershipCardInformation 会员卡信息
     * @return 结果
     */
    public int insertMembershipCardInformation(MembershipCardInformation membershipCardInformation);

    /**
     * 修改会员卡信息
     *
     * @param membershipCardInformation 会员卡信息
     * @return 结果
     */
    public int updateMembershipCardInformation(MembershipCardInformation membershipCardInformation);

    /**
     * 批量删除会员卡信息
     *
     * @param membershipCardInformationIds 需要删除的会员卡信息主键集合
     * @return 结果
     */
    public int deleteMembershipCardInformationByMembershipCardInformationIds(Long[] membershipCardInformationIds);

    /**
     * 删除会员卡信息信息
     *
     * @param membershipCardInformationId 会员卡信息主键
     * @return 结果
     */
    public int deleteMembershipCardInformationByMembershipCardInformationId(Long membershipCardInformationId);
}
