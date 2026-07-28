package com.example.MyAwesomeMusicLibrary.libraryAccessControllers;

import com.example.MyAwesomeMusicLibrary.model.Album;
import com.example.MyAwesomeMusicLibrary.service.AlbumService;
import com.example.MyAwesomeMusicLibrary.service.AlbumServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {

    AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/api/list")
    public List<Album> getAlbums(){
        return albumService.showAll();
    }

    @PostMapping("/api/add-album")
    public String addAlbum(@RequestBody Album album){
        return albumService.addNewAlbum(album);
    }

    @GetMapping("/library/albums")
    public List<Album> getLibraryAlbums(){
        return albumService.showAll();
    }
}
