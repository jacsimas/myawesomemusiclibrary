package com.example.MyAwesomeMusicLibrary.libraryAccessControllers;

import com.example.MyAwesomeMusicLibrary.model.FavoriteSong;
import com.example.MyAwesomeMusicLibrary.service.FavoriteSongService;
import com.example.MyAwesomeMusicLibrary.service.FavoriteSongServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/favorite-songs")
public class FavoriteSongController {

    FavoriteSongService favoriteSongService;

    public FavoriteSongController(FavoriteSongService favoriteSongService) {
        this.favoriteSongService = favoriteSongService;
    }

    @GetMapping("/list")
    public List<FavoriteSong> getFavoriteSongs(){
        return favoriteSongService.findAll();

    }

    @PostMapping("/add-to-favorites")
    public String addToFavorites(@RequestBody FavoriteSong favoriteSong) throws SQLException {
        return favoriteSongService.saveFavSong(favoriteSong);
    }


}
