package com.etc.maven.service;

import com.etc.maven.domain.TuiJian;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Map<String,Object>> showBookByType(Integer tid);

    //List<Map<String,Object>> showBookByName(String bname);
    List<Map<String,Object>> showBookByName(Map<String, Object> param);

    List<Map<String,Object>> showBookById( Integer bid);

    List<Map<String,Object>> showByHot();

    int addTuijian(TuiJian tuiJian) throws Exception;
    int removeTuiJian(@Param("bid") Integer bid) throws Exception;

    List<Map<String,Object>> hotTop10();
    List<Map<String,Object>> showTuiJian();

    Double selectPriceById ( Integer bid);

    Integer getKucun( Integer bid);

    int setSoldKucun(Map<String,Object> param);


}
