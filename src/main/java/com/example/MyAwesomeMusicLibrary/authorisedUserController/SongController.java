package com.example.MyAwesomeMusicLibrary.authorisedUserController;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.service.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    final Logger log = LoggerFactory.getLogger(MyAwesomeMusicLibraryApplication.class);

    SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/list")
    public List<Song> getSongs(){
        return songService.showAll();

    }

    @PostMapping("/add-song")
    public String addSong(@RequestBody Song song){
        log.info("printing song request -- {}", song.toString());

        return songService.addNewSong(song);
    }

    @PutMapping("/update-song")
    public String updateSong(@RequestBody Song song){
        return songService.updateSong(song);
    }

    @PutMapping("/update-song-title-by-id")
    public String updateSongTitle(@RequestBody Song song){
        return songService.updateSongTitle(song);
    }

    @DeleteMapping("/delete-song/{id}")
    public void deleteSong(@PathVariable Integer id){
        songService.deleteSongbyId(id);
    }

}
