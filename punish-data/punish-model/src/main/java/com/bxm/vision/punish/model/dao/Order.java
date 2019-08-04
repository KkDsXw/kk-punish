package com.bxm.vision.punish.model.dao;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author kk.xie
 * @since 2019-08-03
 */
@TableName("tbl_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 用户ID
     */
    private String uid;
    /**
     * 商品ID
     */
    private String commodityId;
    /**
     * 执行结果，成功SUCCESS,失败FAIL
     */
    private String executeResult;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getExecuteResult() {
        return executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", uid=" + uid +
        ", commodityId=" + commodityId +
        ", executeResult=" + executeResult +
        ", createTime=" + createTime +
        "}";
    }
}
