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
        String table = requestBody.get("table");
        String barrage = requestBody.get("barrage");
        log.info("往{}表里插入了{}", table, barrage);
        addService.addBarrage(table, barrage);
        return Result.success();
    }

    /**
     * 复制弹幕次数自增
     */
    @PostMapping("/addCnt")
    public Result addCnt(@RequestBody Map<String, String> requestBody){
        System.out.println(requestBody);
        String ip = requestBody.get("ip");
        if (!limitRequestFrequency(ip)) {
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

    private boolean limitRequestFrequency(String ip) {
        Long lastRequestTime = requestCountMap.get(ip);
        long now = System.currentTimeMillis();
        if (lastRequestTime != null && (now - lastRequestTime) < 1500) { //https://blog.csdn.net/weixin_44060488/article/details/129727934
            return false;
        }
        requestCountMap.put(ip, now);
        return true;
    }

}
