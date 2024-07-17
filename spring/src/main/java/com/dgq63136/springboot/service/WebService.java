package com.dgq63136.springboot.service;

import com.dgq63136.springboot.entity.Barrage;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WebService {

    PageInfo<Barrage> JZCMPage(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> J2022Page(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> J2023Page(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> J2024Page(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> p1Page(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> ruibinPage(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> XTTPage(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> DGQPage(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> baiziPage(Integer pageNum, Integer pageSize);

    PageInfo<Barrage> QUQUPage(Integer pageNum, Integer pageSize);

    List<Barrage> allPage();
}
