package com.parking.parkingInformation.mapper;


import com.parking.parkingInformation.entity.ParkingSpaceInformation;

import java.util.List;

/**
 * 车位信息Mapper接口
 *
 * @author ruoyi
 * @date 2022-09-22
 */
public interface ParkingSpaceInformationMapper
{
    /**
     * 查询车位信息
     *
     * @param parkingSpaceInformationId 车位信息主键
     * @return 车位信息
     */
    public ParkingSpaceInformation selectParkingSpaceInformationByParkingSpaceInformationId(Long parkingSpaceInformationId);

    /**
     * 查询车位信息列表
     *
     * @param parkingSpaceInformation 车位信息
     * @return 车位信息集合
     */
    public List<ParkingSpaceInformation> selectParkingSpaceInformationList(ParkingSpaceInformation parkingSpaceInformation);

    /**
     * 新增车位信息
     *
     * @param parkingSpaceInformation 车位信息
     * @return 结果
     */
    public int insertParkingSpaceInformation(ParkingSpaceInformation parkingSpaceInformation);

    /**
     * 修改车位信息
     *
     * @param parkingSpaceInformation 车位信息
     * @return 结果
     */
    public int updateParkingSpaceInformation(ParkingSpaceInformation parkingSpaceInformation);

    /**
     * 删除车位信息
     *
     * @param parkingSpaceInformationId 车位信息主键
     * @return 结果
     */
    public int deleteParkingSpaceInformationByParkingSpaceInformationId(Long parkingSpaceInformationId);

    /**
     * 批量删除车位信息
     *
     * @param parkingSpaceInformationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteParkingSpaceInformationByParkingSpaceInformationIds(Long[] parkingSpaceInformationIds);
}
