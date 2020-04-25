package com.ch.service;

import com.ch.entity.Equipmentinfo;
import com.ch.entity.Equipmenttypeinfo;
import com.ch.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface ExcelService {

    Equipmenttypeinfo selectByPrimaryKey(Integer id);

    public int insert(Equipmenttypeinfo equipmenttypeinfo);

    String ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response);

    Equipmentinfo selectByPrimaryKeyi(Integer id);

    public int inserti(Equipmentinfo equipmentinfo);

    String ajaxUploadExceli(HttpServletRequest request, HttpServletResponse response);

    User selectByPrimaryKeyu(Integer id);
}
