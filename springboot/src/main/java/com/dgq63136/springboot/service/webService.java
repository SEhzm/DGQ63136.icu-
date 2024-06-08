package com.dgq63136.springboot.service;

import cn.hutool.db.PageResult;
import com.github.pagehelper.PageInfo;

public interface webService {
    PageInfo selectPage(Integer pageNum, Integer pageSize);
}
