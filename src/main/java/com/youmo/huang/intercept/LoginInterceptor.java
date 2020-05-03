package com.youmo.huang.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 2257
 * @date 2020/4/25 - 15:23
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("user");
        if(user == null){
            request.setAttribute("errorMsg","登陆没有权限");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }

        return true;
    }

}
