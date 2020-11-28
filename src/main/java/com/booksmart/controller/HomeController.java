package com.booksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/faq")
    public String faq() {
        return "faq";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/product")
    public String product() {
        return "product";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/shipping")
    public String shipping() {
        return "shipping";
    }

    @RequestMapping("/shop")
    public String shop() {
        return "shop";
    }

    @RequestMapping("/terms-conditions")
    public String termsConditions() {
        return "terms-conditions";
    }

    @RequestMapping("/checkout")
    public String checkout() {
        return "checkout";
    }
}
