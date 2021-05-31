package com.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class BusinessApplication {

    private static final Logger logger= LoggerFactory.getLogger(BusinessApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
        logger.info("demoTask start success!!!!!");
    }

}
