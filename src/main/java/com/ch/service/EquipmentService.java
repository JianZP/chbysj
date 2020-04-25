package com.ch.service;

import com.ch.entity.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmentService {
    int insert(Equipment equipment);

    List<Equipment> selAll(Integer pageNo,Integer pagesize);

    List<Equipment> selc();

    int updateByPrimaryKey(Equipment record);
}
