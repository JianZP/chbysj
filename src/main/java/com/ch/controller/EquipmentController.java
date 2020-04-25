package com.ch.controller;

import com.ch.entity.Equipment;
import com.ch.service.EquipmentService;
import com.ch.utils.PageUtli;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class EquipmentController {
    @Resource
    private EquipmentService equipmentService;
    @RequestMapping("insert")
    @ResponseBody
    public int insert(HttpServletRequest request){
        Equipment equipment=new Equipment();
        equipment.setEquipmentname(request.getParameter("equipmentname"));
        equipment.setUselimit((Integer.parseInt(request.getParameter("uselimit"))));
        equipment.setIsinput("否");
        equipment.setIsoutput("否");
        equipmentService.insert(equipment);
      return 0;
    }
@RequestMapping("selAll")
@ResponseBody
    public PageUtli<Equipment> sellAll(HttpServletRequest request){
    String pageNo=request.getParameter("page");
    String pagesize=request.getParameter("limit");
    String uname=request.getParameter("selectValue");
    List<Equipment> list=equipmentService.selc();
    List<Equipment> equipment=null;
    try {
        equipment = equipmentService.selAll((Integer.parseInt(pageNo)-1)*Integer.parseInt(pagesize),Integer.parseInt(pagesize));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

        PageUtli<Equipment> utli=new PageUtli<>();
        utli.setMsg("");
        utli.setCount((long)list.size());
        utli.setData(equipment);
        return utli;
    }
//    @RequestMapping("updatePower")
//    public int updatePower(HttpServletRequest request){
//        Equipment equipment=new Equipment();
//        System.out.println(request.getParameter("id"));
//        equipment.setId(Integer.parseInt(request.getParameter("id")));
//        equipment.setIsinput(request.getParameter("isinput"));
//        equipment.setIsoutput(request.getParameter("isoutput"));
//        System.out.println(equipment.toString());
//        equipmentService.updateByPrimaryKey(equipment);
//        return 0;
//    }
}
