package com.parking.vehicle.controller;


import javax.servlet.http.HttpServletResponse;

import com.parking.vehicle.entity.VehicleInformation;
import com.parking.vehicle.service.VehicleInformationService;
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
import com.parking.common.core.utils.poi.ExcelUtil;
import com.parking.common.core.web.page.TableDataInfo;

import java.util.List;

/**
 * 车辆信息Controller
 *
 * @author parking
 * @date 2022-09-26
 */
@RestController
@RequestMapping("/information")
public class VehicleInformationController extends BaseController
{
    @Autowired
    private VehicleInformationService vehicleInformationService;

    /**
     * 查询车辆信息列表
     */
    @RequiresPermissions("vehicle:information:list")
    @GetMapping("/list")
    public TableDataInfo list(VehicleInformation vehicleInformation)
    {
        startPage();
        List<VehicleInformation> list = vehicleInformationService.selectVehicleInformationList(vehicleInformation);
        return getDataTable(list);
    }

    /**
     * 导出车辆信息列表
     */
    @RequiresPermissions("vehicle:information:export")
    @Log(title = "车辆信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VehicleInformation vehicleInformation)
    {
        List<VehicleInformation> list = vehicleInformationService.selectVehicleInformationList(vehicleInformation);
        ExcelUtil<VehicleInformation> util = new ExcelUtil<VehicleInformation>(VehicleInformation.class);
        util.exportExcel(response, list, "车辆信息数据");
    }

    /**
     * 获取车辆信息详细信息
     */
    @RequiresPermissions("vehicle:information:query")
    @GetMapping(value = "/{vehicleInformationId}")
    public AjaxResult getInfo(@PathVariable("vehicleInformationId") Long vehicleInformationId)
    {
        return AjaxResult.success(vehicleInformationService.selectVehicleInformationByVehicleInformationId(vehicleInformationId));
    }

    /**
     * 新增车辆信息
     */
    @RequiresPermissions("vehicle:information:add")
    @Log(title = "车辆信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VehicleInformation vehicleInformation)
    {
        return toAjax(vehicleInformationService.insertVehicleInformation(vehicleInformation));
    }

    /**
     * 修改车辆信息
     */
    @RequiresPermissions("vehicle:information:edit")
    @Log(title = "车辆信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VehicleInformation vehicleInformation)
    {
        return toAjax(vehicleInformationService.updateVehicleInformation(vehicleInformation));
    }

    /**
     * 删除车辆信息
     */
    @RequiresPermissions("vehicle:information:remove")
    @Log(title = "车辆信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{vehicleInformationIds}")
    public AjaxResult remove(@PathVariable Long[] vehicleInformationIds)
    {
        return toAjax(vehicleInformationService.deleteVehicleInformationByVehicleInformationIds(vehicleInformationIds));
    }
}
