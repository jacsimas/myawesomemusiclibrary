package com.example.MyAwesomeMusicLibrary.repository;

import com.example.MyAwesomeMusicLibrary.model.Album;
import com.example.MyAwesomeMusicLibrary.model.FavoriteSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteSongRepository extends JpaRepository<FavoriteSong, Integer> {

    FavoriteSong findByUserIdAndSongId(Integer userId, Integer songId);
}
