package com.wantbchack.business.filter;



import cn.hutool.json.JSONUtil;
import com.wantbcahck.common.dto.Result;
import com.wantbcahck.common.enums.ResultEnum;
import com.wantbcahck.common.util.ResultUtil;
import com.wantbchack.business.util.SymmetricEncoderUtil;
import com.wantbchack.business.warpper.RequestWrapper;
import com.wantbchack.business.warpper.ResponseWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
/**
 * Create by  fanxiaobin
 * Date 2022/6/28  15:56
 * 过滤器
 */
@WebFilter(filterName="fristFiilter", urlPatterns="/*")
public class MyFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Autowired
    private SymmetricEncoderUtil symmetricEncoderUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        logger.info("执行过滤器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        RequestWrapper requestWrapper = new RequestWrapper(request);
        ResponseWrapper responseWrapper = new ResponseWrapper(response);
        responseWrapper.setHeader("Content-type", "application/json;charset=UTF-8");
        responseWrapper.setCharacterEncoding("UTF-8");
        //判断查询参数
        Result result = checkParams(requestWrapper, responseWrapper);
        String resultStr ;
        if (ResultEnum.SUCCESS.getCode().equals(result.getCode())){
            //采用装饰者模式 装饰request
            chain.doFilter(requestWrapper,responseWrapper );
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] responseData = responseWrapper.getResponseData();
            //将响应数据转换成字符穿 可以用来做加解密操作并且可以重新封装json字符串
             resultStr = new String(responseData);
        }else {
            resultStr = JSONUtil.toJsonStr(result);
        }
//        //加解密操作
//        long time = new Date().getTime();
//        String encode = symmetricEncoderUtil.AESEncode(time + "", resultStr);
//        String dncode = symmetricEncoderUtil.AESDncode(time + "", encode);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(resultStr.getBytes());
        outputStream.flush();
    }

    private Result checkParams(RequestWrapper requestWrapper, ResponseWrapper responseWrapper) {
        String method = requestWrapper.getMethod();
        Result result = ResultUtil.success();
        //判断请求方法是不是POST请求
        if(!(StringUtils.isNotBlank(method) && method.equals(RequestMethod.POST.name()))){
            result = ResultUtil.error(ResultEnum.METHOD);
        }
        //如果请求body不是JSON
        String  body = new String(requestWrapper.getBody());
        if (StringUtils.isEmpty(body){
            result = ResultUtil.error(ResultEnum.PARAMS);
        }
        return result;
    }


}
