package com.bxm.vision.punish.service.message;

import java.io.Serializable;

/**
 * 订单数据传输对象
 *
 * @Author kk.xie
 * @Date 2019/8/3 21:50
 * @Version 1.0
 **/
public class OrderDto implements Serializable {
    private static final long serialVersionUID = -6791383701035450976L;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String commodityId;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }


    @Override
    public String toString() {
        return "OrderDto{" +
                "uid=" + uid +
                ", orderId='" + orderId + '\'' +
                ", commodityId='" + commodityId + '\'' +
                '}';
    }
}
