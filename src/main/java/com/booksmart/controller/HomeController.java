package com.booksmart.controller;

import com.booksmart.entity.User;
import com.booksmart.service.UserService;
import com.booksmart.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        System.out.println(principal.getName());
        return null;
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("isPosted") boolean isPosted, Model model) {
        if (isPosted) {
            return index(model);
        } else {
            model.addAttribute("isLoginActive", true);
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return index(model);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPosted(@ModelAttribute("password") String password,
                              @ModelAttribute("username") String username,
                              Model model) {
        User user = userService.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("noAccount", true);
            return "login";
        }

        model.addAttribute("hasLoggedIn", user.isHasLoggedIn());
        return "index";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(
//            HttpServletRequest request,
//            @ModelAttribute("password") String password,
//            @ModelAttribute("username") String username,
//            Model model) {
//
//        User user = userService.findByUsername(username);
//        if (user == null || !user.getPassword().equals(password)) {
//            model.addAttribute("noAccount", true);
//            return "login";
//        }
//
//        model.addAttribute("hasLoggedIn", user.isHasLoggedIn());
//        return "index";
//    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUserPost(
            HttpServletRequest request,
            @ModelAttribute("email") String userEmail,
            @ModelAttribute("password") String password,
            @ModelAttribute("username") String username,
            Model model
    ) throws Exception {
        model.addAttribute("usernameExists", false);
        model.addAttribute("emailExists", false);
        model.addAttribute("emailSent", false);

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
        user.setHasLoggedIn(true);
        userService.createUser(user);

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Thank you for registering to BookSmart\r\n");
        messageBuilder.append("Your Username is " + user.getUsername() + "\r\n");
        messageBuilder.append("Your Password is " + user.getPassword() + "\r\n");
        MailConstructor.sendMail(user.getEmail(), "BookSmart - New User", messageBuilder.toString(), false);

        model.addAttribute("emailSent", true);

        return "login";
    }
}
