package com.parking.fee.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.parking.common.core.annotation.Excel;
import com.parking.common.core.web.domain.BaseEntity;

/**
 * 停车缴费对象 parking_fee
 *
 * @author ljx
 * @date 2022-09-27
 */
public class ParkingFee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 停车缴费ID */
    private Long parkingFeeId;

    /** 车位号 */
    @Excel(name = "车位号")
    private String parkingSpaceNumber;

    /** 车位类型 */
    @Excel(name = "车位类型")
    private String parkingSpaceType;

    /** 车位地址 */
    @Excel(name = "车位地址")
    private String parkingSpaceAddress;

    /** 每小时停车费用 */
    @Excel(name = "每小时停车费用")
    private String hourlyParkingFee;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String licensePlateNumber;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 总时间 */
    @Excel(name = "总时间")
    private Long totalTime;

    /** 车牌识别 */
    @Excel(name = "车牌识别")
    private String licensePlateRecognition;

    /** 会员卡号 */
    @Excel(name = "会员卡号")
    private String membershipCardNumber;

    /** 会员折扣 */
    @Excel(name = "会员折扣")
    private String memberDiscount;

    /** 总费用 */
    @Excel(name = "总费用")
    private String totalCost;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private Long userAccount;

    /** 智能推荐 */
    @Excel(name = "智能推荐")
    private Long recommend;

    public void setParkingFeeId(Long parkingFeeId)
    {
        this.parkingFeeId = parkingFeeId;
    }

    public Long getParkingFeeId()
    {
        return parkingFeeId;
    }
    public void setParkingSpaceNumber(String parkingSpaceNumber)
    {
        this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public String getParkingSpaceNumber()
    {
        return parkingSpaceNumber;
    }
    public void setParkingSpaceType(String parkingSpaceType)
    {
        this.parkingSpaceType = parkingSpaceType;
    }

    public String getParkingSpaceType()
    {
        return parkingSpaceType;
    }
    public void setParkingSpaceAddress(String parkingSpaceAddress)
    {
        this.parkingSpaceAddress = parkingSpaceAddress;
    }

    public String getParkingSpaceAddress()
    {
        return parkingSpaceAddress;
    }
    public void setHourlyParkingFee(String hourlyParkingFee)
    {
        this.hourlyParkingFee = hourlyParkingFee;
    }

    public String getHourlyParkingFee()
    {
        return hourlyParkingFee;
    }
    public void setLicensePlateNumber(String licensePlateNumber)
    {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber()
    {
        return licensePlateNumber;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setTotalTime(Long totalTime)
    {
        this.totalTime = totalTime;
    }

    public Long getTotalTime()
    {
        return totalTime;
    }
    public void setLicensePlateRecognition(String licensePlateRecognition)
    {
        this.licensePlateRecognition = licensePlateRecognition;
    }

    public String getLicensePlateRecognition()
    {
        return licensePlateRecognition;
    }
    public void setMembershipCardNumber(String membershipCardNumber)
    {
        this.membershipCardNumber = membershipCardNumber;
    }

    public String getMembershipCardNumber()
    {
        return membershipCardNumber;
    }
    public void setMemberDiscount(String memberDiscount)
    {
        this.memberDiscount = memberDiscount;
    }

    public String getMemberDiscount()
    {
        return memberDiscount;
    }
    public void setTotalCost(String totalCost)
    {
        this.totalCost = totalCost;
    }

    public String getTotalCost()
    {
        return totalCost;
    }
    public void setUserAccount(Long userAccount)
    {
        this.userAccount = userAccount;
    }

    public Long getUserAccount()
    {
        return userAccount;
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
                .append("parkingFeeId", getParkingFeeId())
                .append("parkingSpaceNumber", getParkingSpaceNumber())
                .append("parkingSpaceType", getParkingSpaceType())
                .append("parkingSpaceAddress", getParkingSpaceAddress())
                .append("hourlyParkingFee", getHourlyParkingFee())
                .append("licensePlateNumber", getLicensePlateNumber())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("totalTime", getTotalTime())
                .append("licensePlateRecognition", getLicensePlateRecognition())
                .append("membershipCardNumber", getMembershipCardNumber())
                .append("memberDiscount", getMemberDiscount())
                .append("totalCost", getTotalCost())
                .append("userAccount", getUserAccount())
                .append("recommend", getRecommend())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
