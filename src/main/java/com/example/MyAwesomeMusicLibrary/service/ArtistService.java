package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> showAll();

    String addNewArtist(Artist artist);
}
