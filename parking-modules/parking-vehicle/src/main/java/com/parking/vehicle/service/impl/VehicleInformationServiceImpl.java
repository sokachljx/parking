package com.parking.vehicle.service.impl;


import com.parking.vehicle.entity.VehicleInformation;
import com.parking.vehicle.mapper.VehicleInformationMapper;
import com.parking.vehicle.service.VehicleInformationService;
import com.parking.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 车辆信息Service业务层处理
 *
 * @author ljx
 * @date 2022-09-26
 */
@Service
public class VehicleInformationServiceImpl implements VehicleInformationService
{
    @Autowired
    private VehicleInformationMapper vehicleInformationMapper;

    /**
     * 查询车辆信息
     *
     * @param vehicleInformationId 车辆信息主键
     * @return 车辆信息
     */
    @Override
    public VehicleInformation selectVehicleInformationByVehicleInformationId(Long vehicleInformationId)
    {
        return vehicleInformationMapper.selectVehicleInformationByVehicleInformationId(vehicleInformationId);
    }

    /**
     * 查询车辆信息列表
     *
     * @param vehicleInformation 车辆信息
     * @return 车辆信息
     */
    @Override
    public List<VehicleInformation> selectVehicleInformationList(VehicleInformation vehicleInformation)
    {
        return vehicleInformationMapper.selectVehicleInformationList(vehicleInformation);
    }

    /**
     * 新增车辆信息
     *
     * @param vehicleInformation 车辆信息
     * @return 结果
     */
    @Override
    public int insertVehicleInformation(VehicleInformation vehicleInformation)
    {
        vehicleInformation.setCreateTime(DateUtils.getNowDate());
        return vehicleInformationMapper.insertVehicleInformation(vehicleInformation);
    }

    /**
     * 修改车辆信息
     *
     * @param vehicleInformation 车辆信息
     * @return 结果
     */
    @Override
    public int updateVehicleInformation(VehicleInformation vehicleInformation)
    {
        vehicleInformation.setUpdateTime(DateUtils.getNowDate());
        return vehicleInformationMapper.updateVehicleInformation(vehicleInformation);
    }

    /**
     * 批量删除车辆信息
     *
     * @param vehicleInformationIds 需要删除的车辆信息主键
     * @return 结果
     */
    @Override
    public int deleteVehicleInformationByVehicleInformationIds(Long[] vehicleInformationIds)
    {
        return vehicleInformationMapper.deleteVehicleInformationByVehicleInformationIds(vehicleInformationIds);
    }

    /**
     * 删除车辆信息信息
     *
     * @param vehicleInformationId 车辆信息主键
     * @return 结果
     */
    @Override
    public int deleteVehicleInformationByVehicleInformationId(Long vehicleInformationId)
    {
        return vehicleInformationMapper.deleteVehicleInformationByVehicleInformationId(vehicleInformationId);
    }
}
