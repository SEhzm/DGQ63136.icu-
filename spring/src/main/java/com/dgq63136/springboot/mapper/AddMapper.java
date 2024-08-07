package com.dgq63136.springboot.mapper;

import com.dgq63136.springboot.entity.Barrage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddMapper {


    void addBarrage(String table, String barrage);

    void addAll(String table, String barrage);

    void addCnt(String table, String id,String cnt);

    String getCntById(String table,String id);
}
