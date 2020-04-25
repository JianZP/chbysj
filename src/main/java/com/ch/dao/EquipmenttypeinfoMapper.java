package com.ch.dao;

import com.ch.entity.Equipmenttypeinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EquipmenttypeinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipmenttypeinfo record);

    int insertSelective(Equipmenttypeinfo record);

    Equipmenttypeinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipmenttypeinfo record);

    int updateByPrimaryKey(Equipmenttypeinfo record);

    List<Equipmenttypeinfo> selAll(@Param("name")String name,@Param("pageNo")Integer pageNo, @Param("pagesize") Integer pagesize);

    List<Equipmenttypeinfo> selc(@Param("name")String name);

    int del(int id);
}