package com.example.MyAwesomeMusicLibrary.unauthorisedUserController;

import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.modelDTO.response.SongResponseDTO;
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

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Integer id) {
        return songService.getSongById(id);
    }

    @GetMapping("/filter-songs-by-title")
    public Song filterByTitle(@RequestBody String title) throws Throwable {
        return songService.songsByTitle(title);
    }

    @GetMapping("/by-id/{id}")
    public SongResponseDTO getSongByIdUsesDto(@PathVariable Integer id) {
        return songService.getSongByIdUsesDto(id);
    }


}
