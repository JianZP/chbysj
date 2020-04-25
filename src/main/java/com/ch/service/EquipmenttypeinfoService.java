package com.ch.service;

import com.ch.entity.Equipmenttypeinfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmenttypeinfoService {
    List<Equipmenttypeinfo> selAll(String name,Integer pageNo, Integer pagesize);

    List<Equipmenttypeinfo> selc(String name);


}
