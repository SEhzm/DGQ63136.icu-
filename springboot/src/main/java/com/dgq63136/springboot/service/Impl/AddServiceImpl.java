package com.dgq63136.springboot.service.Impl;

import com.dgq63136.springboot.entity.Barrage;
import com.dgq63136.springboot.mapper.AddMapper;
import com.dgq63136.springboot.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private AddMapper addMapper;

    @Override
    public void addBarrage(String table, String barrage) {
        addMapper.addBarrage(table,barrage);
        addMapper.addAll(table,barrage);
    }
}
