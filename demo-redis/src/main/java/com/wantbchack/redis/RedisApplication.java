package com.wantbchack.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author: fanxiaobin
 * @Date: 2021/11/01/15:02
 */
@SpringBootApplication
@ServletComponentScan
public class RedisApplication {

    private static final Logger logger= LoggerFactory.getLogger(RedisApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
        logger.info("demoRedis start success!!!!!");
    }
}
