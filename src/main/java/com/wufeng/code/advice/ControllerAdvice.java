package com.wufeng.code.advice;

import com.wufeng.code.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    /**
     * 拦截表单参数校验
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BindException.class})
    public CommonResult bindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String msg = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        log.error("参数校验异常拦截：{}", msg);
        return CommonResult.failed(msg);
    }

    /**
     * 拦截JSON参数校验
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String msg = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        log.error("参数校验异常拦截：{}", msg);
        return CommonResult.failed(msg);
    }
}
