package com.wantbchack.business.aop;

import cn.hutool.json.JSONUtil;
import com.wantbcahck.common.enums.ResultEnum;
import com.wantbcahck.common.util.ResultUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Create by  fanxiaobin
 * Date 2022/6/1  10:59
 * Description
 */
@Component
@Aspect
public class MyAop {
    private static final Logger log = LoggerFactory.getLogger(MyAop.class);

    /**
     * 定义切点 @Pointcut
     * 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.wantbchack.business.annotation.Myannotaiton)")
    public void myAnnotaiton() {
    }

    @Around("myAnnotaiton()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        log.info("log info {}",args);
        //获取切入点所在的方法
        if (args == null || args.length <1 || args[0] == null){
            return  ResultUtil.error(ResultEnum.UNKNOWN_ERROR);
        }
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String className = pjp.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        String params = JSONUtil.toJsonStr(args);
        log.info("className:{} methodName:{} params:{}",className,method,params);
        return  pjp.proceed();
    }

    @Before("myAnnotaiton()")
    public void before(){
        log.info("在请求之前");
    }

    @After("myAnnotaiton()")
    public void after(){
        log.info("在请求之后");
    }
}
