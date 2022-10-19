package com.parking.fee.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.parking.common.core.annotation.Excel;
import com.parking.common.core.web.domain.BaseEntity;

/**
 * 会员购买记录对象 member_purchase_record
 *
 * @author ljx
 * @date 2022-09-29
 */
public class MemberPurchaseRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员购买记录ID */
    private Long memberPurchaseRecordId;

    /** 会员等级 */
    @Excel(name = "会员等级")
    private String membershipLevel;

    /** 会员折扣 */
    @Excel(name = "会员折扣")
    private String memberDiscount;

    /** 购买金额 */
    @Excel(name = "购买金额")
    private String purchaseAmount;

    /** 购买时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseTime;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private Long userAccount;

    /** 支付状态 */
    @Excel(name = "支付状态")
    private String payState;

    /** 支付类型: 微信、支付宝、网银 */
    @Excel(name = "支付类型: 微信、支付宝、网银")
    private String payType;

    /** 智能推荐 */
    @Excel(name = "智能推荐")
    private Long recommend;

    public void setMemberPurchaseRecordId(Long memberPurchaseRecordId)
    {
        this.memberPurchaseRecordId = memberPurchaseRecordId;
    }

    public Long getMemberPurchaseRecordId()
    {
        return memberPurchaseRecordId;
    }
    public void setMembershipLevel(String membershipLevel)
    {
        this.membershipLevel = membershipLevel;
    }

    public String getMembershipLevel()
    {
        return membershipLevel;
    }
    public void setMemberDiscount(String memberDiscount)
    {
        this.memberDiscount = memberDiscount;
    }

    public String getMemberDiscount()
    {
        return memberDiscount;
    }
    public void setPurchaseAmount(String purchaseAmount)
    {
        this.purchaseAmount = purchaseAmount;
    }

    public String getPurchaseAmount()
    {
        return purchaseAmount;
    }
    public void setPurchaseTime(Date purchaseTime)
    {
        this.purchaseTime = purchaseTime;
    }

    public Date getPurchaseTime()
    {
        return purchaseTime;
    }
    public void setUserAccount(Long userAccount)
    {
        this.userAccount = userAccount;
    }

    public Long getUserAccount()
    {
        return userAccount;
    }
    public void setPayState(String payState)
    {
        this.payState = payState;
    }

    public String getPayState()
    {
        return payState;
    }
    public void setPayType(String payType)
    {
        this.payType = payType;
    }

    public String getPayType()
    {
        return payType;
    }
    public void setRecommend(Long recommend)
    {
        this.recommend = recommend;
    }

    public Long getRecommend()
    {
        return recommend;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("memberPurchaseRecordId", getMemberPurchaseRecordId())
                .append("membershipLevel", getMembershipLevel())
                .append("memberDiscount", getMemberDiscount())
                .append("purchaseAmount", getPurchaseAmount())
                .append("purchaseTime", getPurchaseTime())
                .append("userAccount", getUserAccount())
                .append("payState", getPayState())
                .append("payType", getPayType())
                .append("recommend", getRecommend())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
