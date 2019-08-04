package com.bxm.vision.punish.facade.model;

import java.io.Serializable;

/**
 * 封禁IP数据传输对象
 *
 * @Author kk.xie
 * @Date 2019/7/2 17:13
 * @Version 1.0
 **/
public class BannedIpDto implements Serializable{
    private static final long serialVersionUID = 8991056503930030661L;
    /**
     * IP
     */
    private String ips;

    /**
     * 封禁操作
     */
    private IpOptionEnum optionEnum;

    /**
     * 用户
     */
    private String user;

    /**
     * 备注
     */
    private String remark;

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public IpOptionEnum getOptionEnum() {
        return optionEnum;
    }

    public void setOptionEnum(IpOptionEnum optionEnum) {
        this.optionEnum = optionEnum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "BannedIpDto{" +
                "ips='" + ips + '\'' +
                ", optionEnum=" + optionEnum +
                ", user='" + user + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
