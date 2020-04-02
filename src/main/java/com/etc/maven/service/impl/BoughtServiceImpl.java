package com.etc.maven.service.impl;

import com.etc.maven.dao.BookMapper;
import com.etc.maven.dao.BoughtMapper;
import com.etc.maven.service.BoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BoughtServiceImpl implements BoughtService {
    @Autowired
    private BoughtMapper boughtMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public int addBought(Map<String,Object> param) throws Exception {
        int many = (int)(param.get("many"));
        int uid = (int)(param.get("uid"));
        Double price = (Double)(param.get("price"));
        int bid = (int)(param.get("bid"));
        int result =-1;
        int addBought = boughtMapper.addBought(param);
        Map<String,Object> param2 = new HashMap<>();
       Integer cid = boughtMapper.getCid(uid);
        param2.put("cid",cid);
        param2.put("bid", bid);
        param2.put("many",many);
        param2.put("uid",uid);
        param2.put("price",price);
        int addBoughtDetails = boughtMapper.addBoughtDetails(param2);
        if (addBought <= 0 || addBoughtDetails <= 0){
            throw new Exception();
        }else {
            result = 1;
        }

        return result;
    }

    @Override
    public int addBoughtDetails(Map<String, Object> param) {
        return boughtMapper.addBoughtDetails(param);
    }

    @Override
    public Map<String,Object> isHave(Integer uid) {
        return boughtMapper.isHave(uid);
    }

    @Override
    public Integer getCid(Integer uid) {
        return boughtMapper.getCid(uid);
    }

    @Override
    public int updataBoughtSal(Map<String, Object> param) {
        return boughtMapper.updataBoughtSal(param);
    }

    @Override
    public List<Map<String, Object>> showMyCart(Integer uid) {
        return boughtMapper.showMyCart(uid);
    }

    @Override
    public int clearMyCart(Integer uid) {
        return boughtMapper.clearMyCart(uid);
    }

    @Override
    public Double priceEnough(Integer uid) {
        return boughtMapper.priceEnough(uid);
    }

    @Override
    public int updataBoughtSalDetail(Map<String, Object> param) {
        return boughtMapper.updataBoughtSalDetail(param);
    }

    @Override
    public Double showAllPrice(Integer uid) {
        return boughtMapper.showAllPrice(uid);
    }

    @Override
    public int changeIsSal(Integer uid) {
        return boughtMapper.changeIsSal(uid);
    }
}
