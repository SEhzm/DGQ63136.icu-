package com.dgq63136.springboot.controller;


import com.dgq63136.springboot.common.Result;
import com.dgq63136.springboot.entity.Comment;
import com.dgq63136.springboot.entity.Image;
import com.dgq63136.springboot.service.ImagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment){
        log.info("{} 评论了：{}",comment.getDouyuID(),comment.getCommentname());
//        imagesService.addComment(comment);
        System.out.println(comment);
        return Result.success();
    }
}
