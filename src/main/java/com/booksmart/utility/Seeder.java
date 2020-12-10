package com.booksmart.utility;

import com.booksmart.entity.Role;
import com.booksmart.entity.User;
import com.booksmart.service.BookService;
import com.booksmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Seeder {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public void seedUsers() {
        User user = User.builder().username("q").password("q").email("noreply@gmail.com").build();
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        roles.add(role);

        userService.createUser(user, roles);
    }

    public void seedBooks() {
        
    }
}
