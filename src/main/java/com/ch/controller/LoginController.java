package com.ch.controller;

import com.ch.dao.UserMapper;
import com.ch.entity.User;
import com.ch.utils.PageUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/")
    public String login(){
        return "user/login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public PageUtli<User> sign(HttpServletRequest request, HttpSession session){
        PageUtli<User> pageUtli=new PageUtli<>();
        String username=request.getParameter("username");
        List<User> users=userMapper.login(request.getParameter("username"),request.getParameter("password"));
       if(users.size()!=0 && users != null) {
           session.setAttribute("users", request.getParameter("username"));
           request.setAttribute("users", request.getParameter("username"));
            String s = (new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date());
            userMapper.updateByUsernameOut(s,username);
            pageUtli.setData(users);
            return pageUtli;
       }else{
           pageUtli.setCode(1);
           return pageUtli;
       }
    }

    @RequestMapping("main")
    public String signin(){
        return "index";
    }
    @RequestMapping("/logout")
    @ResponseBody
    public PageUtli<User> logout(HttpServletRequest request){
        String username=(String)request.getAttribute("users");
        String s = (new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date());
        userMapper.updateByUsernameOut(s,username);
        List<User> user=new ArrayList<>();
        PageUtli<User> pageUtli=new PageUtli<>();
        pageUtli.setMsg("退出成功");
        pageUtli.setData(user);
        return pageUtli;
    }
}
