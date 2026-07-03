package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.repository.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongService {


    final Logger log = LoggerFactory.getLogger(MyAwesomeMusicLibraryApplication.class);

    SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> showAll() {

        return songRepository.findAll();

    }

    public String addNewSong(Song song) {

      String songTitle = song.getTitle();
      Integer artist_id = song.getArtistId();

        boolean result = checkIfSongExists(songTitle, artist_id);
        if (!result){
            songRepository.save(song);
            return "Song added successfully";
        }
        else return "Song already exists. Song wasn't added";
    }

    private boolean checkIfSongExists(String songTitle, Integer artist_id) {

        log.info("printing -- {} , {}", songTitle, artist_id);

        if(songRepository.findByTitleAndArtistId(songTitle, artist_id) != null)
        {
            return true;
        };
        return false;
    }

}
