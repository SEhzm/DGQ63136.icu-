package com.dgq63136.springboot.controller;


import com.dgq63136.springboot.common.Result;
import com.dgq63136.springboot.entity.Image;
import com.dgq63136.springboot.service.ImagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ImagesController {

    @Autowired
    private ImagesService imagesService;



    @GetMapping("/showImage")
    public Result showImage(){
        log.info("进入了时光相册");
        List<Image> list = imagesService.showImage();

        return Result.success(list);
    }

}
