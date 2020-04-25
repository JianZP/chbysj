package com.ch.controller;

import com.ch.dao.EquipmenttypeinfoMapper;
import com.ch.entity.Equipmenttypeinfo;
import com.ch.service.EquipmenttypeinfoService;
import com.ch.utils.PageUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EquipmenttypeinfoController {
    @Resource
    private EquipmenttypeinfoService equipmenttypeinfoService;
    @Autowired
    private EquipmenttypeinfoMapper equipmenttypeinfoMapper;
    @RequestMapping("selEquipType")
    @ResponseBody
    public PageUtli<Equipmenttypeinfo> selAllUser(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        String pageNo=request.getParameter("page");
        String pagesize=request.getParameter("limit");
        String uname=request.getParameter("selectValue");
        List<Equipmenttypeinfo> list=equipmenttypeinfoService.selc(request.getParameter("name"));
        List<Equipmenttypeinfo> equipmenttypeinfo=null;
        try {
            equipmenttypeinfo = equipmenttypeinfoService.selAll(request.getParameter("name"),(Integer.parseInt(pageNo)-1)*Integer.parseInt(pagesize),Integer.parseInt(pagesize));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PageUtli<Equipmenttypeinfo> utli=new PageUtli<>();
        utli.setMsg("");
        utli.setCount((long)list.size());
        utli.setData(equipmenttypeinfo);
        return utli;
    }
    @RequestMapping("insEquipType")
    @ResponseBody
    public int insEquipType(HttpServletRequest request){
        System.out.println("aaa");
        Equipmenttypeinfo equipmenttypeinfo=new Equipmenttypeinfo();
        equipmenttypeinfo.setName(request.getParameter("name"));
        equipmenttypeinfo.setEquiptype(request.getParameter("equiptype"));
        equipmenttypeinfo.setTypenumber(request.getParameter("typenumber"));
        equipmenttypeinfo.setUserange(request.getParameter("userange"));
        System.out.println("aaa");
        equipmenttypeinfoMapper.insert(equipmenttypeinfo);
        return 0;
    }
    @RequestMapping("updEquipType")
    @ResponseBody
    public int updEquipType(HttpServletRequest request){
        Equipmenttypeinfo equipmenttypeinfo=new Equipmenttypeinfo();
        equipmenttypeinfo.setId(Integer.parseInt(request.getParameter("id")));
        equipmenttypeinfo.setName(request.getParameter("name"));
        equipmenttypeinfo.setEquiptype(request.getParameter("equiptype"));
        equipmenttypeinfo.setTypenumber(request.getParameter("typenumber"));
        equipmenttypeinfo.setUserange(request.getParameter("userange"));
        equipmenttypeinfo.setUselimit(Integer.parseInt(request.getParameter("uselimit")));
        equipmenttypeinfo.setStatus(request.getParameter("status"));
        equipmenttypeinfoMapper.updateByPrimaryKeySelective(equipmenttypeinfo);
        return 0;
    }
    @RequestMapping("delEquipType")
    @ResponseBody
    public int delEquipType(HttpServletRequest request){
        equipmenttypeinfoMapper.deleteByPrimaryKey(Integer.parseInt(request.getParameter("id")));
        return 0;
    }
}
