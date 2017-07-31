package com.cycloneboy.springmvc.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


/**
 * Created by CycloneBoy on 2017/7/31.
 */
@Controller()
@RequestMapping(value = "/shiro")
public class ShiroController {

    private static Logger logger = Logger.getLogger(ShiroController.class);


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        System.out.println("跳转到用户登录jsp页面");
        return "/shiro/login";
    }

    @RequestMapping(value = "/unauthorized",method = RequestMethod.GET)
    public String unauthorized(){
        System.out.println("跳转到用户unauthorizedjsp页面");
        return "/shiro/unauthorized";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginResult(String username, String password, HttpSession session){
        System.out.println("login -->");

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            currentUser.login(token);
            System.out.println(username + " " + password+ " 认证成功");
            session.setAttribute("username",username);
            return "shiro/success";
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("认证失败");
            return "shiro/login";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();//直接让session失效
        System.out.println("退出登录");
        return "shiro/login";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(){
        logger.info("adimin 请求");
        System.out.println("admin请求");
        return "shiro/success";
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String student(){
        System.out.println("/teacher请求");
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.hasRole("teacher")){
            System.out.println("你拥有teacher权限");
            return "shiro/success";
        }else {
            System.out.println("你不拥有teacher权限");
            return "shiro/unauthorized";
        }
    }

    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public String teacher(){
        System.out.println("perms test");
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isPermitted("user:create")){
            return "shiro/success";
        }else {
            return "shiro/unauthorized";
        }
    }
}
