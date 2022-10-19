package com.parking.parkingInformation.service.impl;


import com.parking.common.core.utils.DateUtils;
import com.parking.parkingInformation.entity.ParkingSpaceInformation;
import com.parking.parkingInformation.mapper.ParkingSpaceInformationMapper;
import com.parking.parkingInformation.service.ParkingSpaceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 车位信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-09-22
 */
@Service
public class ParkingSpaceInformationServiceImpl implements ParkingSpaceInformationService
{
    @Autowired
    private ParkingSpaceInformationMapper parkingSpaceInformationMapper;

    /**
     * 查询车位信息
     *
     * @param parkingSpaceInformationId 车位信息主键
     * @return 车位信息
     */
    @Override
    public ParkingSpaceInformation selectParkingSpaceInformationByParkingSpaceInformationId(Long parkingSpaceInformationId)
    {
        return parkingSpaceInformationMapper.selectParkingSpaceInformationByParkingSpaceInformationId(parkingSpaceInformationId);
    }

    /**
     * 查询车位信息列表
     *
     * @param parkingSpaceInformation 车位信息
     * @return 车位信息
     */
    @Override
    public List<ParkingSpaceInformation> selectParkingSpaceInformationList(ParkingSpaceInformation parkingSpaceInformation)
    {
        return parkingSpaceInformationMapper.selectParkingSpaceInformationList(parkingSpaceInformation);
    }

    /**
     * 新增车位信息
     *
     * @param parkingSpaceInformation 车位信息
     * @return 结果
     */
    @Override
    public int insertParkingSpaceInformation(ParkingSpaceInformation parkingSpaceInformation)
    {
        parkingSpaceInformation.setCreateTime(DateUtils.getNowDate());
        return parkingSpaceInformationMapper.insertParkingSpaceInformation(parkingSpaceInformation);
    }

    /**
     * 修改车位信息
     *
     * @param parkingSpaceInformation 车位信息
     * @return 结果
     */
    @Override
    public int updateParkingSpaceInformation(ParkingSpaceInformation parkingSpaceInformation)
    {
        parkingSpaceInformation.setUpdateTime(DateUtils.getNowDate());
        return parkingSpaceInformationMapper.updateParkingSpaceInformation(parkingSpaceInformation);
    }

    /**
     * 批量删除车位信息
     *
     * @param parkingSpaceInformationIds 需要删除的车位信息主键
     * @return 结果
     */
    @Override
    public int deleteParkingSpaceInformationByParkingSpaceInformationIds(Long[] parkingSpaceInformationIds)
    {
        return parkingSpaceInformationMapper.deleteParkingSpaceInformationByParkingSpaceInformationIds(parkingSpaceInformationIds);
    }

    /**
     * 删除车位信息信息
     *
     * @param parkingSpaceInformationId 车位信息主键
     * @return 结果
     */
    @Override
    public int deleteParkingSpaceInformationByParkingSpaceInformationId(Long parkingSpaceInformationId)
    {
        return parkingSpaceInformationMapper.deleteParkingSpaceInformationByParkingSpaceInformationId(parkingSpaceInformationId);
    }
}
