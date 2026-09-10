package com.example.MyAwesomeMusicLibrary.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;


@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String password;
    private String role;

    public AppUser() {
    }

    public AppUser(String username, String password, List<GrantedAuthority> roles, boolean b, boolean b1) {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRoles(String role) {
        this.role = role;
    }
}
