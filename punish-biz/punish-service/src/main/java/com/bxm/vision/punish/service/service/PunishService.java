package com.bxm.vision.punish.service.service;

import com.bxm.vision.punish.facade.model.BannedIpDto;
import com.bxm.vision.punish.facade.model.PunishDto;

/**
 * 惩戒服务
 *
 * @Author kk.xie
 * @Date 2019/4/11 15:59
 * @Version 1.0
 **/
public interface PunishService {
    /**
     * 执行作弊惩戒
     *
     * @param punishDto
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/4/11 16:01
     */
    boolean executePunish(PunishDto punishDto);

    /**
     * 处理Ip
     *
     * @param bannedIpDto
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/2 17:20
     */
    boolean punishIp(BannedIpDto bannedIpDto);

}
