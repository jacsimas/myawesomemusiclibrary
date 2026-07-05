package com.example.MyAwesomeMusicLibrary.UnauthorisedUserController;

import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class SongLibraryController {


    SongService songService;

    public SongLibraryController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    public List<Song> getSongs(){
        return songService.showAll();

    }

    @GetMapping("/filter-songs-by-artist")
    public List<Song> filterByArtist(@RequestParam Integer id){
        return songService.songsByArtist(id);
    }

    @GetMapping("/filter-songs-by-title")
    public String filterByTitle(@RequestBody String title) throws Throwable {
        return songService.songsByTitle(title);
    }
}
