package com.bxm.vision.punish.facade.model;

import java.io.Serializable;

/**
 * 惩戒服务数据传输对象
 *
 * @Author kk.xie
 * @Date 2019/4/11 15:52
 * @Version 1.0
 **/
public class PunishDto implements Serializable{
    private static final long serialVersionUID = 5114314142530542351L;
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * UUID
     */
    private String uuid;
    /**
     * 规则编码
     */
    private String rulerCode;
    /**
     * iP 集合  10.10.1.10,20.10.2.10
     */
    private String ips;
    /**
     * 用户id QWERTYUIOOOPASDFGHJKLZXCVBNMQQ,QWERTYUIOOOPASDFGHJKLZXCVBNMPP
     */
    private String uids;
    /**
     * 媒体 d0e8ac8b189e4ad98be8d6cc641c9a37,d0e8ac8b189e4ad98be8d6cc641c9a37
     */
    private String appkey;
    /**
     * 广告位 d0e8ac8b189e4ad98be8d6cc641c9a37-1,d0e8ac8b189e4ad98be8d6cc641c9a37-2
     */
    private String positions;

    /**
     * 封禁备注信息-如：阿里云sdk识别出的tags等信息的保存
     */
    private String remark;

    public String getRulerCode() {
        return rulerCode;
    }

    public void setRulerCode(String rulerCode) {
        this.rulerCode = rulerCode;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public String getUids() {
        return uids;
    }

    public void setUids(String uids) {
        this.uids = uids;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "PunishDto{" +
                "taskId='" + taskId + '\'' +
                ", uuid='" + uuid + '\'' +
                ", rulerCode='" + rulerCode + '\'' +
                ", ips='" + ips + '\'' +
                ", uids='" + uids + '\'' +
                ", appkey='" + appkey + '\'' +
                ", positions='" + positions + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
