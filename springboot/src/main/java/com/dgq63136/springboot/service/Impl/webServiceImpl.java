package com.dgq63136.springboot.service.Impl;

import com.dgq63136.springboot.entity.barrage;
import com.dgq63136.springboot.service.webService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class webServiceImpl implements webService {

    @Autowired
    private com.dgq63136.springboot.mapper.webMapper webMapper;

    @Override
    public PageInfo<barrage> selectPage(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<barrage> barrageList = webMapper.page();


        return PageInfo.of(barrageList);
    }
}
