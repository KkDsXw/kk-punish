package com.bxm.vision.punish.service.service.db;

import com.baomidou.mybatisplus.service.IService;
import com.bxm.vision.punish.model.dao.BannedIpLog;

import java.util.List;

/**
 * <p>
 * IP封禁日志表 服务类
 * </p>
 *
 * @author kk.xie
 * @since 2019-04-11
 */
public interface BannedIpLogService extends IService<BannedIpLog> {
    /**
     * 查询规则最新封禁日志
     *
     * @param rulerCode
     * @return java.util.List<com.bxm.vision.punish.model.dao.BannedIpLog>
     * @throws
     * @author kk.xie
     * @date 2019/4/17 17:56
     */
    List<BannedIpLog> selectRulerNewestBannedLog(String rulerCode);
}
