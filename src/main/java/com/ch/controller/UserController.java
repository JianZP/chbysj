package com.ch.controller;

import com.ch.entity.User;
import com.ch.service.UserService;
import com.ch.utils.PageUtli;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("selAllUser")
    @ResponseBody
    public PageUtli<User> selAllUser(HttpServletRequest request){
        String pageNo=request.getParameter("page");
        String pagesize=request.getParameter("limit");
        String uname=request.getParameter("selectValue");
        List<User> list=userService.selc(request.getParameter("username"));
        List<User> user=null;
        try {
            user = userService.selAll(request.getParameter("username"),(Integer.parseInt(pageNo)-1)*Integer.parseInt(pagesize),Integer.parseInt(pagesize));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PageUtli<User> utli=new PageUtli<>();
        utli.setMsg("");
        utli.setCount((long)list.size());
        utli.setData(user);
        return utli;
    }
    @RequestMapping("updatePower")
    public int updatePower(HttpServletRequest request){
        User user=new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setAddpower(request.getParameter("addpower"));
        user.setIsinput(request.getParameter("isinput"));
        user.setIsoutput(request.getParameter("isoutput"));
        System.out.println(user.toString());
        userService.updateByPrimaryKeySelective(user);
        return 0;
    }
}
