package com.ruoyi.dream.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dream.mapper.Child_PrizeMapper;
import com.ruoyi.dream.domain.Child_Prize;
import com.ruoyi.dream.service.IChild_PrizeService;

/**
 * 奖品兑换信息表Service业务层处理
 * 
 * @author 王庆林
 * @date 2023-11-06
 */
@Service
public class Child_PrizeServiceImpl implements IChild_PrizeService 
{
    @Autowired
    private Child_PrizeMapper child_PrizeMapper;

    /**
     * 查询奖品兑换信息表
     * 
     * @param id 奖品兑换信息表主键
     * @return 奖品兑换信息表
     */
    @Override
    public Child_Prize selectChild_PrizeById(Long id)
    {
        return child_PrizeMapper.selectChild_PrizeById(id);
    }

    /**
     * 查询奖品兑换信息表列表
     * 
     * @param child_Prize 奖品兑换信息表
     * @return 奖品兑换信息表
     */
    @Override
    public List<Child_Prize> selectChild_PrizeList(Child_Prize child_Prize)
    {
        return child_PrizeMapper.selectChild_PrizeList(child_Prize);
    }

    /**
     * 新增奖品兑换信息表
     * 
     * @param child_Prize 奖品兑换信息表
     * @return 结果
     */
    @Override
    public int insertChild_Prize(Child_Prize child_Prize)
    {
        return child_PrizeMapper.insertChild_Prize(child_Prize);
    }

    /**
     * 修改奖品兑换信息表
     * 
     * @param child_Prize 奖品兑换信息表
     * @return 结果
     */
    @Override
    public int updateChild_Prize(Child_Prize child_Prize)
    {
        return child_PrizeMapper.updateChild_Prize(child_Prize);
    }

    /**
     * 批量删除奖品兑换信息表
     * 
     * @param ids 需要删除的奖品兑换信息表主键
     * @return 结果
     */
    @Override
    public int deleteChild_PrizeByIds(Long[] ids)
    {
        return child_PrizeMapper.deleteChild_PrizeByIds(ids);
    }

    /**
     * 删除奖品兑换信息表信息
     * 
     * @param id 奖品兑换信息表主键
     * @return 结果
     */
    @Override
    public int deleteChild_PrizeById(Long id)
    {
        return child_PrizeMapper.deleteChild_PrizeById(id);
    }
}
