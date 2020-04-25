package com.ch.service.impl;

import com.ch.dao.EquipmenttypeinfoMapper;
import com.ch.entity.Equipmenttypeinfo;
import com.ch.service.EquipmenttypeinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EquipmenttypeinfoServiceImpl implements EquipmenttypeinfoService {
    @Resource
    private EquipmenttypeinfoMapper equipmenttypeinfoMapper;

    @Override
    public List<Equipmenttypeinfo> selAll(String name,Integer pageNo, Integer pagesize) {
        return equipmenttypeinfoMapper.selAll(name,pageNo, pagesize);
    }

    @Override
    public List<Equipmenttypeinfo> selc(String name) {
        return equipmenttypeinfoMapper.selc(name);
    }
}
