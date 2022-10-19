package com.parking.parkingInformation.controller;


import com.parking.parkingInformation.entity.ParkingSpaceInformation;
import com.parking.parkingInformation.service.ParkingSpaceInformationService;
import com.parking.common.core.web.controller.BaseController;
import com.parking.common.core.web.domain.AjaxResult;
import com.parking.common.core.web.page.TableDataInfo;
import com.parking.common.log.annotation.Log;
import com.parking.common.log.enums.BusinessType;
import com.parking.common.security.annotation.RequiresPermissions;
import com.parking.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 车位信息 信息操作处理
 *
 * @author ljx
 */
@RestController
@RequestMapping("/information")
public class ParkingSpaceInformationController extends BaseController {

    @Autowired
    private ParkingSpaceInformationService parkingSpaceInformationService;

    /**
     * 获取车位信息列表
     */
    @RequiresPermissions("information:spaceInformation:list")
    @GetMapping("/list")
    public TableDataInfo list(ParkingSpaceInformation information){
        startPage();
        List<ParkingSpaceInformation> list=parkingSpaceInformationService.selectParkingSpaceInformationList(information);
        return getDataTable(list);
    }

    /**
     * 获取车位ID获取详细信息
     */
    @RequiresPermissions("information:spaceInformation:query")
    @GetMapping("/parking_space_information_id")
    public AjaxResult getInfo(@PathVariable Long parking_space_information_id){

        return AjaxResult.success(parkingSpaceInformationService.selectParkingSpaceInformationByParkingSpaceInformationId(parking_space_information_id));
    }

    /**
     * 新增车位信息
     */
    @RequiresPermissions("information:spaceInformation:add")
    @Log(title = "车位信息",businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ParkingSpaceInformation information){
        information.setCreateBy(SecurityUtils.getUsername());
        return toAjax(parkingSpaceInformationService.insertParkingSpaceInformation(information));
    }

    /**
     * 修改车位信息
     */
    @RequiresPermissions("information:spaceInformation:update")
    @Log(title = "车位信息",businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult update(@Validated @RequestBody ParkingSpaceInformation information){
        information.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(parkingSpaceInformationService.updateParkingSpaceInformation(information));
    }

    /**
     * 删除车位信息
     */
    @RequiresPermissions("information:spaceInformation:remove")
    @Log(title = "车位信息",businessType = BusinessType.DELETE)
    @DeleteMapping("/{parking_space_information_ids}")
    public AjaxResult remove(@PathVariable Long[] parking_space_information_ids){

        return toAjax(parkingSpaceInformationService.deleteParkingSpaceInformationByParkingSpaceInformationIds(parking_space_information_ids));
    }
}
