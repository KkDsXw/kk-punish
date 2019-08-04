package com.bxm.vision.punish.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 数据服务启动类
 *
 * @author kk.xie
 * @date 2018/12/21 14:10
 */
@EnableFeignClients({"com.bxm.vision.punish.facade"})
@MapperScan(basePackages = "com.bxm.vision.punish.dal.mapper")
@ComponentScan("com.bxm.vision")
@SpringBootApplication
public class PunishServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PunishServiceApplication.class, args);
	}
}
