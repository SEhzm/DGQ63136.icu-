package com.dgq63136.springboot.mapper;


import com.dgq63136.springboot.entity.Barrage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WebMapper {

    @Select("SELECT barrage FROM J2022 UNION all SELECT barrage FROM J2023 UNION all SELECT barrage FROM J2024 order by barrage desc ")
    List<Barrage> JZCMPage();

    @Select("select * from j2022 order by id desc ")
    List<Barrage> J2022Page();

    @Select("select * from j2023 order by id desc ")
    List<Barrage> J2023Page();

    @Select("select * from j2024 order by id desc ")
    List<Barrage> J2024Page();

    @Select("select * from p1 order by id desc ")
    List<Barrage> p1Page();

    @Select("select * from ruibin order by id desc ")
    List<Barrage> ruibinPage();

    @Select("select * from xtt order by id desc ")
    List<Barrage> XTTPage();

    @Select("select * from dgq order by id desc ")
    List<Barrage> DGQPage();

    @Select("select * from baizi order by id desc ")
    List<Barrage> baiziPage();

    @Select("select * from QUQU order by id desc ")
    List<Barrage> QUQUPage();

    @Select("select * from allbarrage")
    List<Barrage> allPage();
}
