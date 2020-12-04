package com.booksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/return")
    public String shippingAndReturns() {
        return "return";
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

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUserPost(
            HttpServletRequest request,
            @ModelAttribute("email") String userEmail,
            @ModelAttribute("username") String username,
            Model model
    ) throws Exception {
        model.addAttribute("usernameExists", true);
        model.addAttribute("emailExists", false);
        model.addAttribute("emailSent", true);
/*
        if(userService.findByUsername(username) != null) {
            model.addAttribute("usernameExists", true);

            return "myAccount";
        }

        if(userService.findByEmail(userEmail) != null) {
            model.addAttribute("emailExists", true);

            return "myAccount";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(userEmail);

        String password = SecurityUtility.randomPassword();

        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        user.setPassword(encryptedPassword);

        Role role = new Role();
        role.setRoleId(1);
        role.setName("ROLE_USER");
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, role));
        userService.createUser(user, userRoles);

        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);

        String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();


        SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);

        mailSender.send(email);

        model.addAttribute("emailSent", "true");

        model.addAttribute("orderList", user.getOrderList());
*/
        return "register";
    }
}
