package com.dgq63136.springboot.controller;


import com.dgq63136.springboot.common.Result;
import com.dgq63136.springboot.entity.barrage;
import com.dgq63136.springboot.service.webService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class webController {

    @Autowired
    private webService webService;


    @GetMapping("/2022/Page")
    public Result JZCM2022(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/2023/Page")
    public Result JZCM2023(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/2024/Page")
    public Result JZCM2024(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/p1/Page")
    public Result p1(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/ruibin/Page")
    public Result ruibin(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/XTT/Page")
    public Result XTT(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/DGQ/Page")
    public Result DGQ(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/baizi/Page")
    public Result baizi(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/QUQU/Page")
    public Result QUQU(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){

        log.info("分页数据：{}{}",pageNum,pageSize);

        PageInfo<barrage> pageInfo = webService.selectPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

}
