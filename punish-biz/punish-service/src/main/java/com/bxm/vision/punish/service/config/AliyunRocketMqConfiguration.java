package com.bxm.vision.punish.service.config;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.*;
import com.bxm.vision.punish.model.dao.Order;
import com.bxm.vision.punish.service.message.OrderDto;
import com.bxm.vision.punish.service.service.db.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 阿里云RocketMq配置
 *
 * @Author kk.xie
 * @Date 2019/8/3 22:14
 * @Version 1.0
 **/
@Configuration
public class AliyunRocketMqConfiguration {

    private Logger logger = LoggerFactory.getLogger(AliyunRocketMqConfiguration.class);

    @Autowired
    private OrderService orderService;

    /**
     * group ID
     */
    @Value("${aliyun.rocketmq.groupId}")
    private String groupId;
    /**
     * 身份认证
     */
    @Value("${aliyun.rocketmq.acessKey}")
    private String acessKey;
    /**
     * 身份认证秘钥
     */
    @Value("${aliyun.rocketmq.secretKey}")
    private String secretKey;
    /**
     * 发送超时时间
     */
    @Value("${aliyun.rocketmq.sendMsgTimeoutMillis}")
    private String sendMsgTimeoutMillis;
    /**
     * TCP 接入域名
     */
    @Value("${aliyun.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Value("${aliyun.rocketmq.topic}")
    private String topic;

    private Properties rocketMqProperties(){
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.GROUP_ID, groupId);
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, acessKey);
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, secretKey);
        //设置发送超时时间，单位毫秒
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, sendMsgTimeoutMillis);
        // 设置 TCP 接入域名，到控制台的实例基本信息中查看
        properties.put(PropertyKeyConst.NAMESRV_ADDR, namesrvAddr);

        return properties;
    }


    @Bean
    public Consumer getConsumer(){
        Consumer consumer = ONSFactory.createConsumer(rocketMqProperties());
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可

        consumer.subscribe(topic, "TagA||TagB", new MessageListener() { //订阅多个 Tag
            @Override
            public Action consume(Message message, ConsumeContext context) {
                String key = message.getKey();
                String msgID = message.getMsgID();
                String tag = message.getTag();
                String topic = message.getTopic();
                logger.info("consumer message, key: {}, msgID: {}, tag: {}, topic: {}", key, msgID, tag, topic);

                byte[] body = message.getBody();
                OrderDto orderDto = JSONObject.parseObject(new String(body), OrderDto.class);

                Order order = new Order();
                order.setCommodityId(orderDto.getCommodityId());
                order.setExecuteResult("SUCCESS");
                order.setOrderId(orderDto.getOrderId());
                order.setUid(orderDto.getUid().toString());

                orderService.insert(order);

                return Action.CommitMessage;
            }
        });

        consumer.start();

        return consumer;
    }

}
