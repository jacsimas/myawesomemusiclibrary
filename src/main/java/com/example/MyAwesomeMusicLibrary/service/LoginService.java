package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.repository.LoginRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LoginService {

    LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
}
