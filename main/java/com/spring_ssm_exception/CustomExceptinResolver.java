package com.spring_ssm_exception;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理异常类
 */
public class CustomExceptinResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        //handler处理器需要执行的的handler对象（只有method）
        String message = null;
        if (ex instanceof CustomException) {
            message = ((CustomException) ex).getMessage();
        }else if (ex instanceof MaxUploadSizeExceededException){
            message = new CustomException("上传文件超过指定大小").getMessage();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("/error.jsp");
        return modelAndView;


    }
}
