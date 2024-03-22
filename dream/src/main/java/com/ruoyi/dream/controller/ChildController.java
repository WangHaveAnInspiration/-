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
import com.ruoyi.dream.domain.Child;
import com.ruoyi.dream.service.IChildService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 儿童Controller
 * 
 * @author 王庆林
 * @date 2023-11-06
 */
@RestController
@RequestMapping("/dream/child")
public class ChildController extends BaseController
{
    @Autowired
    private IChildService childService;

    /**
     * 查询儿童列表
     */
    @PreAuthorize("@ss.hasPermi('dream:child:list')")
    @GetMapping("/list")
    public TableDataInfo list(Child child)
    {
        startPage();
        List<Child> list = childService.selectChildList(child);
        return getDataTable(list);
    }

    /**
     * 导出儿童列表
     */
    @PreAuthorize("@ss.hasPermi('dream:child:export')")
    @Log(title = "儿童", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Child child)
    {
        List<Child> list = childService.selectChildList(child);
        ExcelUtil<Child> util = new ExcelUtil<Child>(Child.class);
        util.exportExcel(response, list, "儿童数据");
    }

    /**
     * 获取儿童详细信息
     */
    @PreAuthorize("@ss.hasPermi('dream:child:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(childService.selectChildById(id));
    }

    /**
     * 新增儿童
     */
    @PreAuthorize("@ss.hasPermi('dream:child:add')")
    @Log(title = "儿童", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Child child)
    {
        return toAjax(childService.insertChild(child));
    }

    /**
     * 修改儿童
     */
    @PreAuthorize("@ss.hasPermi('dream:child:edit')")
    @Log(title = "儿童", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Child child)
    {
        return toAjax(childService.updateChild(child));
    }

    /**
     * 删除儿童
     */
    @PreAuthorize("@ss.hasPermi('dream:child:remove')")
    @Log(title = "儿童", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(childService.deleteChildByIds(ids));
    }
}
