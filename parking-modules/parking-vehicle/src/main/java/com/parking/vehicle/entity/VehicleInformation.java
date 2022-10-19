package com.parking.vehicle.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.parking.common.core.annotation.Excel;
import com.parking.common.core.web.domain.BaseEntity;

/**
 * 车辆信息对象 vehicle_information
 *
 * @author ljx
 * @date 2022-09-26
 */
public class VehicleInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车辆信息ID */
    private Long vehicleInformationId;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String licensePlateNumber;

    /** 车型 */
    @Excel(name = "车型")
    private String model;

    /** 颜色 */
    @Excel(name = "颜色")
    private String colour;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 身份证 */
    private String id;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactNumber;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private Long userAccount;

    /** 智能推荐 */
    @Excel(name = "智能推荐")
    private Long recommend;

    public void setVehicleInformationId(Long vehicleInformationId)
    {
        this.vehicleInformationId = vehicleInformationId;
    }

    public Long getVehicleInformationId()
    {
        return vehicleInformationId;
    }
    public void setLicensePlateNumber(String licensePlateNumber)
    {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber()
    {
        return licensePlateNumber;
    }
    public void setModel(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }
    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public String getColour()
    {
        return colour;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber()
    {
        return contactNumber;
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
                .append("vehicleInformationId", getVehicleInformationId())
                .append("licensePlateNumber", getLicensePlateNumber())
                .append("model", getModel())
                .append("colour", getColour())
                .append("userName", getUserName())
                .append("id", getId())
                .append("contactNumber", getContactNumber())
                .append("userAccount", getUserAccount())
                .append("recommend", getRecommend())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
