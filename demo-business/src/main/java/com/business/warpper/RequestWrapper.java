package com.business.warpper;

import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class RequestWrapper extends HttpServletRequestWrapper {


    private byte[] body = null;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        //缓存请求参数
        body = StreamUtils.copyToByteArray(request.getInputStream());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        //因为getInputStream()只能使用一次
        //如果拦截器获取一次后 springboot @RequestBody注解源码中也将使用getInputStream()方法获取请求参数
        //此处重新重写getInputStream()方法是为了调用该装饰对象的时候获取缓存的数据
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return  new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };


    }


    //重写读方法 通过调用重写的getInputStream()获取流
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
