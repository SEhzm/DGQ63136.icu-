package com.dgq63136.springboot.controller;


import com.dgq63136.springboot.common.Result;
import com.dgq63136.springboot.entity.Barrage;
import com.dgq63136.springboot.service.WebService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class WebController {

    @Autowired
    private WebService webService;


    @GetMapping("/allBarrage/Page")
    public Result allBarrage(@RequestParam(defaultValue = "1") Boolean status){
        if (status){
            log.info("进入首页");
        }else
        {
            log.info("进入全部弹幕页");
        }
        List<Barrage> barrageList = webService.allPage();

        return Result.success(barrageList);
    }
    @GetMapping("/JZCM/Page")
    public Result JZCM(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("警钟长鸣 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.JZCMPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/J2022/Page")
    public Result JZCM2022(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("2022警钟长鸣 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.J2022Page(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/J2023/Page")
    public Result JZCM2023(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("2023警钟长鸣 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.J2023Page(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/J2024/Page")
    public Result JZCM2024(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("2024警钟长鸣 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.J2024Page(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/p1/Page")
    public Result p1(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "50") Integer pageSize){

        log.info("+1页 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.p1Page(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/ruibin/Page")
    public Result ruibin(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("瑞斌页 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.ruibinPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/XTT/Page")
    public Result XTT(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("XTT 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.XTTPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/DGQ/Page")
    public Result DGQ(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("DGQ 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.DGQPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/baizi/Page")
    public Result baizi(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("白字 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.baiziPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/QUQU/Page")
    public Result QUQU(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "15") Integer pageSize){

        log.info("QUQU 分页数据：{},{}",pageNum,pageSize);

        PageInfo<Barrage> pageInfo = webService.QUQUPage(pageNum,pageSize);
        return Result.success(pageInfo);
    }

}
