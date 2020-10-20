package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping(value = {"/", "/index"})
    public String indexPage() {
        return "index";
    }

    @GetMapping(value = "/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping(value = "/user")
    public String userPage(){
        return "user";
    }

    @GetMapping(value = "/product")
    public String productPage() {
        return "hello";
    }

    @GetMapping(value = "/login")
    public String Login() {
        return "login";
    }

    @GetMapping(value = "/401")
    public String page401() {
        return "401";
    }
}
