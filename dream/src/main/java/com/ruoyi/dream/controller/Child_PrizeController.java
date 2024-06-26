package com.ruoyi.dream.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.dream.domain.Child_Prize;
import com.ruoyi.dream.service.IChild_PrizeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖品兑换信息表Controller
 * 
 * @author 王庆林
 * @date 2023-11-06
 */
@RestController
@RequestMapping("/dream/child_prize")
public class Child_PrizeController extends BaseController
{
    @Autowired
    private IChild_PrizeService child_PrizeService;

    /**
     * 查询奖品兑换信息表列表
     */
    @PreAuthorize("@ss.hasPermi('dream:child_prize:list')")
    @GetMapping("/list")
    public TableDataInfo list(Child_Prize child_Prize)
    {
        startPage();
        List<Child_Prize> list = child_PrizeService.selectChild_PrizeList(child_Prize);
        return getDataTable(list);
    }

    /**
     * 导出奖品兑换信息表列表
     */
    @PreAuthorize("@ss.hasPermi('dream:child_prize:export')")
    @Log(title = "奖品兑换信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Child_Prize child_Prize)
    {
        List<Child_Prize> list = child_PrizeService.selectChild_PrizeList(child_Prize);
        ExcelUtil<Child_Prize> util = new ExcelUtil<Child_Prize>(Child_Prize.class);
        util.exportExcel(response, list, "奖品兑换信息表数据");
    }

    /**
     * 获取奖品兑换信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('dream:child_prize:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(child_PrizeService.selectChild_PrizeById(id));
    }

    /**
     * 新增奖品兑换信息表
     */
    @PreAuthorize("@ss.hasPermi('dream:child_prize:add')")
    @Log(title = "奖品兑换信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Child_Prize child_Prize)
    {
        return toAjax(child_PrizeService.insertChild_Prize(child_Prize));
    }

    /**
     * 修改奖品兑换信息表
     */
    @PreAuthorize("@ss.hasPermi('dream:child_prize:edit')")
    @Log(title = "奖品兑换信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Child_Prize child_Prize)
    {
        return toAjax(child_PrizeService.updateChild_Prize(child_Prize));
    }

    /**
     * 删除奖品兑换信息表
     */
    @PreAuthorize("@ss.hasPermi('dream:child_prize:remove')")
    @Log(title = "奖品兑换信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(child_PrizeService.deleteChild_PrizeByIds(ids));
    }
}
