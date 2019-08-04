package com.bxm.vision.punish.integration.ads.impl;

import com.alibaba.fastjson.JSONObject;
import com.bxm.vision.punish.integration.ads.AdsPunishService;
import com.bxm.warcar.utils.HttpUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 广告惩戒服务实现
 *
 * @Author kk.xie
 * @Date 2019/4/11 16:07
 * @Version 1.0
 **/
@Deprecated
@Service
public class AdsPunishServiceImpl implements AdsPunishService {

    private Logger logger = LoggerFactory.getLogger(AdsPunishServiceImpl.class);
    /**
     * 封禁IP服务url地址
     */
    @Value("${banned.ip.service.url}")
    private String bannedIpServiceUrl = "http://bxmvpc.tandehao.com:18501/common/ip/add";

    @Value("${relieve.ip.service.url}")
    private String relieveIpServiceUrl = "http://bxmvpc.tandehao.com:18501/common/ip/delete";

    @Value("${punish.able}")
    private Boolean punishAble = false;

    @Value("${banned.ip.sign}")
    private String sign = "bxm";

    @Override
    public boolean executePunish(String ips, String uids, String appkeys, String positions) {
        return executeBannedIp(ips);
    }

    @Override
    public boolean executeBannedIp(String ips) {
        if(StringUtils.isNotEmpty(ips)){
            try {
                if(punishAble){
                    StringBuilder param = new StringBuilder();
                    param.append("ip=").append(ips);

                    String token = DigestUtils.md5Hex(ips + sign);
                    param.append("&token=").append(token);

                    JSONObject jsonObject = HttpUtils.httpPost(bannedIpServiceUrl, param.toString());
                    logger.info("banned ip result: {}, punishAble: {}, requestUrl: {}", jsonObject, punishAble, bannedIpServiceUrl + "?" + param.toString());
                }else {
                    logger.info("banned ip success! punishAble: {}, ips: {}", punishAble, ips);
                    return false;
                }
            } catch (Exception e) {
                logger.error("request url: {} error!", bannedIpServiceUrl, e);
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean executeRelieveIp(String ips) {
        if(StringUtils.isNotEmpty(ips)){
            try {
                if(punishAble){
                    StringBuilder param = new StringBuilder();
                    param.append("ip=").append(ips);

                    String token = DigestUtils.md5Hex(ips + sign);
                    param.append("&token=").append(token);

                    JSONObject jsonObject = HttpUtils.httpPost(relieveIpServiceUrl, param.toString());
                    logger.info("relieve ip result: {}, punishAble: {}, requestUrl: {}", jsonObject, punishAble, relieveIpServiceUrl + "?" + param.toString());
                }else {
                    logger.info("relieve ip success! punishAble: {}, ips: {}", punishAble, ips);
                    return false;
                }
            } catch (Exception e) {
                logger.error("request url: {} error!", relieveIpServiceUrl, e);
                return false;
            }
        }

        return true;
    }
}
