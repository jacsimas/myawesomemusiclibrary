package com.example.MyAwesomeMusicLibrary.repository;

import com.example.MyAwesomeMusicLibrary.model.FavoriteAlbum;
import com.example.MyAwesomeMusicLibrary.model.FavoriteSong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteAlbumRepository extends JpaRepository<FavoriteAlbum, Integer> {


    FavoriteAlbum findByUserIdAndAlbumId(Integer userId, Integer albumId);

}
