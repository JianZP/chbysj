package com.ch.controller;

import com.ch.entity.Equipmentinfo;
import com.ch.entity.Equipmenttypeinfo;
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

;


@Controller
    public class ExcelInfoController {
    @Resource
    private ExcelService excelService;
    @RequestMapping("/ExcelDownloadsInfo")
    public void UserExcelDownloads(HttpServletResponse response, HttpServletRequest request)throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("设备信息表");
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
        List<Equipmentinfo> equipmentinfoList = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            Integer id=Integer.parseInt(strings.get(i));
            Equipmentinfo equipmentinfo=excelService.selectByPrimaryKeyi(id);
            equipmentinfoList.add(equipmentinfo);
        }
        String s = (new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date());
        System.out.println(s);
        String fileName = "EquipInfo"+s + ".xls";
        int rowNum = 1;
        String [] headers = {"生产厂家","品牌","生产时间","功能"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0;i<headers.length;i++){
            HSSFCell cell = row.createCell((short) i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        for (Equipmentinfo equipmentinfo : equipmentinfoList){
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell((short) 0).setCellValue(new HSSFRichTextString(equipmentinfo.getMadefactor()));
            row1.createCell((short) 1).setCellValue(new HSSFRichTextString(equipmentinfo.getBrand()));
            row1.createCell((short) 2).setCellValue(new HSSFRichTextString(equipmentinfo.getMadetime()));
            row1.createCell((short) 3).setCellValue(new HSSFRichTextString(equipmentinfo.getFunction()));
            rowNum++;

        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    @RequestMapping(value="fileUploadInfo")
    public String UploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
         excelService.ajaxUploadExceli(request, response);
        return "template/personalpage";
    }
    }
