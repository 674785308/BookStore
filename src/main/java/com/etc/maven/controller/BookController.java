package com.etc.maven.controller;

import com.etc.maven.controller.base.BaseController;
import com.etc.maven.domain.Book;
import com.etc.maven.domain.TuiJian;
import com.etc.maven.domain.User;
import com.etc.maven.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

//    @ResponseBody
//    @RequestMapping("/showBook.do")
//    public Map<String, Object> showBook(Integer tid,String bname,Integer bid ) {
//        resultmap.clear();
//        Map<String, Object> map = new HashMap<>();
//        map.put("tid",tid);
//        map.put("bname",bname);
//        map.put("bid",bid);
//        List<Map<String, Object>> list = bookService.showBook(map);
//        if (list.size()>0){
//            map.put("code",200);
//            map.put("msg","success");
//            map.put("result",list);
//        }else {
//            map.put("code",201);
//            map.put("msg","fail");
//        }
//        return resultmap;
//    }

    @ResponseBody
    @RequestMapping("/showByType.action")
    public Map<String,Object>showBookByType(Integer tid){
        resultmap.clear();
       List<Map<String,Object>> books = bookService.showBookByType(tid);
       if (books.size()>0){
           resultmap.put("code",200);
           resultmap.put("msg","success");
           resultmap.put("result",books);
       }else {
           resultmap.put("code",201);
           resultmap.put("msg","fail");
       }
       return resultmap;
    }

    @ResponseBody
    @RequestMapping("/showBookByName.action")
    public Map<String,Object> showBookByName(@RequestParam Map<String,Object> param){
        resultmap.clear();
        System.out.println(param);
        List<Map<String,Object>> books = bookService.showBookByName(param);
//        System.out.println(books);
//        System.out.println(books.size());

        if (books.size()>0){
            resultmap.put("code",200);
            resultmap.put("msg","success");
            resultmap.put("result",books);
        }else {
            resultmap.put("code",201);
            resultmap.put("msg","fail");
        }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/showBookById.action")
    public Map<String,Object> showBookById(Integer bid){
        resultmap.clear();
        List<Map<String,Object>> book = bookService.showBookById(bid);
       if (book!=null){
           resultmap.put("code",200);
           resultmap.put("msg","success");
           resultmap.put("result",book);
       }else {
           resultmap.put("code",201);
           resultmap.put("msg","fail");
       }
       return resultmap;
    }


    @ResponseBody
    @RequestMapping("/showByHot.action")
    public Map<String,Object> showByHot(){
        resultmap.clear();
        List<Map<String,Object>> books = bookService.showByHot();
        if (books.size()>0){
            resultmap.put("code",200);
            resultmap.put("msg","success");
            resultmap.put("result",books);
        }else {
            resultmap.put("code",201);
            resultmap.put("msg","fail");
        }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/addTuiJian.action")
    public Map<String,Object> addTuiJian(int bid, HttpSession session){
        resultmap.clear();
        TuiJian tuiJian = new TuiJian();
        tuiJian.setBid(bid);
       String who = ((User)(session.getAttribute("user"))).getAccount();
        tuiJian.setWho(who);
        int result = 0;
        try {
            result = bookService.addTuijian(tuiJian);
            if (result>0){
                resultmap.put("code",200);
                resultmap.put("msg","添加推荐成功");
            }else {
                resultmap.put("code",201);
                resultmap.put("msg","添加推荐失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultmap;

    }

    @ResponseBody
    @RequestMapping("/removeTuiJian.action")
    public Map<String,Object> removeTuiJian(int bid){
        resultmap.clear();
        int result = 0;
        try {
            result = bookService.removeTuiJian(bid);
            if (result>0){
                resultmap.put("code",200);
                resultmap.put("msg","删除推荐成功");
            }else {
                resultmap.put("code",201);
                resultmap.put("msg","删除推荐失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultmap;
    }
    @ResponseBody
    @RequestMapping("/showTuiJian.action")
    public Map<String,Object> showTuiJian(){
       List<Map<String,Object>> books = bookService.showTuiJian();
       if (books.size()>0){
           resultmap.put("code",200);
           resultmap.put("msg","success");
           resultmap.put("result",books);
       }else {
           resultmap.put("code",201);
           resultmap.put("msg","fail");
       }return resultmap;
    }

//    @ResponseBody
//    @RequestMapping("/updateTuiJian1.action")
//    public Map<String,Object> updateTuiJian1(int bid){
//       int result = bookService.updateTuiJian1(bid);
//       if (result>0){
//           resultmap.put("code",200);
//           resultmap.put("msg","success");
//       }else {
//           resultmap.put("code",201);
//           resultmap.put("msg","fail");
//       }return resultmap;
//    }
    @ResponseBody
    @RequestMapping("/hotTop10.action")
    public Map<String,Object> hotTop10(){
        resultmap.clear();
       List<Map<String,Object>> books = bookService.hotTop10();
       if (books.size()>0){
           resultmap.put("code",200);
           resultmap.put("msg","success");
           resultmap.put("result",books);
       }else {
           resultmap.put("code",201);
           resultmap.put("msg","fail");
       }
      return resultmap;
    }

    @ResponseBody
    @RequestMapping("/selectPriceById.do")
    public Map<String,Object> selectPriceById(int bid){
        resultmap.clear();
       Double price = bookService.selectPriceById(bid);
       if (price!=null){
           resultmap.put("code",200);
           resultmap.put("msg","success");
            resultmap.put("result",price);
       }else {
           resultmap.put("code",201);
           resultmap.put("msg","fail");
       }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/getKucun.do")
    public Map<String,Object> getKucun(int bid){
        resultmap.clear();
       int kucun = bookService.getKucun(bid);
        if (kucun>0){
            resultmap.put("code",200);
            resultmap.put("msg","success");
            resultmap.put("result",kucun);
        }else {
            resultmap.put("code",201);
            resultmap.put("msg","fail");
        }
        return resultmap;
    }

    @ResponseBody
    @RequestMapping("/setSoldKucun")
    public Map<String,Object> setSoldKucun(int many,int bid){
        Map<String,Object> map = new HashMap<>();
        map.put("many",many);
        map.put("bid",bid);
       int result = bookService.setSoldKucun(map);
       if (result>0){
           resultmap.put("code",200);
           resultmap.put("msg","success");
           resultmap.put("result",result);
       }else {
           resultmap.put("code",201);
           resultmap.put("msg","fail");
       }
        return resultmap;
    }





















}
