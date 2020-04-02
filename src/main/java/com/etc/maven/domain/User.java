package com.etc.maven.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int uid;
    private String account;
    private String password;
    private int isadmin;
    private double money;
}
