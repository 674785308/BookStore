package com.etc.maven.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private Integer bid;
    private String bname;
    private String author;
    private Integer tid;
    private Integer kucun;
    private Integer sold;
    private Double price;
    private Integer tuijian ;


}
