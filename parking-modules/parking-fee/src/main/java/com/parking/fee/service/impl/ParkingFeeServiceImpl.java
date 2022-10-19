package com.parking.fee.service.impl;


import com.parking.common.core.utils.DateUtils;
import com.parking.fee.entity.ParkingFee;
import com.parking.fee.mapper.ParkingFeeMapper;
import com.parking.fee.service.ParkingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 停车缴费Service业务层处理
 *
 * @author ljx
 * @date 2022-09-27
 */
@Service
public class ParkingFeeServiceImpl implements ParkingFeeService
{
    @Autowired
    private ParkingFeeMapper parkingFeeMapper;

    /**
     * 查询停车缴费
     *
     * @param parkingFeeId 停车缴费主键
     * @return 停车缴费
     */
    @Override
    public ParkingFee selectParkingFeeByParkingFeeId(Long parkingFeeId)
    {
        return parkingFeeMapper.selectParkingFeeByParkingFeeId(parkingFeeId);
    }

    /**
     * 查询停车缴费列表
     *
     * @param parkingFee 停车缴费
     * @return 停车缴费
     */
    @Override
    public List<ParkingFee> selectParkingFeeList(ParkingFee parkingFee)
    {
        return parkingFeeMapper.selectParkingFeeList(parkingFee);
    }

    /**
     * 新增停车缴费
     *
     * @param parkingFee 停车缴费
     * @return 结果
     */
    @Override
    public int insertParkingFee(ParkingFee parkingFee)
    {
        parkingFee.setCreateTime(DateUtils.getNowDate());
        return parkingFeeMapper.insertParkingFee(parkingFee);
    }

    /**
     * 修改停车缴费
     *
     * @param parkingFee 停车缴费
     * @return 结果
     */
    @Override
    public int updateParkingFee(ParkingFee parkingFee)
    {
        parkingFee.setUpdateTime(DateUtils.getNowDate());
        return parkingFeeMapper.updateParkingFee(parkingFee);
    }

    /**
     * 批量删除停车缴费
     *
     * @param parkingFeeIds 需要删除的停车缴费主键
     * @return 结果
     */
    @Override
    public int deleteParkingFeeByParkingFeeIds(Long[] parkingFeeIds)
    {
        return parkingFeeMapper.deleteParkingFeeByParkingFeeIds(parkingFeeIds);
    }

    /**
     * 删除停车缴费信息
     *
     * @param parkingFeeId 停车缴费主键
     * @return 结果
     */
    @Override
    public int deleteParkingFeeByParkingFeeId(Long parkingFeeId)
    {
        return parkingFeeMapper.deleteParkingFeeByParkingFeeId(parkingFeeId);
    }
}
