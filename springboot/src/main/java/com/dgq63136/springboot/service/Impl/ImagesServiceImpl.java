package com.dgq63136.springboot.service.Impl;


import com.dgq63136.springboot.entity.Comment;
import com.dgq63136.springboot.entity.Image;
import com.dgq63136.springboot.mapper.ImagesMapper;
import com.dgq63136.springboot.service.ImagesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesMapper imagesMapper;

    @Override
    public List<Image> showImage() {
        List<Image> imageList = imagesMapper.showImage();
        imageList.forEach(image -> {
            image.setComments(imagesMapper.showCommert(image.getId()));
        });
        return imageList;
    }

    @Override
    public void addComment(Comment comment) {
        // 获取当前的LocalDateTime对象
        LocalDateTime now = LocalDateTime.now();

        // 创建一个 DateTimeFormatter 对象，格式化模式为"yyyy-MM-dd HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 使用formatter将LocalDateTime格式化为字符串
        String formattedNow = now.format(formatter);
        comment.setCreatedAt(formattedNow);
        imagesMapper.addComment(comment);
//        System.out.println(comment);
    }
}
