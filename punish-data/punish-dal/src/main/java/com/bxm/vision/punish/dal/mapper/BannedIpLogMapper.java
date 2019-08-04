package com.bxm.vision.punish.dal.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bxm.vision.punish.model.dao.BannedIpLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * IP封禁日志表 Mapper 接口
 * </p>
 *
 * @author kk.xie
 * @since 2019-04-11
 */
public interface BannedIpLogMapper extends BaseMapper<BannedIpLog> {
    /**
     * 查询规则最新封禁日志
     *
     * @param rulerCode
     * @return java.util.List<com.bxm.vision.punish.model.dao.BannedIpLog>
     * @throws
     * @author kk.xie
     * @date 2019/4/17 17:57
     */
    List<BannedIpLog> selectRulerNewestBannedLog(@Param("rulerCode") String rulerCode);
}
