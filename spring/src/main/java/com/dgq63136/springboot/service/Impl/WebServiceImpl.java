package com.dgq63136.springboot.service.Impl;

import com.dgq63136.springboot.entity.Barrage;
import com.dgq63136.springboot.service.WebService;
import com.github.pagehelper.PageHelper;
import com.dgq63136.springboot.mapper.WebMapper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private WebMapper webMapper;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public PageInfo<Barrage> JZCMPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Barrage> barrageList = webMapper.JZCMPage();
        return PageInfo.of(barrageList);
    }

    @Override
    public PageInfo<Barrage> J2022Page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.J2022Page();
        return PageInfo.of(barrageList);
    }

    @Override
    public PageInfo<Barrage> J2023Page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.J2023Page();
        return PageInfo.of(barrageList);
    }
    @Override
    public PageInfo<Barrage> J2024Page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.J2024Page();
        return PageInfo.of(barrageList);
    }
    @Override
    public PageInfo<Barrage> p1Page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.p1Page();
        return PageInfo.of(barrageList);
    }
    @Override
    public PageInfo<Barrage> ruibinPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.ruibinPage();
        return PageInfo.of(barrageList);
    }
    @Override
    public PageInfo<Barrage> XTTPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.XTTPage();
        return PageInfo.of(barrageList);
    }
    @Override
    public PageInfo<Barrage> DGQPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.DGQPage();
        return PageInfo.of(barrageList);
    }
    @Override
    public PageInfo<Barrage> baiziPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.baiziPage();
        return PageInfo.of(barrageList);
    }
    @Override
    public PageInfo<Barrage> QUQUPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Barrage> barrageList = webMapper.QUQUPage();
        return PageInfo.of(barrageList);
    }


    @Override
    public List<Barrage> allPage() {
        List<Barrage> barrageList = webMapper.allPage();
        return barrageList;
    }

}
