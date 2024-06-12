package com.dgq63136.springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private Long imageId; // 外键，关联到Image表的id
    private String douyuID;
    private String createdAt;
    private String Commentname;
}
