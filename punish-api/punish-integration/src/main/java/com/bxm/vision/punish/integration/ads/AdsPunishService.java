package com.bxm.vision.punish.integration.ads;

/**
 * 广告惩戒服务
 *
 * @Author kk.xie
 * @Date 2019/4/11 16:07
 * @Version 1.0
 **/
@Deprecated
public interface AdsPunishService {

    /**
     * 广告作弊封禁
     *
     * @param ips
     * @param uids
     * @param appkeys
     * @param positions
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/4/11 17:23
     */
    boolean executePunish(String ips, String uids, String appkeys, String positions);

    /**
     * IP 封禁
     *
     * @param ips
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/2 17:24
     */
    boolean executeBannedIp(String ips);

    /**
     * 解除IP封禁
     *
     * @param ips
     * @return boolean
     * @throws
     * @author kk.xie
     * @date 2019/7/2 17:29
     */
    boolean executeRelieveIp(String ips);
}
