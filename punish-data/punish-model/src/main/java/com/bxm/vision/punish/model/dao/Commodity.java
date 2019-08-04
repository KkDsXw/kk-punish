package com.bxm.vision.punish.model.dao;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author kk.xie
 * @since 2019-08-03
 */
@TableName("tbl_commodity")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 库存
     */
    private Integer inventory;
    /**
     * 上架，0-未上架，1-已上架
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Commodity{" +
        "id=" + id +
        ", name=" + name +
        ", inventory=" + inventory +
        ", status=" + status +
        ", createTime=" + createTime +
        "}";
    }
}
