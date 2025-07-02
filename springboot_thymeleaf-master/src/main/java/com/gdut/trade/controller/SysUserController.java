package com.gdut.trade.controller;

import com.gdut.trade.model.SysUser;
import com.gdut.trade.service.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @GetMapping("")
    public String userList(Model model) {
        List<SysUser> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public SysUser getUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    @ResponseBody // 返回JSON响应
    public ResponseEntity<String> addUser(@ModelAttribute SysUser user) {
        userService.addUser(user);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/edit")
    @ResponseBody // 返回JSON响应
    public ResponseEntity<String> editUser(@ModelAttribute SysUser user) {
        userService.updateUser(user);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
