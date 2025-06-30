package org.example.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {

    // 根路径直接转发 index.html
    @RequestMapping("/")
    public String root() {
        return "forward:/index.html";
    }

    // 匹配所有没有点（.）的路径，避免拦截静态资源文件（比如 *.js, *.css）
    @RequestMapping(value = "/**/{path:[^.]*}")
    public String forward() {
        return "forward:/index.html";
    }
}

