package com.bxm.vision.punish.service.service.impl;

import com.bxm.vision.punish.facade.model.BannedIpDto;
import com.bxm.vision.punish.facade.model.IpOptionEnum;
import com.bxm.vision.punish.facade.model.PunishDto;
import com.bxm.vision.punish.integration.ads.AdsPunishService;
import com.bxm.vision.punish.model.dao.BannedIpLog;
import com.bxm.vision.punish.service.service.CheatPushService;
import com.bxm.vision.punish.service.service.PunishService;
import com.bxm.vision.punish.service.service.db.BannedIpLogService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 惩戒服务实现
 *
 * @Author kk.xie
 * @Date 2019/4/11 16:00
 * @Version 1.0
 **/
@Service
public class PunishServiceImpl implements PunishService {

    private Logger logger = LoggerFactory.getLogger(PunishServiceImpl.class);

    @Autowired
    private BannedIpLogService bannedIpLogService;

    @Autowired
    private CheatPushService cheatPushService;

    /**
     * 单次推送IP的数量
     */
    private Integer pushSize = 500;

    @Override
    public boolean executePunish(PunishDto punishDto) {
        // 惩戒IP
        punishIp(punishDto);
        // 惩戒UID
        punishUid(punishDto);
        // 惩戒广告位
        punishPositions(punishDto);
        // 惩戒媒体
        punishAppkey(punishDto);

        return true;
    }

    /**
     * 惩戒媒体
     *
     * @param punishDto
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/18 14:27
     */
    private boolean punishAppkey(PunishDto punishDto) {
        return true;
    }

    /**
     * 惩戒广告位
     *
     * @param punishDto
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/18 14:27
     */
    private boolean punishPositions(PunishDto punishDto) {
        return true;
    }

    /**
     * 惩戒UID
     *
     * @param punishDto
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/18 14:25
     */
    private boolean punishUid(PunishDto punishDto) {
        String uids = punishDto.getUids();
        if(StringUtils.isBlank(uids)){
            return true;
        }

        String[] uidList = uids.split(",");
        Set<String> uidSet = Sets.newHashSet(uidList);

        logger.info("punish taskId: {}, uuid: {}, rulerCode: {}, uidList.size: {}",
                punishDto.getTaskId(), punishDto.getUuid(), punishDto.getRulerCode(), uidSet.size());

        boolean success = cheatPushService.pushUid(Lists.newArrayList(uidSet));

        return success;
    }

    /**
     * 惩戒IP
     *
     * @param punishDto
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/18 14:25
     */
    private boolean punishIp(PunishDto punishDto) {
        if(StringUtils.isBlank(punishDto.getIps())){
            return true;
        }

        List<String> ipList = Lists.newArrayList(punishDto.getIps().split(","));
        // IP封禁
        boolean success = cheatPushService.pushIp(ipList);
        // 保存封禁日志
        saveLog(ipList, punishDto, success);
        return true;
    }

    private boolean saveLog(List<String> ipList, PunishDto punishDto, boolean success) {
        int size = ipList.size();

        // 封禁IP前需要剔除已经封禁的IP，以上一次执行结果为准
        List<String> oldBannedIpList = Lists.newArrayList();
        List<BannedIpLog> bannedIpLogs = bannedIpLogService.selectRulerNewestBannedLog(punishDto.getRulerCode());
        if(CollectionUtils.isNotEmpty(bannedIpLogs)){
            for(BannedIpLog bannedIpLog : bannedIpLogs){
                String ips = bannedIpLog.getIps();
                oldBannedIpList.addAll(Lists.newArrayList(ips.split(",")));
            }
        }

        // 移除已经封禁的IP
        for(String ip : oldBannedIpList){
            if(ipList.contains(ip)){
                ipList.remove(ip);
            }
        }

        int bannedIpSize = ipList.size();
        logger.info("punish taskId: {}, uuid: {}, rulerCode: {}, ipList.size: {}, bannedIpList.size: {}",
                punishDto.getTaskId(), punishDto.getUuid(), punishDto.getRulerCode(), size, bannedIpSize);

        // 无需要封禁的IP
        if(CollectionUtils.isEmpty(ipList)){
            return true;
        }

        if(bannedIpSize <= pushSize){
            // 保存
            BannedIpLog bannedIpLog = ofBannedIpLog(success, ipList, punishDto);
            return bannedIpLogService.insert(bannedIpLog);
        }else{
            int index = pushSize;
            int listSize = ipList.size();
            for (int i = 0; i < listSize; i += pushSize) {
                List<String> subIpList = ipList.subList(i, index);
                // 保存
                BannedIpLog bannedIpLog = ofBannedIpLog(success, subIpList, punishDto);
                bannedIpLogService.insert(bannedIpLog);

                if(index + pushSize > listSize){
                    index = listSize;
                } else {
                    index += pushSize;
                }
            }
        }

        return true;
    }

    @Override
    public boolean punishIp(BannedIpDto bannedIpDto) {
        String ips = bannedIpDto.getIps();
        int size = StringUtils.isNotEmpty(ips) ? ips.split(",").length : 0;

        IpOptionEnum optionEnum = bannedIpDto.getOptionEnum();

        boolean success = false;
        if(IpOptionEnum.BANNED.equals(optionEnum)){
            success = cheatPushService.pushIp(Lists.newArrayList(ips.split(",")));
        }else if(IpOptionEnum.RELIEVE.equals(optionEnum)){
            success = cheatPushService.relieveIp(Lists.newArrayList(ips.split(",")));
        }

        BannedIpLog bannedIpLog = new BannedIpLog();
        bannedIpLog.setExecuteResult(success ? "SUCCESS" : "FAIL");
        bannedIpLog.setIps(ips);
        bannedIpLog.setIpsLength(size);
        bannedIpLog.setRulerCode(optionEnum.toString());
        bannedIpLog.setUuid(bannedIpDto.getUser());
        bannedIpLog.setRemark(bannedIpDto.getRemark());

        bannedIpLogService.insert(bannedIpLog);
        return false;
    }

    private String getIps(List<String> ipList){
        StringBuilder ips = new StringBuilder();
        ipList.forEach(ip -> ips.append(ip).append(","));
        String ipsString = ips.toString();
        return StringUtils.removeEnd(ipsString, ",");
    }

    private BannedIpLog ofBannedIpLog(boolean success, List<String> ipList, PunishDto punishDto){
        // 保存
        BannedIpLog bannedIpLog = new BannedIpLog();
        bannedIpLog.setExecuteResult(success ? "SUCCESS" : "FAIL");
        bannedIpLog.setIps(getIps(ipList));
        bannedIpLog.setIpsLength(ipList.size());
        bannedIpLog.setRulerCode(punishDto.getRulerCode());
        bannedIpLog.setUuid(punishDto.getUuid());
        bannedIpLog.setRemark(punishDto.getRemark());

        return bannedIpLog;
    }
}
