package com.dgq63136.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Barrage implements Serializable {
    private Integer id;
    private String barrage;
    private String cnt;
}
