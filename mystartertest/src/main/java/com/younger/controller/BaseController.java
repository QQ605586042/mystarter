package com.younger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @RequestMapping("/404.do")
    public String page404(){
        return "页面去火星啦";
    }
}
