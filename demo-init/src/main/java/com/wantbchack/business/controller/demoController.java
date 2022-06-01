package com.wantbchack.business.controller;


import com.wantbcahck.common.dto.Result;
import com.wantbcahck.common.dto.business.MyReq;
import com.wantbcahck.common.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wantbchack.business.annotation.Myannotaiton;
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


    @PostMapping("/list")
    @Myannotaiton
    public Result list(@RequestBody(required = false) MyReq req){
        return ResultUtil.success(req,"程序正常运行!!!!!");
    }
}
