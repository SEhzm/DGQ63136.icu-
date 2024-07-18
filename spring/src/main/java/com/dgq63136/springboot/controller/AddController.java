package com.dgq63136.springboot.controller;

import com.dgq63136.springboot.common.Result;
import com.dgq63136.springboot.service.AddService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@Slf4j
@CrossOrigin
public class AddController {

    /**
     * 当cache存<ip，time>
     */
    private static ConcurrentHashMap<String, Long> requestCountMap = new ConcurrentHashMap<>();

    @Autowired
    private AddService addService;

    /**
     * 投稿弹幕
     * @param requestBody
     * @return
     */
    @PostMapping("/addBarrage")
    public Result addBarrage(@RequestBody Map<String, String> requestBody) {
        String ip = requestBody.get("ip");
        if (!limitRequestFrequencyForaddBarrage(ip)) {
            //访问频率过限
            System.out.println("访问频率过限");
            return Result.error("访问频率过限");
        }
        String table = requestBody.get("table");
        String barrage = requestBody.get("barrage");
        log.info("用户：{}往{}表里插入了：{}", ip,table, barrage);
        addService.addBarrage(table, barrage);
        return Result.success();
    }

    /**
     * 复制弹幕次数自增
     */
    @PostMapping("/addCnt")
    public Result addCnt(@RequestBody Map<String, String> requestBody){
//        System.out.println(requestBody);
        String ip = requestBody.get("ip");
        if (!limitRequestFrequencyForaddCnt(ip)) {
            //访问频率过限
            System.out.println("访问频率过限");
            return Result.error("访问频率过限");
        }
        String table = requestBody.get("table");
        String id = requestBody.get("id");
        log.info("用户:{}复制了:{}表里的:{}",ip,table,id);
        addService.addCnt(table,id);
        return Result.success();
    }

    /**
     * 限制访问频率
     * @param ip
     * @return
     */
    private boolean limitRequestFrequencyForaddBarrage(String ip) {//https://blog.csdn.net/weixin_44060488/article/details/129727934
        Long lastRequestTime = requestCountMap.get(ip);
        long now = System.currentTimeMillis();
        if (lastRequestTime != null && (now - lastRequestTime) < 1500) { //单位ms
            return false;
        }
        requestCountMap.put(ip, now);
        return true;
    }

    /**
     * 限制投稿频率
     * @param ip
     * @return
     */
    private boolean limitRequestFrequencyForaddCnt(String ip) {//https://blog.csdn.net/weixin_44060488/article/details/129727934
        Long lastRequestTime = requestCountMap.get(ip);
        long now = System.currentTimeMillis();
        if (lastRequestTime != null && (now - lastRequestTime) < 500) { //单位ms
            return false;
        }
        requestCountMap.put(ip, now);
        return true;
    }

}
