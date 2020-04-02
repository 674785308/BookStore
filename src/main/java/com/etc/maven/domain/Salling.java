package com.etc.maven.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salling implements Serializable {

    private int cid;
    private int uid;
    private int issal;
    private double totle;
}
