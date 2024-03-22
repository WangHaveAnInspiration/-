package com.ruoyi.dream.service;

import java.util.List;
import com.ruoyi.dream.domain.Child;

/**
 * 儿童Service接口
 * 
 * @author 王庆林
 * @date 2023-11-06
 */
public interface IChildService 
{
    /**
     * 查询儿童
     * 
     * @param id 儿童主键
     * @return 儿童
     */
    public Child selectChildById(Long id);

    /**
     * 查询儿童列表
     * 
     * @param child 儿童
     * @return 儿童集合
     */
    public List<Child> selectChildList(Child child);

    /**
     * 新增儿童
     * 
     * @param child 儿童
     * @return 结果
     */
    public int insertChild(Child child);

    /**
     * 修改儿童
     * 
     * @param child 儿童
     * @return 结果
     */
    public int updateChild(Child child);

    /**
     * 批量删除儿童
     * 
     * @param ids 需要删除的儿童主键集合
     * @return 结果
     */
    public int deleteChildByIds(Long[] ids);

    /**
     * 删除儿童信息
     *
     * @param id 儿童主键
     * @return 结果
     */
    public int deleteChildById(Long id);
}
