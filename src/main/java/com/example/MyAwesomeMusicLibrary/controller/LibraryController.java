package com.example.MyAwesomeMusicLibrary.controller;

import com.example.MyAwesomeMusicLibrary.model.Song;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {


    @GetMapping("/albums")
public void getAlbums(){

    }


    @GetMapping("/artists")
    public void getArtists(){

    }

}
