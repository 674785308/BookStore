package com.etc.maven.controller;

import com.etc.maven.controller.base.BaseController;
import com.etc.maven.service.BookService;
import com.etc.maven.service.BoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoughtController extends BaseController {
    @Autowired
    private BoughtService boughtService;
    @Autowired
    private BookService bookService;


    @ResponseBody
    @RequestMapping("/addBought.action")
    public Map<String, Object> addBought(int bid, int many, int uid) {
        resultmap.clear();
        if (boughtService.isHave(uid) == null) {
            Double price = bookService.selectPriceById(bid);

            Map<String, Object> map = new HashMap<>();
            map.put("bid", bid);
            map.put("many", many);
            map.put("uid", uid);
            map.put("price", price);

            int result = 0;
            try {
                result = boughtService.addBought(map);
                if (result > 0) {
                    resultmap.put("code", 200);
                    resultmap.put("msg", "添加成功");
                    resultmap.put("result", result);
                } else {
                    resultmap.put("code", 201);
                    resultmap.put("msg", "添加失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Map<String, Object> param2 = new HashMap<>();
            Double price = bookService.selectPriceById(bid);
            int cid = boughtService.getCid(uid);

            param2.put("cid", cid);
            param2.put("bid", bid);
            param2.put("many", many);
            param2.put("uid", uid);
            param2.put("price", price);
            int result = boughtService.addBoughtDetails(param2);
            if (result > 0) {
                resultmap.put("code", 200);
                resultmap.put("msg", "添加成功");
                resultmap.put("result", result);
            } else {
                resultmap.put("code", 201);
                resultmap.put("msg", "添加失败");
            }

        }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/isHave.do")
    public Map<String, Object> isHave(Integer uid) {
        resultmap.clear();
        Map<String, Object> map = boughtService.isHave(uid);
        if (map != null) {
            resultmap.put("code", 200);
            resultmap.put("msg", "success");
            resultmap.put("result", map);
        } else {
            resultmap.put("code", 201);
            resultmap.put("msg", "fail");
        }
        return resultmap;
    }


    @ResponseBody
    @RequestMapping("/getCid.do")
    public int getCid(Integer uid) {
        resultmap.clear();
        int result = boughtService.getCid(uid);
        return result;
    }


    @ResponseBody
    @RequestMapping("/addBoughtDetails.action")
    public Map<String, Object> addBoughtDetails(int bid, int uid, int many) {
        resultmap.clear();
        int cid = boughtService.getCid(uid);
        Double price = bookService.selectPriceById(bid);
        Map<String, Object> map = new HashMap<>();
        map.put("cid", cid);
        map.put("bid", bid);
        map.put("many", many);
        map.put("price", price);
        int result = boughtService.addBoughtDetails(map);
        if (result > 0) {
            resultmap.put("code", 200);
            resultmap.put("msg", "success");
            resultmap.put("result", result);
        } else {
            resultmap.put("code", 201);
            resultmap.put("msg", "fail");
        }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/updataBoughtSal")
    public Map<String, Object> updataBoughtSal(int bid, int many, int uid) {
        resultmap.clear();
        Double price = bookService.selectPriceById(bid);
        int cid = boughtService.getCid(uid);
        Map<String, Object> param = new HashMap<>();
        param.put("price", price);
        param.put("many", many);
        param.put("cid", cid);
        int result = boughtService.updataBoughtSal(param);
        if (result > 0) {
            resultmap.put("code", 200);
            resultmap.put("msg", "success");
            resultmap.put("result", result);
        } else {
            resultmap.put("code", 201);
            resultmap.put("msg", "fail");
        }
        return resultmap;

    }

    @ResponseBody
    @RequestMapping("/showMyCart.action")
    public Map<String, Object> showMyCart(int uid) {
        resultmap.clear();
        List<Map<String, Object>> books = boughtService.showMyCart(uid);
        if (books.size() > 0) {
            resultmap.put("code", 200);
            resultmap.put("msg", "success");
            resultmap.put("result", books);
        } else {
            resultmap.put("code", 201);
            resultmap.put("msg", "fail");
        }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/clearMyCart.action")
    public Map<String, Object> clearMyCart(int uid) {
        resultmap.clear();
        int result = boughtService.clearMyCart(uid);
        if (result > 0) {
            resultmap.put("code", 200);
            resultmap.put("msg", "success");


        } else {
            resultmap.put("code", 201);
            resultmap.put("msg", "fail");
        }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/priceEnough.action")
    public Map<String, Object> priceEnough(int uid) {
        resultmap.clear();
        Double money = boughtService.priceEnough(uid);
        if (money >=0) {
            resultmap.put("code", 200);
            resultmap.put("msg", "success");
            resultmap.put("result", money);

        } else {
            resultmap.put("code", 201);
            resultmap.put("msg", "fail");
        }
        return resultmap;
    }
    @ResponseBody
    @RequestMapping("/updataBoughtSalDetail.action")
    public Map<String,Object> updataBoughtSalDetail(int many,int uid,int bid){
        resultmap.clear();
        Map<String,Object> map = new HashMap<>();
        // #{price} * #{many},many = #{many} where cid = #{cid} and bid= #{bid}
         Double price = bookService.selectPriceById(bid);
         int cid = boughtService.getCid(uid);
         map.put("price",price);
         map.put("many",many);
         map.put("cid",cid);
         map.put("bid",bid);
       int result =  boughtService.updataBoughtSalDetail(map);
       if (result>0){
           resultmap.put("code", 200);
           resultmap.put("msg", "success");
           resultmap.put("result", result);

       } else {
           resultmap.put("code", 201);
           resultmap.put("msg", "fail");
       }
        return resultmap;
    }


    @ResponseBody
    @RequestMapping("/showAllPrice.action")
    public Map<String,Object> showAllPrice(int uid){
        resultmap.clear();
       Double totle = boughtService.showAllPrice(uid);
       if (totle>=0){
           resultmap.put("code", 200);
           resultmap.put("msg", "success");
           resultmap.put("result", totle);

       } else {
           resultmap.put("code", 201);
           resultmap.put("msg", "fail");
       }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/changeIsSal.action")
    public Map<String,Object> changeIsSal(int uid){
        resultmap.clear();
       int result = boughtService.changeIsSal(uid);
       if (result>0){
           resultmap.put("code", 200);
           resultmap.put("msg", "success");
           resultmap.put("result", result);

       } else {
           resultmap.put("code", 201);
           resultmap.put("msg", "fail");
       }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/buyAll.action")
    public Map<String,Object>buyAll(){
        return null;
    }































    }
