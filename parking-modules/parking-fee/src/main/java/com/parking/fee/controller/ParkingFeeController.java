package com.parking.fee.controller;


import javax.servlet.http.HttpServletResponse;

import com.parking.common.core.utils.poi.ExcelUtil;
import com.parking.fee.entity.ParkingFee;
import com.parking.fee.service.ParkingFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.parking.common.log.annotation.Log;
import com.parking.common.log.enums.BusinessType;
import com.parking.common.security.annotation.RequiresPermissions;

import com.parking.common.core.web.controller.BaseController;
import com.parking.common.core.web.domain.AjaxResult;

import com.parking.common.core.web.page.TableDataInfo;

import java.util.List;

/**
 * 停车缴费Controller
 *
 * @author ljx
 * @date 2022-09-27
 */
@RestController
@RequestMapping("/parkingFee")
public class ParkingFeeController extends BaseController
{
    @Autowired
    private ParkingFeeService parkingFeeService;

    /**
     * 查询停车缴费列表
     */
    @RequiresPermissions("fee:parkingFee:list")
    @GetMapping("/list")
    public TableDataInfo list(ParkingFee parkingFee)
    {
        startPage();
        List<ParkingFee> list = parkingFeeService.selectParkingFeeList(parkingFee);
        return getDataTable(list);
    }

    /**
     * 导出停车缴费列表
     */
    @RequiresPermissions("fee:parkingFee:export")
    @Log(title = "停车缴费", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ParkingFee parkingFee)
    {
        List<ParkingFee> list = parkingFeeService.selectParkingFeeList(parkingFee);
        ExcelUtil<ParkingFee> util = new ExcelUtil<ParkingFee>(ParkingFee.class);
        util.exportExcel(response, list, "停车缴费数据");
    }

    /**
     * 获取停车缴费详细信息
     */
    @RequiresPermissions("fee:parkingFee:query")
    @GetMapping(value = "/{parkingFeeId}")
    public AjaxResult getInfo(@PathVariable("parkingFeeId") Long parkingFeeId)
    {
        return AjaxResult.success(parkingFeeService.selectParkingFeeByParkingFeeId(parkingFeeId));
    }

    /**
     * 新增停车缴费
     */
    @RequiresPermissions("fee:parkingFee:add")
    @Log(title = "停车缴费", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ParkingFee parkingFee)
    {
        return toAjax(parkingFeeService.insertParkingFee(parkingFee));
    }

    /**
     * 修改停车缴费
     */
    @RequiresPermissions("fee:parkingFee:edit")
    @Log(title = "停车缴费", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ParkingFee parkingFee)
    {
        return toAjax(parkingFeeService.updateParkingFee(parkingFee));
    }

    /**
     * 删除停车缴费
     */
    @RequiresPermissions("fee:parkingFee:remove")
    @Log(title = "停车缴费", businessType = BusinessType.DELETE)
    @DeleteMapping("/{parkingFeeIds}")
    public AjaxResult remove(@PathVariable Long[] parkingFeeIds)
    {
        return toAjax(parkingFeeService.deleteParkingFeeByParkingFeeIds(parkingFeeIds));
    }
}
