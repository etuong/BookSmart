package com.booksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;

import java.security.Principal;

@Controller
public class CheckoutController {
    @Autowired
    private TemplateEngine templateEngine;

    @RequestMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkoutPost(Principal principal,
                               Model model) {
        return "";
    }
}
