package com.example.MyAwesomeMusicLibrary.libraryAccessControllers;

import com.example.MyAwesomeMusicLibrary.model.FavoriteAlbum;
import com.example.MyAwesomeMusicLibrary.service.FavoriteAlbumService;
import com.example.MyAwesomeMusicLibrary.service.FavoriteAlbumServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/favorite-albums")
public class FavoriteAlbumController {

    FavoriteAlbumService favoriteAlbumService;

    public FavoriteAlbumController(FavoriteAlbumService favoriteAlbumService) {
        this.favoriteAlbumService = favoriteAlbumService;
    }

    @GetMapping("/list")
    public List<FavoriteAlbum> getFavoriteAlbums(){
        return favoriteAlbumService.findAll();
    }
}
