package com.parking.parkingInformation.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.parking.common.core.annotation.Excel;
import com.parking.common.core.web.domain.BaseEntity;

/**
 * 车位信息对象 parking_space_information
 *
 * @author ruoyi
 * @date 2022-09-22
 */
public class ParkingSpaceInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车位信息ID */
    private Long parkingSpaceInformationId;

    /** 车位号 */
    @Excel(name = "车位号")
    private String parkingSpaceNumber;

    /** 车位类型 */
    @Excel(name = "车位类型")
    private String parkingSpaceType;

    /** 车位地址 */
    @Excel(name = "车位地址")
    private String parkingSpaceAddress;

    /** 车位状态 */
    @Excel(name = "车位状态")
    private String parkingSpaceStatus;

    /** 每小时停车费用 */
    @Excel(name = "每小时停车费用")
    private Long hourlyParkingFee;

    /** 车位备注 */
    @Excel(name = "车位备注")
    private String parkingSpaceRemarks;

    /** 智能推荐 */
    @Excel(name = "智能推荐")
    private Long recommend;

    public void setParkingSpaceInformationId(Long parkingSpaceInformationId)
    {
        this.parkingSpaceInformationId = parkingSpaceInformationId;
    }

    public Long getParkingSpaceInformationId()
    {
        return parkingSpaceInformationId;
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
    public void setParkingSpaceStatus(String parkingSpaceStatus)
    {
        this.parkingSpaceStatus = parkingSpaceStatus;
    }

    public String getParkingSpaceStatus()
    {
        return parkingSpaceStatus;
    }
    public void setHourlyParkingFee(Long hourlyParkingFee)
    {
        this.hourlyParkingFee = hourlyParkingFee;
    }

    public Long getHourlyParkingFee()
    {
        return hourlyParkingFee;
    }
    public void setParkingSpaceRemarks(String parkingSpaceRemarks)
    {
        this.parkingSpaceRemarks = parkingSpaceRemarks;
    }

    public String getParkingSpaceRemarks()
    {
        return parkingSpaceRemarks;
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
                .append("parkingSpaceInformationId", getParkingSpaceInformationId())
                .append("parkingSpaceNumber", getParkingSpaceNumber())
                .append("parkingSpaceType", getParkingSpaceType())
                .append("parkingSpaceAddress", getParkingSpaceAddress())
                .append("parkingSpaceStatus", getParkingSpaceStatus())
                .append("hourlyParkingFee", getHourlyParkingFee())
                .append("parkingSpaceRemarks", getParkingSpaceRemarks())
                .append("recommend", getRecommend())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
