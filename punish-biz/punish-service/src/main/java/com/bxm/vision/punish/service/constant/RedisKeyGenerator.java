package com.bxm.vision.punish.service.constant;

import com.bxm.warcar.cache.KeyGenerator;
import org.apache.commons.lang3.StringUtils;

/**
 * redis key
 *
 * @Author kk.xie
 * @Date 2019/7/24 10:37
 * @Version 1.0
 **/
public class RedisKeyGenerator {
    /**
     * 封禁UID redis key
     *
     * @param uid
     * @return com.bxm.warcar.cache.KeyGenerator
     * @throws
     * @author kk.xie
     * @date 2019/7/24 10:49
     */
    public static KeyGenerator getCheatUid(String uid){
        return () -> RedisKeyBuilder.build("CHEAT", "UID", uid);
    }

    /**
     * 封禁IP redis key
     *
     * @param ip
     * @return com.bxm.warcar.cache.KeyGenerator
     * @throws
     * @author kk.xie
     * @date 2019/7/24 10:50
     */
    public static KeyGenerator getCheatIp(String ip){
        return () -> RedisKeyBuilder.build("CHEAT", "IP", ip);
    }

    static class RedisKeyBuilder{
        private static final String SPLIT = ":";

        private RedisKeyBuilder(){}

        public static String build(Object...array) {
            return StringUtils.join(array, SPLIT);
        }
    }
}
