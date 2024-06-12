package com.dgq63136.springboot.mapper;

import com.dgq63136.springboot.entity.Comment;
import com.dgq63136.springboot.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImagesMapper {

    @Select("select * from images ORDER BY id DESC ")
    List<Image> showImage();

    @Select("select * from comments where image_id = #{id}")
    List<Comment> showCommert(Long id);
}
