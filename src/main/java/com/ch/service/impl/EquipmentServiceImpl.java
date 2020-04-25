package com.ch.service.impl;

import com.ch.dao.EquipmentMapper;
import com.ch.entity.Equipment;
import com.ch.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Override
    public int insert(Equipment equipment) {
        return equipmentMapper.insert(equipment);
    }

    @Override
    public List<Equipment> selAll(Integer pageNo,Integer pagesize) {
        return equipmentMapper.selAll(pageNo,pagesize);
    }

    @Override
    public List<Equipment> selc() {
        return equipmentMapper.selc();
    }

    @Override
    public int updateByPrimaryKey(Equipment record) {
        return equipmentMapper.updateByPrimaryKeySelective(record);
    }
}
