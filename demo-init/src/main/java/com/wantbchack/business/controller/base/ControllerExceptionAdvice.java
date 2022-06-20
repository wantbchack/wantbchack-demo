package com.wantbchack.business.controller.base;

import com.wantbcahck.common.dto.Result;
import com.wantbcahck.common.enums.ResultEnum;
import com.wantbcahck.common.util.ResultUtil;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Create by  fanxiaobin
 * Date 2022/6/20  15:07
 * controller 增强器 参数校验处理器
 */
@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResultUtil.error(ResultEnum.PARAMS.getCode(), objectError.getDefaultMessage());
    }
}
