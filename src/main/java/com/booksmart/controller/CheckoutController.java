package com.booksmart.controller;

import com.booksmart.entity.ShoppingCart;
import com.booksmart.entity.User;
import com.booksmart.service.CartItemService;
import com.booksmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;

import java.security.Principal;

@Controller
public class CheckoutController {
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/checkout")
    public String checkout(
            @RequestParam("id") Long cartId,
            Model model, Principal principal
    ) {
        User user = userService.findByUsername(principal.getName());

        if (cartId != user.getShoppingCart().getId()) {
            return "404";
        }

        ShoppingCart shoppingCart = user.getShoppingCart();
        model.addAttribute("shoppingCart", shoppingCart);

        return "checkout";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkoutPost(Principal principal,
                               Model model) {
        return "";
    }
}
