package com.dgq63136.springboot.controller;

import com.dgq63136.springboot.common.Result;
import com.dgq63136.springboot.service.AddService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
public class AddController {

    @Autowired
    private AddService addService;

    @PostMapping("/addBarrage")
    public Result addBarrage(@RequestBody Map<String, String> requestBody) {
        String table = requestBody.get("table");
        String barrage = requestBody.get("barrage");
        log.info("往{}表里插入了{}", table, barrage);
        addService.addBarrage(table, barrage);
        return Result.success();
    }
}
