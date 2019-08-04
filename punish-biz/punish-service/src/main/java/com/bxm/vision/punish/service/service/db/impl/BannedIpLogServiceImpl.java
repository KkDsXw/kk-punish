package com.bxm.vision.punish.service.service.db.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bxm.vision.punish.dal.mapper.BannedIpLogMapper;
import com.bxm.vision.punish.model.dao.BannedIpLog;
import com.bxm.vision.punish.service.service.db.BannedIpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * IP封禁日志表 服务实现类
 * </p>
 *
 * @author kk.xie
 * @since 2019-04-11
 */
@Service
public class BannedIpLogServiceImpl extends ServiceImpl<BannedIpLogMapper, BannedIpLog> implements BannedIpLogService {

    @Autowired
    private BannedIpLogMapper bannedIpLogMapper;

    @Override
    public List<BannedIpLog> selectRulerNewestBannedLog(String rulerCode) {
        return bannedIpLogMapper.selectRulerNewestBannedLog(rulerCode);
    }
}
