package com.example.MyAwesomeMusicLibrary;

import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.service.SongService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongServiceTests {

    SongService service;

    public SongServiceTests(SongService service) {
        this.service = service;
    }

    @Test
    void testGetSongById() {

        String title = "let it rock";
        Integer songId = 1;

        Song result = service.getSongById(songId);
        assertEquals(title, result.getTitle());
    }

}
