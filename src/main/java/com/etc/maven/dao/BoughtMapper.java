package com.etc.maven.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BoughtMapper {

    int addBought(Map<String, Object> param);

    int addBoughtDetails(Map<String, Object> param);

    Map<String, Object> isHave(Integer uid);

    Integer getCid(Integer uid);

    int updataBoughtSal(Map<String, Object> param);

    List<Map<String, Object>> showMyCart(@Param("uid") Integer uid);

    int clearMyCart(Integer uid);

    Double priceEnough(Integer uid);

    int updataBoughtSalDetail(Map<String, Object> param);

    Double showAllPrice(Integer uid);

    int changeIsSal(Integer uid);

}
