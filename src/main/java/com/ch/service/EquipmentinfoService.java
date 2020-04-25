package com.ch.service;

import com.ch.entity.Equipmentinfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmentinfoService {
    List<Equipmentinfo> selAll(String madefactor, Integer pageNo, Integer pagesize);

    List<Equipmentinfo> selc(String madefactor);


}
