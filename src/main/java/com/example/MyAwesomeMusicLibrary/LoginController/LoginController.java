package com.example.MyAwesomeMusicLibrary.LoginController;


import com.example.MyAwesomeMusicLibrary.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public void userLogin(@RequestBody User user){

    }
}
