package com.dgq63136.springboot.controller;

import com.dgq63136.springboot.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
    public Result addBarrage(){

        return Result.success();
    }
}
