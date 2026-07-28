package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> showAll();

    String addNewAlbum(Album album);
}
