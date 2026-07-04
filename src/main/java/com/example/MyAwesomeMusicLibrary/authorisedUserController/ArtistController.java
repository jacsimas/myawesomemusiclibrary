package com.example.MyAwesomeMusicLibrary.authorisedUserController;

import com.example.MyAwesomeMusicLibrary.model.Artist;
import com.example.MyAwesomeMusicLibrary.service.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/list")
    public List<Artist> getArtists(){
        return artistService.showAll();
    }

    @PostMapping("/add-artist")
    public String addArtist(@RequestBody Artist artist){
        return artistService.addNewArtist(artist);
    }

}
