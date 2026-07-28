package com.example.MyAwesomeMusicLibrary.libraryAccessControllers;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.modelDTO.response.SongResponseDTO;
import com.example.MyAwesomeMusicLibrary.service.SongService;
import com.example.MyAwesomeMusicLibrary.service.SongServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    final Logger log = LoggerFactory.getLogger(MyAwesomeMusicLibraryApplication.class);

    SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/api/songs/list")
    public List<Song> getSongs(){
        return songService.showAll();

    }

    @PostMapping("/api/songs/add-song")
    public String addSong(@RequestBody Song song){
        log.info("printing song request -- {}", song.toString());

        return songService.addNewSong(song);
    }

    @PutMapping("/api/songs/update-song")
    public String updateSong(@RequestBody Song song){
        return songService.updateSong(song);
    }

    @PutMapping("/api/songs/update-song-title-by-id")
    public String updateSongTitle(@RequestBody Song song){
        return songService.updateSongTitle(song);
    }

    @DeleteMapping("/api/songs/delete-song/{id}")
    public void deleteSong(@PathVariable Integer id){
        songService.deleteSongbyId(id);
    }

    @GetMapping("/library/songs")
    public List<Song> getLibrarySongs(){
        return songService.showAll();
    }

    @GetMapping("/library/filter-songs-by-artist")
    public List<Song> filterByArtist(@RequestParam Integer id){
        return songService.songsByArtist(id);
    }

    @GetMapping("/library/{id}")
    public Song getSongById(@PathVariable Integer id) {
        return songService.getSongById(id);
    }

    @GetMapping("/library/filter-songs-by-title")
    public Song filterByTitle(@RequestBody String title) throws Throwable {
        return songService.songsByTitle(title);
    }

    @GetMapping("/library/by-id/{id}")
    public SongResponseDTO getSongByIdUsesDto(@PathVariable Integer id) {
        return songService.getSongByIdUsesDto(id);
    }

}
