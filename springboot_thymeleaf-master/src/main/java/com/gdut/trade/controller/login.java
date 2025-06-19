package com.gdut.trade.controller;

import com.gdut.trade.model.SysUser;
import com.gdut.trade.service.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class login {

    @Autowired
    private SysUserService sysUserService;

    /*默认访问登录页*/
    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    /*再点击登录后，要跳转到默认的admin首页。这里由两个问题，1是点击按钮上的action 路径*/
    @PostMapping("/login")
    public String admin(SysUser user, HttpSession session, Model model) {
        //判断账号密码是否正确
        if (user.getUserName().equals("admin") && user.getPassword().equals("123456")) {
            // 要是密码和用户名正确，应该将用户存入域中；
            session.setAttribute("user", user);// session.setattribute();
            return "redirect:/main.html";
        } else {
            model.addAttribute("admin_msg", "账号或密码不正确，请重新输入");
            return "login";
        }

        // return  "redirect:/main"; //看懂这一块了，重定向不能直接重定向到页面，只能重定向到请求。html不是jsp，可以重定向到jsp。
        /*额，无意中还把post防刷写处理来了。*/
    }

    @GetMapping("/main.html")
    public String admin2(SysUser user, HttpSession session, Model model) {
        SysUser user1 = (SysUser) session.getAttribute("user");
        if (user1 != null) {
            //进入主页后需要一个用户名的名字。从user中取出来
            //model.addAttribute("username",user1.getSysUserName());
            return "main";
        }
        model.addAttribute("admin_msg", "请先登录");
        //往session域中放一个提示信息，admin_msg
        return "redirect:/login";

    }
}
