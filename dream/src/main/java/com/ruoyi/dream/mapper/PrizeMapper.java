package com.ruoyi.dream.mapper;

import java.util.List;

import com.ruoyi.dream.domain.Child;
import com.ruoyi.dream.domain.Prize;
import org.springframework.security.core.userdetails.User;

/**
 * 奖品Mapper接口
 * 
 * @author 王庆林
 * @date 2023-11-03
 */
public interface PrizeMapper 
{
    /**
     * 查询奖品
     * 
     * @param id 奖品主键
     * @return 奖品
     */
    public Prize selectPrizeById(Long id);

    /**
     * 查询奖品列表
     * 
     * @param prize 奖品
     * @return 奖品集合
     */
    public List<Prize> selectPrizeList(Prize prize);

    /**
     * 新增奖品
     * 
     * @param prize 奖品
     * @return 结果
     */
    public int insertPrize(Prize prize);

    /**
     * 修改奖品
     * 
     * @param prize 奖品
     * @return 结果
     */
    public int updatePrize(Prize prize);

    /**
     * 删除奖品
     * 
     * @param id 奖品主键
     * @return 结果
     */
    public int deletePrizeById(Long id);

    /**
     * 批量删除奖品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePrizeByIds(Long[] ids);

    /**
     * 查询儿童
     *
     * @param id 儿童主键
     * @return 儿童
     */

}
