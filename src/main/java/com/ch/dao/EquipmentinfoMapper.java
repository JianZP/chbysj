package com.ch.dao;

import com.ch.entity.Equipmentinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipmentinfo record);

    int insertSelective(Equipmentinfo record);

    Equipmentinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipmentinfo record);

    int updateByPrimaryKey(Equipmentinfo record);

    List<Equipmentinfo> selAll(@Param("madefactor")String madefactor, @Param("pageNo")Integer pageNo, @Param("pagesize") Integer pagesize);

    List<Equipmentinfo> selc(@Param("madefactor")String madefactor);

}