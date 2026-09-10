package com.example.MyAwesomeMusicLibrary.repository;

import com.example.MyAwesomeMusicLibrary.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {


}
