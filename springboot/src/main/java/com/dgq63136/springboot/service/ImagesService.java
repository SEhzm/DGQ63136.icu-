package com.dgq63136.springboot.service;

import com.dgq63136.springboot.entity.Comment;
import com.dgq63136.springboot.entity.Image;

import java.util.List;

public interface ImagesService {
    List<Image> showImage();

    void addComment(Comment comment);
}
