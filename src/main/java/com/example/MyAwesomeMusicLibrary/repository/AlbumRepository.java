package com.example.MyAwesomeMusicLibrary.repository;

import com.example.MyAwesomeMusicLibrary.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Album findByTitleAndArtistId(String title, Integer artistId);
}
