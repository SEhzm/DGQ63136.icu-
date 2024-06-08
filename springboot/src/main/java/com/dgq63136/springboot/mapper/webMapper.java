package com.dgq63136.springboot.mapper;


import com.dgq63136.springboot.entity.barrage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface webMapper {
    @Select("select * from barrage order by barrage desc ")
    List<barrage> page();
}
