package com.wantbchack.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author: fanxiaobin
 * @Date: 2021/05/31/15:18
 * 感谢原作者yangkai.shen
 */
@SpringBootApplication
@ServletComponentScan
public class TaskApplication {

    private static final Logger logger= LoggerFactory.getLogger(TaskApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
        logger.info("demoTask start success!!!!!");
    }
}
