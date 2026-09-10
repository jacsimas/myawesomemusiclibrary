package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.model.AppUser;
import com.example.MyAwesomeMusicLibrary.repository.LoginRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserLoginDetailsServiceImpl implements UserDetailsService {

    private final LoginRepository loginRepository;

    public UserLoginDetailsServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String passedUsername) throws UsernameNotFoundException {
        Optional<AppUser> appUserOptional = loginRepository.findByUsername(passedUsername);


        if (appUserOptional.isPresent()) {
            AppUser appUser = appUserOptional.get();

           return User.builder()
                    .username(appUser.getUsername())
                    .password(appUser.getPassword())
                    .roles(appUser.getRole().split(","))
                    .build();

        } else {
            throw new UsernameNotFoundException(passedUsername);
        }
    }


}
