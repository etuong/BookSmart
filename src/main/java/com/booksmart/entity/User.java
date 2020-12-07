package com.booksmart.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    Long id;
    @Column(nullable = false, unique = true)
    String username;
    String password;
    @Column(name = "email", nullable = false, updatable = false)
    String email;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
