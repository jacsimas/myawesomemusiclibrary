package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.security.AppUserPrincipal;
import com.example.MyAwesomeMusicLibrary.model.User;
import com.example.MyAwesomeMusicLibrary.repository.LoginRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginDetailsService implements UserDetailsService {

    private final LoginRepository loginRepository;

    public UserLoginDetailsService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String passedUsername) throws UsernameNotFoundException {
        Optional<User> appUserOptional = loginRepository.findByName(passedUsername);


        if (appUserOptional.isPresent()) {
            User appUser = appUserOptional.get();

            return new AppUserPrincipal(appUser);

        } else {
            throw new UsernameNotFoundException(passedUsername);
        }
    }


}
