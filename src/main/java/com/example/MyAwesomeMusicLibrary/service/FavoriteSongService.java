package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.model.FavoriteSong;

import java.util.List;

public interface FavoriteSongService {
    List<FavoriteSong> findAll();

    String saveFavSong(FavoriteSong favoriteSong);
}
