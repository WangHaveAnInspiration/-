package com.ruoyi.dream.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖品对象 prize
 * 
 * @author 王庆林
 * @date 2023-11-03
 */
public class Prize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long id;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String picture;

    /** 商品介绍 */
    @Excel(name = "商品介绍")
    private String introduction;

    /** 商品类型 */
    @Excel(name = "商品类型")
    private String type;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 兑换积分 */
    @Excel(name = "兑换积分")
    private Long point;

    /** 选择数量 */
    @Excel(name = "选择数量")
    private Long buyNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPoint(Long point) 
    {
        this.point = point;
    }

    public Long getPoint() 
    {
        return point;
    }
    public void setBuyNumber(Long buyNumber) 
    {
        this.buyNumber = buyNumber;
    }

    public Long getBuyNumber() 
    {
        return buyNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("picture", getPicture())
            .append("introduction", getIntroduction())
            .append("type", getType())
            .append("name", getName())
            .append("point", getPoint())
            .append("buyNumber", getBuyNumber())
            .toString();
    }
}
