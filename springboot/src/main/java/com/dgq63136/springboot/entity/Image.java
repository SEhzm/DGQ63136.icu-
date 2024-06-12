package com.dgq63136.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private Long id;
    private String url;
    private String date;
    private List<Comment> comments;
    private Boolean showComments;
}
