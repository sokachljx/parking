package com.parking.fee.controller;


import javax.servlet.http.HttpServletResponse;

import com.parking.fee.entity.MembershipCardInformation;
import com.parking.fee.service.MembershipCardInformationService;
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
 * 会员卡信息Controller
 *
 * @author parking
 * @date 2022-09-28
 */
@RestController
@RequestMapping("/membershipCardInformation")
public class MembershipCardInformationController extends BaseController
{
    @Autowired
    private MembershipCardInformationService membershipCardInformationService;

    /**
     * 查询会员卡信息列表
     */
    @RequiresPermissions("fee:membershipCardInformation:list")
    @GetMapping("/list")
    public TableDataInfo list(MembershipCardInformation membershipCardInformation)
    {
        startPage();
        List<MembershipCardInformation> list = membershipCardInformationService.selectMembershipCardInformationList(membershipCardInformation);
        return getDataTable(list);
    }

    /**
     * 导出会员卡信息列表
     */
    @RequiresPermissions("fee:membershipCardInformation:export")
    @Log(title = "会员卡信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MembershipCardInformation membershipCardInformation)
    {
        List<MembershipCardInformation> list = membershipCardInformationService.selectMembershipCardInformationList(membershipCardInformation);
        ExcelUtil<MembershipCardInformation> util = new ExcelUtil<MembershipCardInformation>(MembershipCardInformation.class);
        util.exportExcel(response, list, "会员卡信息数据");
    }

    /**
     * 获取会员卡信息详细信息
     */
    @RequiresPermissions("fee:membershipCardInformation:query")
    @GetMapping(value = "/{membershipCardInformationId}")
    public AjaxResult getInfo(@PathVariable("membershipCardInformationId") Long membershipCardInformationId)
    {
        return AjaxResult.success(membershipCardInformationService.selectMembershipCardInformationByMembershipCardInformationId(membershipCardInformationId));
    }

    /**
     * 新增会员卡信息
     */
    @RequiresPermissions("fee:membershipCardInformation:add")
    @Log(title = "会员卡信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MembershipCardInformation membershipCardInformation)
    {
        return toAjax(membershipCardInformationService.insertMembershipCardInformation(membershipCardInformation));
    }

    /**
     * 修改会员卡信息
     */
    @RequiresPermissions("fee:membershipCardInformation:edit")
    @Log(title = "会员卡信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MembershipCardInformation membershipCardInformation)
    {
        return toAjax(membershipCardInformationService.updateMembershipCardInformation(membershipCardInformation));
    }

    /**
     * 删除会员卡信息
     */
    @RequiresPermissions("fee:membershipCardInformation:remove")
    @Log(title = "会员卡信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{membershipCardInformationIds}")
    public AjaxResult remove(@PathVariable Long[] membershipCardInformationIds)
    {
        return toAjax(membershipCardInformationService.deleteMembershipCardInformationByMembershipCardInformationIds(membershipCardInformationIds));
    }
}
