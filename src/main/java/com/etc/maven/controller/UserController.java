package com.etc.maven.controller;

import com.etc.maven.controller.base.BaseController;
import com.etc.maven.domain.User;
import com.etc.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping("/login.action")
    public Map<String,Object> login(String account, String password, HttpSession session){
       User user = userService.login(account);
       resultmap.clear();
       if (user == null){
        resultmap.put("code",201);
        resultmap.put("msg","账号不存在");
       }else if (!user.getPassword().equals(password)){
           resultmap.put("code",202);
           resultmap.put("msg","密码不正确");
       }else if (user.getIsadmin() == 1){
           resultmap.put("code",250);
           resultmap.put("msg","登录成功");
           resultmap.put("user",user);
           session.setAttribute("user",user);
       }else {
           resultmap.put("code",200);
           resultmap.put("msg","登录成功");
           resultmap.put("user",user);
           session.setAttribute("user",user);
       }
       return resultmap;

    }

    @ResponseBody
    @RequestMapping("/signIn.action")
    public Map<String,Object> signIn(String account,String password){
        resultmap.clear();
       int result = userService.signIn(account,password);
       if (result>0){
           resultmap.put("code",200);
           resultmap.put("msg","添加账号成功");
       }else {
           resultmap.put("code",201);
           resultmap.put("msg","添加账号失败");
       }
       return resultmap;

    }
    @ResponseBody
    @RequestMapping("/showMyAccount.action")
    public Map<String,Object> showMyAccount(HttpSession session){
        resultmap.clear();
        int uid = ((User)(session.getAttribute("user"))).getUid();
       User user = userService.showMyAccount(uid);
       if (user!=null){
           resultmap.put("code",200);
           resultmap.put("msg","success");
           resultmap.put("result",user);
       }else {
           resultmap.put("code",201);
           resultmap.put("msg","fail");
       }
       return resultmap;
    }

    @ResponseBody
    @RequestMapping("/exit.action")
    public void exit(HttpSession session){
        session.removeAttribute("user");
    }

    @ResponseBody
    @RequestMapping("/showName.action")
    public String showName(HttpSession session){
       String name = ((User)(session.getAttribute("user"))).getAccount();
       return name;
    }
    @ResponseBody
    @RequestMapping("/showUid.action")
    public int showUid (HttpSession session){
        int uid = ((User)(session.getAttribute("user"))).getUid();
        return uid;
    }

    @ResponseBody
    @RequestMapping("/changeMyAccount.action")
    public Map<String,Object> changeMyAccount(String password,String newPassword,HttpSession session) {
        String account = ((User) (session.getAttribute("user"))).getAccount();
        if (userService.isMe(account).equals(password)) {
            resultmap.clear();
            int result = userService.changeMyAccount(newPassword,account);
            if (result>0) {
                resultmap.put("code", 200);
                resultmap.put("msg", "修改信息成功");

            } else {
                resultmap.put("code", 201);
                resultmap.put("msg", "修改信息失败");
            }
        }else {
            resultmap.put("code", 202);
            resultmap.put("msg", "初始密码不正确");
        }return resultmap;
    }


}
