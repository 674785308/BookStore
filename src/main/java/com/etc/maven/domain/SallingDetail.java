package com.etc.maven.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SallingDetail implements Serializable {
    private int cid;
    private int bid;
    private int many;
    private double much;


}
