package com.example.MyAwesomeMusicLibrary.controller;

import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

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
        return songService.addNewSong(song);
    }

}
