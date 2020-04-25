package com.ch.service.impl;

import com.ch.dao.EquipmentinfoMapper;
import com.ch.entity.Equipmentinfo;
import com.ch.service.EquipmentinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EquipmentinfoServiceImpl implements EquipmentinfoService {
    @Resource
    private EquipmentinfoMapper equipmentinfoMapper;
    @Override
    public List<Equipmentinfo> selAll(String madefactor, Integer pageNo, Integer pagesize) {
        return equipmentinfoMapper.selAll(madefactor, pageNo, pagesize);
    }

    @Override
    public List<Equipmentinfo> selc(String madefactor) {
        return equipmentinfoMapper.selc(madefactor);
    }
}
