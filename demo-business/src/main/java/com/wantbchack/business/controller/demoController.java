package com.wantbchack.business.controller;

import com.wantbchack.business.dto.Result;
import com.wantbchack.business.dto.business.MyReq;
import com.wantbchack.business.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class demoController {


    private static final Logger logger = LoggerFactory.getLogger(demoController.class);


    @PostMapping("/list")
    public Result list(@RequestBody(required = false) MyReq req){
        return ResultUtil.success(req,"程序正常运行!!!!!");
    }
}
