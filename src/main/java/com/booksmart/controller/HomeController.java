package com.booksmart.controller;

import com.booksmart.entity.Book;
import com.booksmart.service.BookService;
import com.booksmart.service.UserService;
import com.booksmart.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MailConstructor mailConstructor;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Book> books = bookService.findAll().subList(0, 10);
        Collections.shuffle(books);
        model.addAttribute("books", books);
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
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
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
