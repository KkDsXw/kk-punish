package com.bxm.vision.punish.facade.service;

import com.bxm.vision.punish.facade.model.BannedIpDto;
import com.bxm.vision.punish.facade.model.PunishDto;
import com.bxm.warcar.utils.response.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 惩戒对挖暴露服务
 *
 * @Author kk.xie
 * @Date 2019/4/11 15:52
 * @Version 1.0
 **/
@FeignClient("punish-service")
public interface PunishFacadeService {
    /**
     * 惩戒作弊行为
     *
     * @param punishDto
     * @return com.bxm.warcar.utils.response.ResponseModel<java.lang.Boolean>
     * @throws
     * @author kk.xie
     * @date 2019/4/11 15:55
     */
    @RequestMapping(value = "/punish/cheat", method = RequestMethod.POST)
    ResponseModel<Boolean> punish(@RequestBody PunishDto punishDto);

    /**
     * 封禁IP
     *
     * @param bannedIpDto
     * @return com.bxm.warcar.utils.response.ResponseModel<java.lang.Boolean>
     * @throws
     * @author kk.xie
     * @date 2019/7/2 17:17
     */
    @RequestMapping(value = "/punish/ip", method = RequestMethod.POST)
    ResponseModel<Boolean> ip(@RequestBody BannedIpDto bannedIpDto);

}
