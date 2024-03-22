package com.ruoyi.dream.service;

import java.util.List;
import com.ruoyi.dream.domain.Child_Prize;

/**
 * 奖品兑换信息表Service接口
 * 
 * @author 王庆林
 * @date 2023-11-06
 */
public interface IChild_PrizeService 
{
    /**
     * 查询奖品兑换信息表
     * 
     * @param id 奖品兑换信息表主键
     * @return 奖品兑换信息表
     */
    public Child_Prize selectChild_PrizeById(Long id);

    /**
     * 查询奖品兑换信息表列表
     * 
     * @param child_Prize 奖品兑换信息表
     * @return 奖品兑换信息表集合
     */
    public List<Child_Prize> selectChild_PrizeList(Child_Prize child_Prize);

    /**
     * 新增奖品兑换信息表
     * 
     * @param child_Prize 奖品兑换信息表
     * @return 结果
     */
    public int insertChild_Prize(Child_Prize child_Prize);

    /**
     * 修改奖品兑换信息表
     * 
     * @param child_Prize 奖品兑换信息表
     * @return 结果
     */
    public int updateChild_Prize(Child_Prize child_Prize);

    /**
     * 批量删除奖品兑换信息表
     * 
     * @param ids 需要删除的奖品兑换信息表主键集合
     * @return 结果
     */
    public int deleteChild_PrizeByIds(Long[] ids);

    /**
     * 删除奖品兑换信息表信息
     * 
     * @param id 奖品兑换信息表主键
     * @return 结果
     */
    public int deleteChild_PrizeById(Long id);
}
