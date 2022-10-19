package com.parking.vehicle.service;


import com.parking.vehicle.entity.VehicleInformation;

import java.util.List;

/**
 * 车辆信息Service接口
 *
 * @author ljx
 * @date 2022-09-26
 */
public interface VehicleInformationService
{
    /**
     * 查询车辆信息
     *
     * @param vehicleInformationId 车辆信息主键
     * @return 车辆信息
     */
    public VehicleInformation selectVehicleInformationByVehicleInformationId(Long vehicleInformationId);

    /**
     * 查询车辆信息列表
     *
     * @param vehicleInformation 车辆信息
     * @return 车辆信息集合
     */
    public List<VehicleInformation> selectVehicleInformationList(VehicleInformation vehicleInformation);

    /**
     * 新增车辆信息
     *
     * @param vehicleInformation 车辆信息
     * @return 结果
     */
    public int insertVehicleInformation(VehicleInformation vehicleInformation);

    /**
     * 修改车辆信息
     *
     * @param vehicleInformation 车辆信息
     * @return 结果
     */
    public int updateVehicleInformation(VehicleInformation vehicleInformation);

    /**
     * 批量删除车辆信息
     *
     * @param vehicleInformationIds 需要删除的车辆信息主键集合
     * @return 结果
     */
    public int deleteVehicleInformationByVehicleInformationIds(Long[] vehicleInformationIds);

    /**
     * 删除车辆信息信息
     *
     * @param vehicleInformationId 车辆信息主键
     * @return 结果
     */
    public int deleteVehicleInformationByVehicleInformationId(Long vehicleInformationId);
}
