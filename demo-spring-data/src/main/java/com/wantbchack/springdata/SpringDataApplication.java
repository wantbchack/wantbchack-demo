package com.wantbchack.springdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/23/15:58
 */
@SpringBootApplication

public class SpringDataApplication {

    private static final Logger logger= LoggerFactory.getLogger(SpringDataApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
        logger.info("spring data start success!!!!!");
    }

}
