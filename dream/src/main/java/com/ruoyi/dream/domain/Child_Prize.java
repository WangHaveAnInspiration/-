package com.ruoyi.dream.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖品兑换信息表对象 child_prize
 * 
 * @author 王庆林
 * @date 2023-11-06
 */
public class Child_Prize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 兑换信息id */
    private Long id;

    /** 兑换儿童id */
    @Excel(name = "兑换儿童id")
    private Long childId;

    /** 兑换奖品id */
    @Excel(name = "兑换奖品id")
    private Long prizeId;

    /** 兑换数量 */
    @Excel(name = "兑换数量")
    private Long buyNumber;

    /** 兑换时间信息 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "兑换时间信息", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setChildId(Long childId) 
    {
        this.childId = childId;
    }

    public Long getChildId() 
    {
        return childId;
    }
    public void setPrizeId(Long prizeId) 
    {
        this.prizeId = prizeId;
    }

    public Long getPrizeId() 
    {
        return prizeId;
    }
    public void setBuyNumber(Long buyNumber) 
    {
        this.buyNumber = buyNumber;
    }

    public Long getBuyNumber() 
    {
        return buyNumber;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("childId", getChildId())
            .append("prizeId", getPrizeId())
            .append("buyNumber", getBuyNumber())
            .append("time", getTime())
            .toString();
    }
}
