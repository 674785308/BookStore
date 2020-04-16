package com.etc.maven.service.impl;

import com.etc.maven.dao.BookMapper;
import com.etc.maven.domain.TuiJian;
import com.etc.maven.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Map<String, Object>> showBookByType(Integer tid) {
        return bookMapper.showBookByType(tid);
    }

    @Override
    public List<Map<String,Object>> showBookByName(Map<String, Object> param) {
        return bookMapper.showBookByName(param);
    }

    @Override
    public List<Map<String,Object>> showBookById(Integer bid) {
        return bookMapper.showBookById(bid);
    }

    @Override
    public List<Map<String,Object>> showByHot() {
        return bookMapper.showByHot();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public int addTuijian(TuiJian tuiJian) throws Exception {
       int result = -1;
       int a = bookMapper.addTuijian(tuiJian);
       int b = bookMapper.updateTuiJian1(tuiJian.getBid());
       if (a<=0 || b <= 0){
           throw new Exception();
       }else {
           result = 1;
       }return result;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public int removeTuiJian(Integer bid) throws Exception {
        int result = -1;
        int a = bookMapper.removeTuiJian(bid);
        int b = bookMapper.updateTuiJian0(bid);
        if (a<=0 || b <=0){
            throw new Exception();
        }else {
            result = 1;
        }return result;
    }



    @Override
    public List<Map<String, Object>> hotTop10() {
        return bookMapper.hotTop10();
    }

    @Override
    public List<Map<String, Object>> showTuiJian() {
        return bookMapper.showTuiJian();
    }

    @Override
    public Double selectPriceById(Integer bid) {
        return bookMapper.selectPriceById(bid);
    }


    @Override
    public Integer getKucun(Integer bid) {
        return bookMapper.getKucun(bid);
    }

    @Override
    public int setSoldKucun(Map<String, Object> param) {
        return bookMapper.setSoldKucun(param);
    }
}
