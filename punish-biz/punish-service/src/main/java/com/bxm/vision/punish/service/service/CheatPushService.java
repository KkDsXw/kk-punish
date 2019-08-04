package com.bxm.vision.punish.service.service;

import java.util.List;

/**
 * 作弊数据推送服务
 *
 * @Author kk.xie
 * @Date 2019/7/24 11:15
 * @Version 1.0
 **/
public interface CheatPushService {
    /**
     * 作弊UID推送
     *
     * @param uidList
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/24 11:16
     */
    boolean pushUid(List<String> uidList);
    /**
     * 释放UID
     *
     * @param uidList
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/24 14:50
     */
    boolean relieveUid(List<String> uidList);
    /**
     * 作弊IP推送
     *
     * @param ipList
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/24 11:18
     */
    boolean pushIp(List<String> ipList);

    /**
     * 释放ip
     *
     * @param ipList
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/24 14:50
     */
    boolean relieveIp(List<String> ipList);
}
