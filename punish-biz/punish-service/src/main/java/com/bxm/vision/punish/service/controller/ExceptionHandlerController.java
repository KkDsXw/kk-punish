package com.bxm.vision.punish.service.controller;

import com.bxm.warcar.utils.response.ResponseModel;
import com.bxm.warcar.utils.response.ResponseModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常拦截
 *
 * @ClassName ExceptionHandlerController
 * @CopyRright (c) 2018-bxm：杭州微财网络科技有限公司
 * @Author kk.xie
 * @Date 2018/12/25 10:49
 * @Version 1.0
 * @Modifier kk.xie
 * @Modify Date 2018/12/25 10:49
 **/
@Component
@ControllerAdvice
public class ExceptionHandlerController {
    private static final Integer DEFAULT_ERROR_CODE = -1;

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseModel exceptionHandler(Exception e) {
        logger.error("Exception error", e.getMessage());
        return ResponseModelFactory.FAILED(DEFAULT_ERROR_CODE, e.getMessage());
    }
}
