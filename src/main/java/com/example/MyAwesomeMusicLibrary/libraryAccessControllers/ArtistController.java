package com.example.MyAwesomeMusicLibrary.libraryAccessControllers;

import com.example.MyAwesomeMusicLibrary.model.Artist;
import com.example.MyAwesomeMusicLibrary.service.ArtistService;
import com.example.MyAwesomeMusicLibrary.service.ArtistServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {

    ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/api/artist-list")
    public List<Artist> getArtists(){
        return artistService.showAll();
    }

    @PostMapping("/api/add-artist")
    public String addArtist(@RequestBody Artist artist){
        return artistService.addNewArtist(artist);
    }


    @GetMapping("/library/artists")
    public List<Artist> getLibraryArtists(){
        return artistService.showAll();
    }

}
