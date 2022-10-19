package com.parking.fee.mapper;


import com.parking.fee.entity.MemberPurchaseRecord;

import java.util.List;

/**
 * 会员购买记录Mapper接口
 *
 * @author ljx
 * @date 2022-09-29
 */
public interface MemberPurchaseRecordMapper
{
    /**
     * 查询会员购买记录
     *
     * @param memberPurchaseRecordId 会员购买记录主键
     * @return 会员购买记录
     */
    public MemberPurchaseRecord selectMemberPurchaseRecordByMemberPurchaseRecordId(Long memberPurchaseRecordId);

    /**
     * 查询会员购买记录列表
     *
     * @param memberPurchaseRecord 会员购买记录
     * @return 会员购买记录集合
     */
    public List<MemberPurchaseRecord> selectMemberPurchaseRecordList(MemberPurchaseRecord memberPurchaseRecord);

    /**
     * 新增会员购买记录
     *
     * @param memberPurchaseRecord 会员购买记录
     * @return 结果
     */
    public int insertMemberPurchaseRecord(MemberPurchaseRecord memberPurchaseRecord);

    /**
     * 修改会员购买记录
     *
     * @param memberPurchaseRecord 会员购买记录
     * @return 结果
     */
    public int updateMemberPurchaseRecord(MemberPurchaseRecord memberPurchaseRecord);

    /**
     * 删除会员购买记录
     *
     * @param memberPurchaseRecordId 会员购买记录主键
     * @return 结果
     */
    public int deleteMemberPurchaseRecordByMemberPurchaseRecordId(Long memberPurchaseRecordId);

    /**
     * 批量删除会员购买记录
     *
     * @param memberPurchaseRecordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMemberPurchaseRecordByMemberPurchaseRecordIds(Long[] memberPurchaseRecordIds);
}
