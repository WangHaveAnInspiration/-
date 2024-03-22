package com.ruoyi.dream.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dream.mapper.ChildMapper;
import com.ruoyi.dream.domain.Child;
import com.ruoyi.dream.service.IChildService;

/**
 * 儿童Service业务层处理
 * 
 * @author 王庆林
 * @date 2023-11-06
 */
@Service
public class ChildServiceImpl implements IChildService 
{
    @Autowired
    private ChildMapper childMapper;

    /**
     * 查询儿童
     * 
     * @param id 儿童主键
     * @return 儿童
     */
    @Override
    public Child selectChildById(Long id)
    {
        return childMapper.selectChildById(id);
    }

    /**
     * 查询儿童列表
     * 
     * @param child 儿童
     * @return 儿童
     */
    @Override
    public List<Child> selectChildList(Child child)
    {
        return childMapper.selectChildList(child);
    }

    /**
     * 新增儿童
     * 
     * @param child 儿童
     * @return 结果
     */
    @Override
    public int insertChild(Child child)
    {
        return childMapper.insertChild(child);
    }

    /**
     * 修改儿童
     * 
     * @param child 儿童
     * @return 结果
     */
    @Override
    public int updateChild(Child child)
    {
        return childMapper.updateChild(child);
    }

    /**
     * 批量删除儿童
     * 
     * @param ids 需要删除的儿童主键
     * @return 结果
     */
    @Override
    public int deleteChildByIds(Long[] ids)
    {
        return childMapper.deleteChildByIds(ids);
    }

    /**
     * 删除儿童信息
     * 
     * @param id 儿童主键
     * @return 结果
     */
    @Override
    public int deleteChildById(Long id)
    {
        return childMapper.deleteChildById(id);
    }
}
