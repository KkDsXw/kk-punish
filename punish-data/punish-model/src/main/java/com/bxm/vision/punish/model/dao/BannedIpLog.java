package com.bxm.vision.punish.model.dao;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * IP封禁日志表
 * </p>
 *
 * @author kk.xie
 * @since 2019-04-11
 */
@TableName("tbl_banned_ip_log")
public class BannedIpLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * uuid
     */
    private String uuid;
    /**
     * 规则编码
     */
    private String rulerCode;
    /**
     * 封禁ip集合
     */
    private String ips;
    /**
     * 封禁ip集合长度
     */
    private Integer ipsLength;
    /**
     * 执行结果，成功SUCCESS,失败FAIL
     */
    private String executeResult;
    /**
     * 备注
     */
    private String remark;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public Integer getIpsLength() {
        return ipsLength;
    }

    public void setIpsLength(Integer ipsLength) {
        this.ipsLength = ipsLength;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "BannedIpLog{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", rulerCode='" + rulerCode + '\'' +
                ", ips='" + ips + '\'' +
                ", ipsLength=" + ipsLength +
                ", executeResult='" + executeResult + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
