package com.etc.maven.service;

import com.etc.maven.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User login(String account);

    int signIn(String account, String password);

    User showMyAccount(Integer uid);

    int changeMyAccount(String newPassword, String account);

    String isMe(String account);


}
