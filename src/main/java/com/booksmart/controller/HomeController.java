package com.booksmart.controller;

import com.booksmart.entity.User;
import com.booksmart.service.UserService;
import com.booksmart.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Autowired
    private JavaMailSender mailSender;

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

    @RequestMapping("/product")
    public String product() {
        return "product";
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

    @RequestMapping("/terms-conditions")
    public String termsConditions() {
        return "terms-conditions";
    }

    @RequestMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("isLoginActive", true);
        return "login";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUserPost(
            HttpServletRequest request,
            @ModelAttribute("email") String userEmail,
            @ModelAttribute("password") String password,
            @ModelAttribute("username") String username,
            Model model
    ) throws Exception {
        model.addAttribute("usernameExists", true);
        model.addAttribute("emailExists", false);
        model.addAttribute("emailSent", true);

        if (userService.findByUsername(username) != null) {
            model.addAttribute("usernameExists", true);
            return "register";
        }

        if (userService.findByEmail(userEmail) != null) {
            model.addAttribute("emailExists", true);
            return "register";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(userEmail);
        user.setPassword(password);
        userService.createUser(user);

        SimpleMailMessage email = mailConstructor.constructNewUserEmail(user);
        mailSender.send(email);

        model.addAttribute("emailSent", "true");

        return "login";
    }
}
