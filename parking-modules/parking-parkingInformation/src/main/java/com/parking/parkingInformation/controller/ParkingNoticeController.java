package com.parking.parkingInformation.controller;

import com.parking.common.core.web.controller.BaseController;
import com.parking.common.core.web.domain.AjaxResult;
import com.parking.common.core.web.page.TableDataInfo;
import com.parking.common.log.annotation.Log;
import com.parking.common.log.enums.BusinessType;
import com.parking.common.security.annotation.RequiresPermissions;
import com.parking.common.security.utils.SecurityUtils;
import com.parking.parkingInformation.entity.ParkingNotice;
import com.parking.parkingInformation.service.ParkingNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * 通知公告 通知公告操作处理
 *
 * @author ljx
 */
@RestController
@RequestMapping("/notice")
public class ParkingNoticeController extends BaseController {
    @Autowired
    private ParkingNoticeService parkingNoticeService;

    /**
     * 查询通知公告列表
     */
    @RequiresPermissions("information:notice:list")
    @GetMapping("/list")
    public TableDataInfo list(ParkingNotice notice){
        startPage();
        List<ParkingNotice> list=parkingNoticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 根据通知公告ID获取详细信息
     */
    @RequiresPermissions("information:notice:query")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable Long noticeId){
        return AjaxResult.success(parkingNoticeService.selectNoticeById(noticeId));
    }
    /**
     * 新增通知公告
     */
    @RequiresPermissions("information:notice:add")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody ParkingNotice notice){
        notice.setCreateBy(SecurityUtils.getUsername());
        return toAjax(parkingNoticeService.addNotice(notice));
    }
    /**
     * 修改通知公告
     */
    @RequiresPermissions("information:notice:update")
    @PutMapping
    public AjaxResult update(@Validated @RequestBody ParkingNotice notice){
        notice.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(parkingNoticeService.updateNotice(notice));
    }
    /**
     * 批量删除通知公告
     */
    @RequiresPermissions("information:notice:delete")
    @Log(title = "通知公告",businessType = BusinessType.DELETE)
    @DeleteMapping("/{noticeIds}")
    public AjaxResult delete(@PathVariable Long[] noticeIds){

        return toAjax(parkingNoticeService.deleteNoticeByIds(noticeIds));
    }

}
