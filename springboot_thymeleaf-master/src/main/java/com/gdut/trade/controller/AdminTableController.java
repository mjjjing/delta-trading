package com.gdut.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminTableController {

    // Request URL: http://localhost:8080/basic_table.html 在页面上看到的请求路径。
    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";

    }
}
