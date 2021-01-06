package com.example.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dell
 * 自定义的拦截器
 * 需要实现HandlerInterceptor接口
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler)
            throws Exception {
        //登入成功之后有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            //如果没有获取到用户属性，则代表用户不存在，即未成功登入
            //添加错误信息，可以给前端获取
            request.setAttribute("msg", "没有权限，请先登入");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        } else {
            //登入成功
            return true;
        }
    }
}
