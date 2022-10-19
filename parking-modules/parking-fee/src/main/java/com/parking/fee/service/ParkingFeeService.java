package com.parking.fee.service;


import com.parking.fee.entity.ParkingFee;

import java.util.List;

/**
 * 停车缴费Service接口
 *
 * @author ljx
 * @date 2022-09-27
 */
public interface ParkingFeeService
{
    /**
     * 查询停车缴费
     *
     * @param parkingFeeId 停车缴费主键
     * @return 停车缴费
     */
    public ParkingFee selectParkingFeeByParkingFeeId(Long parkingFeeId);

    /**
     * 查询停车缴费列表
     *
     * @param parkingFee 停车缴费
     * @return 停车缴费集合
     */
    public List<ParkingFee> selectParkingFeeList(ParkingFee parkingFee);

    /**
     * 新增停车缴费
     *
     * @param parkingFee 停车缴费
     * @return 结果
     */
    public int insertParkingFee(ParkingFee parkingFee);

    /**
     * 修改停车缴费
     *
     * @param parkingFee 停车缴费
     * @return 结果
     */
    public int updateParkingFee(ParkingFee parkingFee);

    /**
     * 批量删除停车缴费
     *
     * @param parkingFeeIds 需要删除的停车缴费主键集合
     * @return 结果
     */
    public int deleteParkingFeeByParkingFeeIds(Long[] parkingFeeIds);

    /**
     * 删除停车缴费信息
     *
     * @param parkingFeeId 停车缴费主键
     * @return 结果
     */
    public int deleteParkingFeeByParkingFeeId(Long parkingFeeId);
}
