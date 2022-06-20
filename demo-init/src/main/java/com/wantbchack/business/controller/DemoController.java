package com.wantbchack.business.controller;


import com.wantbcahck.common.dto.Result;
import com.wantbcahck.common.dto.business.MyReq;
import com.wantbcahck.common.util.ResultUtil;
import com.wantbchack.business.model.VerifyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wantbchack.business.annotation.Myannotaiton;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wantbchack
 */
@RestController
@RequestMapping("/demo")
public class DemoController {


    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);


    @PostMapping("/list")
    @Myannotaiton
    public Result list(@RequestBody(required = false) MyReq req){
        return ResultUtil.success(req,"程序正常运行!!!!!");
    }


    @PostMapping("/verify")
    public Result verify(@Validated @RequestBody VerifyVo verifyVo){
        return ResultUtil.success(verifyVo);
    }
}
