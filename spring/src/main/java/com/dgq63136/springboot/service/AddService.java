package com.dgq63136.springboot.service;

import com.dgq63136.springboot.entity.Barrage;

public interface AddService {


    void addBarrage(String table, String barrage);

    void addCnt(String table, String id);
}
