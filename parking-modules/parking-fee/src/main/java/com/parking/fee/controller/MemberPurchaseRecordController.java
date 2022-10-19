package com.parking.fee.controller;


import javax.servlet.http.HttpServletResponse;

import com.parking.fee.entity.MemberPurchaseRecord;
import com.parking.fee.service.MemberPurchaseRecordService;
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
 * 会员购买记录Controller
 *
 * @author ljx
 * @date 2022-09-29
 */
@RestController
@RequestMapping("/record")
public class MemberPurchaseRecordController extends BaseController
{
    @Autowired
    private MemberPurchaseRecordService memberPurchaseRecordService;

    /**
     * 查询会员购买记录列表
     */
    @RequiresPermissions("fee:record:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberPurchaseRecord memberPurchaseRecord)
    {
        startPage();
        List<MemberPurchaseRecord> list = memberPurchaseRecordService.selectMemberPurchaseRecordList(memberPurchaseRecord);
        return getDataTable(list);
    }

    /**
     * 导出会员购买记录列表
     */
    @RequiresPermissions("fee:record:export")
    @Log(title = "会员购买记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberPurchaseRecord memberPurchaseRecord)
    {
        List<MemberPurchaseRecord> list = memberPurchaseRecordService.selectMemberPurchaseRecordList(memberPurchaseRecord);
        ExcelUtil<MemberPurchaseRecord> util = new ExcelUtil<MemberPurchaseRecord>(MemberPurchaseRecord.class);
        util.exportExcel(response, list, "会员购买记录数据");
    }

    /**
     * 获取会员购买记录详细信息
     */
    @RequiresPermissions("fee:record:query")
    @GetMapping(value = "/{memberPurchaseRecordId}")
    public AjaxResult getInfo(@PathVariable("memberPurchaseRecordId") Long memberPurchaseRecordId)
    {
        return AjaxResult.success(memberPurchaseRecordService.selectMemberPurchaseRecordByMemberPurchaseRecordId(memberPurchaseRecordId));
    }

    /**
     * 新增会员购买记录
     */
    @RequiresPermissions("fee:record:add")
    @Log(title = "会员购买记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberPurchaseRecord memberPurchaseRecord)
    {
        return toAjax(memberPurchaseRecordService.insertMemberPurchaseRecord(memberPurchaseRecord));
    }

    /**
     * 修改会员购买记录
     */
    @RequiresPermissions("fee:record:edit")
    @Log(title = "会员购买记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberPurchaseRecord memberPurchaseRecord)
    {
        return toAjax(memberPurchaseRecordService.updateMemberPurchaseRecord(memberPurchaseRecord));
    }

    /**
     * 删除会员购买记录
     */
    @RequiresPermissions("fee:record:remove")
    @Log(title = "会员购买记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{memberPurchaseRecordIds}")
    public AjaxResult remove(@PathVariable Long[] memberPurchaseRecordIds)
    {
        return toAjax(memberPurchaseRecordService.deleteMemberPurchaseRecordByMemberPurchaseRecordIds(memberPurchaseRecordIds));
    }
}
