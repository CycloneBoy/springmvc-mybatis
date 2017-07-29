package com.cycloneboy.springmvc.interceptor;

import com.cycloneboy.springmvc.entity.vo.Person;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CycloneBoy on 2017/7/29.
 */
public class AuthorizationInterceptor implements HandlerInterceptor{
    private static final String[] IGNORE_URI = {"/person/loginForm","/person/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthorizationInterceptor preHandle -->");
        boolean flag = false;
        String servletPath = request.getServletPath();
        for(String s:IGNORE_URI){
            if(servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        if(!flag){
            Person person = (Person) request.getSession().getAttribute("user");
            if(person == null){
                System.out.println("AuthorizationInterceptor 拦截请求：");
                request.setAttribute("message","请先登录再访问网站");
                request.getRequestDispatcher("/person/loginForm").forward(request,response);
            }else {
                System.out.println("AuthorizationInterceptor：放行请求");
                flag =true;
            }
        }
        return  flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthorizationInterceptor postHandle -->");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AuthorizationInterceptor afterCompletion -->");
    }
}
