package com.partybuilding.webserver.config;

import com.partybuilding.webserver.dto.JsonResult;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AuthorizationExceptionHandler  {
    @ExceptionHandler(value = AuthorizationException.class)//指定拦截的异常
    @ResponseBody
    public JsonResult errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
       return new JsonResult(403,"403，你没有权限");
    }
}
