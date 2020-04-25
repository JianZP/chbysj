package com.ch.controller;

import com.ch.dao.EquipmentinfoMapper;
import com.ch.entity.Equipmentinfo;
import com.ch.service.EquipmentinfoService;
import com.ch.utils.PageUtli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EquipmentInfoController {
    @Autowired
    private EquipmentinfoMapper equipmentinfoMapper;
    @Resource
    private EquipmentinfoService equipmentinfoService;

    @RequestMapping("selEquipInfo")
    @ResponseBody
    public PageUtli<Equipmentinfo> selEquipInfo(HttpServletRequest request){
        System.out.println(request.getParameter("madefactor"));
        String pageNo=request.getParameter("page");
        String pagesize=request.getParameter("limit");
        String uname=request.getParameter("selectValue");
        List<Equipmentinfo> list=equipmentinfoService.selc(request.getParameter("madefactor"));
        List<Equipmentinfo> equipmentinfo=null;
        try {
            equipmentinfo = equipmentinfoService.selAll(request.getParameter("madefactor"),(Integer.parseInt(pageNo)-1)*Integer.parseInt(pagesize),Integer.parseInt(pagesize));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PageUtli<Equipmentinfo> utli=new PageUtli<>();
        utli.setMsg("");
        utli.setCount((long)list.size());
        utli.setData(equipmentinfo);
        return utli;
    }

    @RequestMapping("insEquipInfo")
    @ResponseBody
    public int insEquipType(HttpServletRequest request){
        Equipmentinfo equipmentinfo=new Equipmentinfo();
        equipmentinfo.setMadefactor(request.getParameter("madefactor"));
        equipmentinfo.setBrand(request.getParameter("brand"));
        equipmentinfo.setMadetime(request.getParameter("madetime"));
        equipmentinfo.setFunction(request.getParameter("function"));
        equipmentinfoMapper.insert(equipmentinfo);
        return 0;
    }
    @RequestMapping("updEquipInfo")
    @ResponseBody
    public int updEquipType(HttpServletRequest request){
        Equipmentinfo equipmentinfo=new Equipmentinfo();
        equipmentinfo.setId(Integer.parseInt(request.getParameter("id")));
        equipmentinfo.setMadefactor(request.getParameter("madefactor"));
        equipmentinfo.setBrand(request.getParameter("brand"));
        equipmentinfo.setMadetime(request.getParameter("madetime"));
        equipmentinfo.setFunction(request.getParameter("function"));
        equipmentinfoMapper.updateByPrimaryKeySelective(equipmentinfo);
        return 0;
    }
    @RequestMapping("delEquipInfo")
    @ResponseBody
    public int delEquipType(HttpServletRequest request){
        equipmentinfoMapper.deleteByPrimaryKey(Integer.parseInt(request.getParameter("id")));
        return 0;
    }
}
