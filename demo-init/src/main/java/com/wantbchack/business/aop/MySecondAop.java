package com.wantbchack.business.aop;

import com.wantbcahck.common.enums.ResultEnum;
import com.wantbcahck.common.util.ResultUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Create by  fanxiaobin
 * Date 2022/6/27  17:40
 * Description
 */
@Order(1)
@Component
@Aspect
public class MySecondAop {

    private static final Logger log = LoggerFactory.getLogger(MySecondAop.class);
    /** 定义切入点 */
    @Pointcut("execution(* com.wantbchack.business.controller.*.*(..))")
    public void checkParams() {
    }

    @Around("checkParams()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("通过第1个Aop");
        Object[] args = pjp.getArgs();
        log.info("log info {}",args);
        //获取切入点所在的方法
        if (args == null || args.length <1 || args[0] == null){
            return  ResultUtil.error(ResultEnum.UNKNOWN_ERROR);
        }
        return pjp.proceed();
    }
}
