package com.booksmart.controller;

import com.booksmart.entity.Role;
import com.booksmart.entity.User;
import com.booksmart.service.SecurityService;
import com.booksmart.service.UserService;
import com.booksmart.utility.MailConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("isLoginActive", true);
        return "login";
    }

    @RequestMapping("/loggedIn")
    public String loggedIn(Model model) {
        model.addAttribute("isHomeActive", true);
        return "index";
    }

    @RequestMapping("/loggedOut")
    public String loggedOut(Model model) {
        model.addAttribute("isHomeActive", true);
        return "index";
    }

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

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        roles.add(role);

        User user = new User();
        user.setUsername(username);
        user.setEmail(userEmail);
        user.setPassword(password);
        userService.createUser(user, roles);

        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Thank you for registering to BookSmart\r\n");
        messageBuilder.append("Your Username is " + user.getUsername() + "\r\n");
        messageBuilder.append("Your Password is " + user.getPassword() + "\r\n");
        MailConstructor.sendMail(user.getEmail(), "BookSmart - New User", messageBuilder.toString(), false);

        model.addAttribute("emailSent", true);

        return "login";
    }
}
