package com.youmo.huang.exception;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @author 2257
 * @date 2020/4/25 - 15:16
 */
@ControllerAdvice
public class HandleExceprion {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String methodArgumentNotValidException(MethodArgumentNotValidException e, HttpSession session){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        session.setAttribute("errorMsg",objectError.getDefaultMessage());
        return "redirect:/login";
    }

}
