package com.example.MyAwesomeMusicLibrary.controller;

import com.example.MyAwesomeMusicLibrary.model.Album;
import com.example.MyAwesomeMusicLibrary.model.Artist;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/list")
    public List<Album> getAlbums(){
        return albumService.showAll();
    }

    @PostMapping("/add-album")
    public String addAlbum(@RequestBody Album album){
        return albumService.addNewAlbum(album);
    }

}
