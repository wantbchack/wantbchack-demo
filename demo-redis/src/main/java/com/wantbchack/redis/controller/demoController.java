package com.wantbchack.redis.controller;


import com.wantbchack.redis.dto.Result;
import com.wantbchack.redis.dto.business.MyReq;
import com.wantbchack.redis.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wantbchack
 */
@RestController
@RequestMapping("/demo")
public class demoController {


    private static final Logger logger = LoggerFactory.getLogger(demoController.class);


    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping("/list")
    public Result list(@RequestBody(required = false) MyReq req){
        return ResultUtil.success(req,"程序正常运行!!!!!");
    }



    @PostMapping("/add")
    public Result addRedis(@RequestBody(required = false)MyReq req){
        redisTemplate.opsForValue().set("demo","hello,redis");
        return ResultUtil.success(redisTemplate.opsForValue().get("demo"),"成功集成Redis!!!!!");
    }
}
