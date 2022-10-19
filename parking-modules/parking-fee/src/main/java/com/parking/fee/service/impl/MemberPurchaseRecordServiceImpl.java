package com.parking.fee.service.impl;

import java.util.List;
import com.parking.common.core.utils.DateUtils;
import com.parking.fee.entity.MemberPurchaseRecord;
import com.parking.fee.mapper.MemberPurchaseRecordMapper;
import com.parking.fee.service.MemberPurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 会员购买记录Service业务层处理
 *
 * @author parking
 * @date 2022-09-29
 */
@Service
public class MemberPurchaseRecordServiceImpl implements MemberPurchaseRecordService
{
    @Autowired
    private MemberPurchaseRecordMapper memberPurchaseRecordMapper;

    /**
     * 查询会员购买记录
     *
     * @param memberPurchaseRecordId 会员购买记录主键
     * @return 会员购买记录
     */
    @Override
    public MemberPurchaseRecord selectMemberPurchaseRecordByMemberPurchaseRecordId(Long memberPurchaseRecordId)
    {
        return memberPurchaseRecordMapper.selectMemberPurchaseRecordByMemberPurchaseRecordId(memberPurchaseRecordId);
    }

    /**
     * 查询会员购买记录列表
     *
     * @param memberPurchaseRecord 会员购买记录
     * @return 会员购买记录
     */
    @Override
    public List<MemberPurchaseRecord> selectMemberPurchaseRecordList(MemberPurchaseRecord memberPurchaseRecord)
    {
        return memberPurchaseRecordMapper.selectMemberPurchaseRecordList(memberPurchaseRecord);
    }

    /**
     * 新增会员购买记录
     *
     * @param memberPurchaseRecord 会员购买记录
     * @return 结果
     */
    @Override
    public int insertMemberPurchaseRecord(MemberPurchaseRecord memberPurchaseRecord)
    {
        memberPurchaseRecord.setCreateTime(DateUtils.getNowDate());
        return memberPurchaseRecordMapper.insertMemberPurchaseRecord(memberPurchaseRecord);
    }

    /**
     * 修改会员购买记录
     *
     * @param memberPurchaseRecord 会员购买记录
     * @return 结果
     */
    @Override
    public int updateMemberPurchaseRecord(MemberPurchaseRecord memberPurchaseRecord)
    {
        memberPurchaseRecord.setUpdateTime(DateUtils.getNowDate());
        return memberPurchaseRecordMapper.updateMemberPurchaseRecord(memberPurchaseRecord);
    }

    /**
     * 批量删除会员购买记录
     *
     * @param memberPurchaseRecordIds 需要删除的会员购买记录主键
     * @return 结果
     */
    @Override
    public int deleteMemberPurchaseRecordByMemberPurchaseRecordIds(Long[] memberPurchaseRecordIds)
    {
        return memberPurchaseRecordMapper.deleteMemberPurchaseRecordByMemberPurchaseRecordIds(memberPurchaseRecordIds);
    }

    /**
     * 删除会员购买记录信息
     *
     * @param memberPurchaseRecordId 会员购买记录主键
     * @return 结果
     */
    @Override
    public int deleteMemberPurchaseRecordByMemberPurchaseRecordId(Long memberPurchaseRecordId)
    {
        return memberPurchaseRecordMapper.deleteMemberPurchaseRecordByMemberPurchaseRecordId(memberPurchaseRecordId);
    }
}
