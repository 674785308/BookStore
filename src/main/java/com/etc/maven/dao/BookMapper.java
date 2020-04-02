package com.etc.maven.dao;

import com.etc.maven.domain.Book;
import com.etc.maven.domain.TuiJian;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper {

    //List<Map<String,Object>>  showBook(Map<String,Object> map);

    List<Map<String,Object>> showBookByType(@Param("tid") Integer tid);

    List<Map<String,Object>> showBookByName(Map<String, Object> param);

    List<Map<String,Object>> showBookById(@Param("bid") Integer bid);

    List<Map<String,Object>> showByHot();

    int addTuijian(TuiJian tuiJian);
    int removeTuiJian(@Param("bid") Integer bid);

    int updateTuiJian1(@Param("bid") Integer bid);

    int updateTuiJian0(@Param("bid") Integer bid);

    List<Map<String,Object>> showTuiJian();

    List<Map<String,Object>> hotTop10();

    Double selectPriceById (@Param("bid") Integer bid);

    Integer getKucun(@Param("bid") Integer bid);

    int setSoldKucun(Map<String,Object> param);


}
