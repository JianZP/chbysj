package com.ch.service.impl;

import com.ch.dao.EquipmentinfoMapper;
import com.ch.dao.EquipmenttypeinfoMapper;
import com.ch.dao.UserMapper;
import com.ch.entity.Equipmentinfo;
import com.ch.entity.Equipmenttypeinfo;
import com.ch.entity.User;
import com.ch.service.ExcelService;
import com.ch.utils.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Resource
    private EquipmenttypeinfoMapper equipmenttypeinfoMapper;
    @Resource
    private EquipmentinfoMapper equipmentinfoMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public Equipmenttypeinfo selectByPrimaryKey(Integer id) {
        return equipmenttypeinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Equipmenttypeinfo equipmenttypeinfo) {
        return equipmenttypeinfoMapper.insert(equipmenttypeinfo);
    }

    @Override
    public String ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        InputStream in =null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<Object>> listob = null;
        try {
            listob = new ExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            Equipmenttypeinfo eq = new Equipmenttypeinfo();
            /*这里是主键验证，根据实际需要添加，可要可不要，加上之后，可以对现有数据进行批量修改和导入
            User j = null;
			try {
				j = userMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(lo.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("没有新增");
			}*/
            //vo.setUserId(Integer.valueOf(String.valueOf(lo.get(0))));  // 刚开始写了主键，由于主键是自增的，又去掉了，现在只有批量插入的功能，不能对现有数据进行修改了
            eq.setName(String.valueOf(lo.get(0)));     // 表格的第一列   注意数据格式需要对应实体类属性
            eq.setEquiptype(String.valueOf(lo.get(1)));   // 表格的第二列
            eq.setTypenumber(String.valueOf(lo.get(2)));
            eq.setUserange(String.valueOf(lo.get(3)));
            equipmenttypeinfoMapper.insert(eq);
			/*if(j == null)
			{
		            userMapper.insert(vo);
			}
			else
			{
		            userMapper.updateByPrimaryKey(vo);
			}*/
        }
        System.out.println("文件导入成功！");
        return "文件导入成功！";
    }

    @Override
    public Equipmentinfo selectByPrimaryKeyi(Integer id) {
        return equipmentinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int inserti(Equipmentinfo equipmentinfo) {
        return equipmentinfoMapper.insert(equipmentinfo);
    }

    @Override
    public String ajaxUploadExceli(HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        InputStream in =null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<Object>> listob = null;
        try {
            listob = new ExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            Equipmentinfo eq = new Equipmentinfo();
            /*这里是主键验证，根据实际需要添加，可要可不要，加上之后，可以对现有数据进行批量修改和导入
            User j = null;
			try {
				j = userMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(lo.get(0))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("没有新增");
			}*/
            //vo.setUserId(Integer.valueOf(String.valueOf(lo.get(0))));  // 刚开始写了主键，由于主键是自增的，又去掉了，现在只有批量插入的功能，不能对现有数据进行修改了
            eq.setMadefactor(String.valueOf(lo.get(0)));     // 表格的第一列   注意数据格式需要对应实体类属性
            eq.setBrand(String.valueOf(lo.get(1)));   // 表格的第二列
            eq.setMadetime(String.valueOf(lo.get(2)));
            eq.setFunction(String.valueOf(lo.get(3)));
            equipmentinfoMapper.insert(eq);
			/*if(j == null)
			{
		            userMapper.insert(vo);
			}
			else
			{
		            userMapper.updateByPrimaryKey(vo);
			}*/
        }
        System.out.println("文件导入成功！");
        return "文件导入成功！";
    }

    @Override
    public User selectByPrimaryKeyu(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
