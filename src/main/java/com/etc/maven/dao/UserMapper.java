package com.etc.maven.dao;

import com.etc.maven.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    /**
     * 登录
     * @param account
     * @return
     */
    User login(String account);

    /**
     * 注册
     * @param account
     * @param password
     * @return
     */

    int signIn(@Param("account") String account,@Param("password") String password);

    /**
     * 显示个人信息
     * @param
     * @return
     */
    User showMyAccount(Integer uid);

    /**
     * 修改账户
     * @param newPassword
     * @param account
     * @return
     */

    int changeMyAccount(@Param("newPassword") String newPassword,@Param("account") String account);

    /**
     * 根据账号查询初始密码
     * @param account
     * @return
     */
    String isMe(@Param("account") String account);

    int cutMoney(Map<String, Object> param);



}
