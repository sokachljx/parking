package com.parking.fee.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.parking.common.core.annotation.Excel;
import com.parking.common.core.web.domain.BaseEntity;

/**
 * 会员卡信息对象 membership_card_information
 *
 * @author ljx
 * @date 2022-09-27
 */
public class MembershipCardInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员卡信息ID */
    private Long membershipCardInformationId;

    /** 会员等级 */
    @Excel(name = "会员等级")
    private String membershipLevel;

    /** 会员折扣 */
    @Excel(name = "会员折扣")
    private String memberDiscount;

    /** 购买金额 */
    @Excel(name = "购买金额")
    private Long purchaseAmount;

    /** 有限时间 */
    @Excel(name = "有限时间")
    private String limitedTime;

    /** 购买详情 */
    @Excel(name = "购买详情")
    private String purchaseDetails;

    /** 智能推荐 */
    @Excel(name = "智能推荐")
    private Long recommend;

    public void setMembershipCardInformationId(Long membershipCardInformationId)
    {
        this.membershipCardInformationId = membershipCardInformationId;
    }

    public Long getMembershipCardInformationId()
    {
        return membershipCardInformationId;
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
    public void setPurchaseAmount(Long purchaseAmount)
    {
        this.purchaseAmount = purchaseAmount;
    }

    public Long getPurchaseAmount()
    {
        return purchaseAmount;
    }
    public void setLimitedTime(String limitedTime)
    {
        this.limitedTime = limitedTime;
    }

    public String getLimitedTime()
    {
        return limitedTime;
    }
    public void setPurchaseDetails(String purchaseDetails)
    {
        this.purchaseDetails = purchaseDetails;
    }

    public String getPurchaseDetails()
    {
        return purchaseDetails;
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
                .append("membershipCardInformationId", getMembershipCardInformationId())
                .append("membershipLevel", getMembershipLevel())
                .append("memberDiscount", getMemberDiscount())
                .append("purchaseAmount", getPurchaseAmount())
                .append("limitedTime", getLimitedTime())
                .append("purchaseDetails", getPurchaseDetails())
                .append("recommend", getRecommend())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
