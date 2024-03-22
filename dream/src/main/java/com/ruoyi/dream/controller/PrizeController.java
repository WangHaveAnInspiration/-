package com.ruoyi.dream.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.dream.domain.Child;
import com.ruoyi.dream.domain.Child_Prize;
import com.ruoyi.dream.service.IChildService;
import com.ruoyi.dream.service.IChild_PrizeService;
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
import com.ruoyi.dream.domain.Prize;
import com.ruoyi.dream.service.IPrizeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖品Controller
 * 
 * @author 王庆林
 * @date 2023-11-03
 */
@RestController
@RequestMapping("/dream/prize")
public class PrizeController extends BaseController
{
    @Autowired
    private IPrizeService prizeService;

    @Autowired
    private IChildService childService;

    @Autowired
    private IChild_PrizeService child_PrizeService;

    /**
     * 查询奖品列表
     */
    @PreAuthorize("@ss.hasPermi('dream:prize:list')")
    @GetMapping("/list")
    public TableDataInfo list(Prize prize)
    {
        startPage();
        List<Prize> list = prizeService.selectPrizeList(prize);
        return getDataTable(list);
    }

    /**
     * 导出奖品列表
     */
    @PreAuthorize("@ss.hasPermi('dream:prize:export')")
    @Log(title = "奖品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Prize prize)
    {
        List<Prize> list = prizeService.selectPrizeList(prize);
        ExcelUtil<Prize> util = new ExcelUtil<Prize>(Prize.class);
        util.exportExcel(response, list, "奖品数据");
    }

    /**
     * 获取奖品详细信息
     */
    @PreAuthorize("@ss.hasPermi('dream:prize:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(prizeService.selectPrizeById(id));
    }

    /**
     * 获取儿童详细信息
     */
    @PreAuthorize("@ss.hasPermi('dream:prize:')")
    @GetMapping
    public AjaxResult getChildInfo()
    {
        Long user_id = SecurityUtils.getUserId();
        return success(childService.selectChildById(user_id));
    }

    /**
     * 新增奖品
     */
    @PreAuthorize("@ss.hasPermi('dream:prize:add')")
    @Log(title = "奖品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Prize prize)
    {
        return toAjax(prizeService.insertPrize(prize));
    }

    /**
     * 修改奖品
     */
    @PreAuthorize("@ss.hasPermi('dream:prize:edit')")
    @Log(title = "奖品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Prize prize)
    {
        return toAjax(prizeService.updatePrize(prize));
    }

    /**
     * 删除奖品
     */
    @PreAuthorize("@ss.hasPermi('dream:prize:remove')")
    @Log(title = "奖品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(prizeService.deletePrizeByIds(ids));
    }
}
