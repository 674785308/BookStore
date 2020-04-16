package com.etc.maven.service;

import java.util.List;
import java.util.Map;

public interface BoughtService {
    int addBought(Map<String, Object> param) throws Exception;

    int addBoughtDetails(Map<String, Object> param);

    Map<String, Object> isHave(Integer uid);

    Integer getCid(Integer uid);

    int updataBoughtSal(Map<String, Object> param);

    List<Map<String, Object>> showMyCart(Integer uid);

    int clearMyCart(Integer uid);

    Double priceEnough(Integer uid);

    int updataBoughtSalDetail(Map<String, Object> param);

    Double showAllPrice(Integer uid);

    int changeIsSal(Integer uid);






}
