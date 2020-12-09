package com.booksmart.controller;

import com.booksmart.service.UserService;
import com.booksmart.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private MailConstructor mailConstructor;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("isHomeActive", true);
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("isAboutActive", true);
        return "about";
    }

    @RequestMapping("/faq")
    public String faq(Model model) {
        model.addAttribute("isFaqActive", true);
        return "faq";
    }

    @RequestMapping("/book")
    public String book() {
        return "book";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/return")
    public String shippingAndReturns() {
        return "return";
    }

    @RequestMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("isShopActive", true);
        return "shop";
    }

    @RequestMapping("/termsConditions")
    public String termsConditions() {
        return "termsConditions";
    }

    @RequestMapping("/403")
    public String forbiddenAccess() {
        return "403";
    }
}
