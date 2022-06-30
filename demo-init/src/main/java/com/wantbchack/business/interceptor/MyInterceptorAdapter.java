package com.wantbchack.business.interceptor;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.wantbcahck.common.dto.Result;
import com.wantbcahck.common.enums.ResultEnum;
import com.wantbcahck.common.util.ResultUtil;
import com.wantbchack.business.filter.MyFilter;
import com.wantbchack.business.warpper.RequestWrapper;
import com.wantbchack.business.warpper.ResponseWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.ref.ReferenceQueue;

/**
 * Create by  fanxiaobin
 * Date 2022/6/28  15:56
 * 拦截器
 */
@Component
public class MyInterceptorAdapter extends HandlerInterceptorAdapter {

    private RequestWrapper requestWrapper;
    private ResponseWrapper responseWrapper;
    private Result result = new Result();

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptorAdapter.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("===========开始进行拦截操作===========");
        requestWrapper = new RequestWrapper(request);
        //设置返回内容类型
        responseWrapper.setHeader("Content-type", "application/json;charset=UTF-8");
        responseWrapper.setCharacterEncoding("UTF-8");
        //获取请求方法
        String method = requestWrapper.getMethod();
        //判断请求方法是不是POST请求
        if(!(StringUtils.isNotBlank(method) && method.equals(RequestMethod.POST.name()))){
            /*|| !(StringUtils.isNotBlank(contentType) && contentType.contains(MediaType.APPLICATION_JSON))*/
            responseWrapper = new ResponseWrapper(response);
            result = ResultUtil.error(ResultEnum.METHOD);
            PrintWriter out = responseWrapper.getWriter();
            out.write(JSONUtil.toJsonStr(result));
            out.flush();
            out.close();
            return false;
        }
        //获取请求参数
        String  body = new String(requestWrapper.getBody());
        logger.info("请求参数:{}", body);
        //获取请求body
        if (StringUtils.isEmpty(body) ||  "{}".equals(body)){
            responseWrapper = new ResponseWrapper(response);
            result = ResultUtil.error(ResultEnum.PARAMS);
            PrintWriter out = responseWrapper.getWriter();
            out.write(JSONUtil.toJsonStr(result));
            out.flush();
            out.close();
            return false;
        }
        //判断请求参数是否正确的JSON
        return true;
    }
}
