package com.business.filter;



import com.business.util.SymmetricEncoderUtil;
import com.business.warpper.RequestWrapper;
import com.business.warpper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName="fristFiilter", urlPatterns="/*")
public class myFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(myFilter.class);

    @Autowired
    private SymmetricEncoderUtil symmetricEncoderUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("拦截器开始工作");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        RequestWrapper requestWrapper =null;
        ResponseWrapper responseWrapper = null;
        //采用装饰者模式 装饰request
        requestWrapper = new RequestWrapper(request);
        responseWrapper = new ResponseWrapper(response);
        chain.doFilter(requestWrapper,responseWrapper );

        ServletOutputStream outputStream = response.getOutputStream();
        byte[] responseData = responseWrapper.getResponseData();
        //将响应数据转换成字符穿 可以用来做加解密操作并且可以重新封装json字符串
        String orinalData = new String(responseData);
//        加解密操作
//        long time = new Date().getTime();
//        logger.info("rulse {}",time );
//        String encode = symmetricEncoderUtil.AESEncode(time + "", orinalData);
//        String dncode = symmetricEncoderUtil.AESDncode(time + "", encode);
        outputStream.write(orinalData.getBytes());
        outputStream.flush();
    }


}
