package com.bxm.vision.punish.service.controller;

import com.bxm.vision.punish.facade.model.BannedIpDto;
import com.bxm.vision.punish.facade.model.PunishDto;
import com.bxm.vision.punish.facade.service.PunishFacadeService;
import com.bxm.vision.punish.service.service.PunishService;
import com.bxm.warcar.utils.response.ResponseModel;
import com.bxm.warcar.utils.response.ResponseModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 惩戒控制器
 *
 * @Author kk.xie
 * @Date 2019/4/11 15:58
 * @Version 1.0
 **/
@RestController
@RequestMapping("/punish")
public class PunishController implements PunishFacadeService {

    @Autowired
    private PunishService punishService;

    @Override
    @RequestMapping(value = "/cheat", method = RequestMethod.POST)
    public ResponseModel<Boolean> punish(@RequestBody PunishDto punishDto) {
        return ResponseModelFactory.SUCCESS(punishService.executePunish(punishDto));
    }

    @Override
    @RequestMapping(value = "/ip", method = RequestMethod.POST)
    public ResponseModel<Boolean> ip(@RequestBody BannedIpDto bannedIpDto) {
        return ResponseModelFactory.SUCCESS(punishService.punishIp(bannedIpDto));
    }

}
