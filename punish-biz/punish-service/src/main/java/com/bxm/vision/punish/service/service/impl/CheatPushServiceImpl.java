package com.bxm.vision.punish.service.service.impl;

import com.bxm.vision.punish.service.constant.RedisKeyGenerator;
import com.bxm.vision.punish.service.service.CheatPushService;
import com.bxm.warcar.cache.impls.redis.JedisCounter;
import com.bxm.warcar.cache.impls.redis.JedisUpdater;
import com.bxm.warcar.utils.NamedThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 作弊数据推送服务
 *
 * @Author kk.xie
 * @Date 2019/7/24 11:18
 * @Version 1.0
 **/
@Service
public class CheatPushServiceImpl implements CheatPushService {

    @Autowired
    private JedisCounter jedisCounter;

    @Autowired
    private JedisUpdater jedisUpdater;

    @Value("${punish.able}")
    private Boolean punishAble = false;

    private ThreadPoolExecutor executor;
    public CheatPushServiceImpl() {
        this.executor = new ThreadPoolExecutor(
                5,
                5,
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(),
                new NamedThreadFactory("banned")
        );
    }

    @Override
    public boolean pushUid(List<String> uidList) {
        if(punishAble){
            for(String uid : uidList){
                executor.execute(() -> jedisCounter.incrementAndGet(RedisKeyGenerator.getCheatUid(uid), 30 * 24 * 60 * 60));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean relieveUid(List<String> uidList) {
        if(punishAble){
            for(String uid : uidList){
                jedisUpdater.remove(RedisKeyGenerator.getCheatUid(uid));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean pushIp(List<String> ipList) {
        if(punishAble){
            for(String ip : ipList){
                executor.execute(() -> jedisCounter.incrementAndGet(RedisKeyGenerator.getCheatIp(ip), 30 * 24 * 60 * 60));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean relieveIp(List<String> ipList) {
        if(punishAble){
            for(String ip : ipList){
                jedisUpdater.remove(RedisKeyGenerator.getCheatIp(ip));
            }
            return true;
        }
        return false;
    }
}
