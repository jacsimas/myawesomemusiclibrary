package com.example.MyAwesomeMusicLibrary.repository;

import com.example.MyAwesomeMusicLibrary.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Artist findByName(String name);
}
