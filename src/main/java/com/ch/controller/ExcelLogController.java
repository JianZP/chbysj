package com.ch.controller;

import com.ch.entity.Equipmenttypeinfo;
import com.ch.entity.User;
import com.ch.service.ExcelService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
    public class ExcelLogController {
    @Resource
    private ExcelService excelService;
    @RequestMapping("/ExcelDownloadsLog")
    public void UserExcelDownloads(HttpServletResponse response, HttpServletRequest request)throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("用户日志表");
        String ids=request.getParameter("ids");
        System.out.println(ids);
        List<String> strings=new ArrayList<>();
        String dd="";
        for (int i = 0; i < ids.length(); i++) {
            if (ids.charAt(i) != '['&&ids.charAt(i) != ']') {
                    dd+=ids.charAt(i);
            }

        }
        dd+=",";
        String ss="";
        for (int i = 0; i < dd.length(); i++) {
                if (dd.charAt(i) != ','){
                    ss+=dd.charAt(i);
                }else {
                    strings.add(ss);
                    ss="";
                }
        }
        System.out.println(strings);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            Integer id=Integer.parseInt(strings.get(i));
            User user=excelService.selectByPrimaryKeyu(id);
            users.add(user);
        }
        String s = (new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date());
        System.out.println(s);
        String fileName = "UserLog"+s + ".xls";
        int rowNum = 1;
        String [] headers = {"用户名","上次登录时间","上次登出时间"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0;i<headers.length;i++){
            HSSFCell cell = row.createCell((short) i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        for (User user : users){
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell((short) 0).setCellValue(new HSSFRichTextString(user.getUsername()));
            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(user.getSignintime()));
            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(user.getSignout()));
            rowNum++;

        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    }
