package com.dgq63136.springboot.service.Impl;


import com.dgq63136.springboot.entity.Comment;
import com.dgq63136.springboot.entity.Image;
import com.dgq63136.springboot.mapper.ImagesMapper;
import com.dgq63136.springboot.service.ImagesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        comment.setCreatedAt(LocalDateTime.now().toString());
        imagesMapper.addComment(comment);
//        System.out.println(comment);
    }
}
