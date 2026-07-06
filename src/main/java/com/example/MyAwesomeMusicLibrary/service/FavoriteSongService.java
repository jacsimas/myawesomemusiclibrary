package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.model.FavoriteSong;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.repository.FavoriteSongRepository;
import com.example.MyAwesomeMusicLibrary.repository.SongRepository;
import com.example.MyAwesomeMusicLibrary.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class FavoriteSongService {

    final Logger log = LoggerFactory.getLogger(MyAwesomeMusicLibraryApplication.class);

    FavoriteSongRepository favoriteSongRepository;
    SongRepository songRepository;
    UserRepository userRepository;

    public FavoriteSongService(FavoriteSongRepository favoriteSongRepository, SongRepository songRepository, UserRepository userRepository) {
        this.favoriteSongRepository = favoriteSongRepository;
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    public String saveFavSong(FavoriteSong favoriteSong) throws SQLException {

        Integer userId = favoriteSong.getUserId();
        Integer songId = favoriteSong.getSongId();

        Optional<Song> songExistsOptional = songRepository.findById(songId);
        Song songExists = songExistsOptional.get();

        if (songExists == null){
            log.warn("Song by this id wasn't found in the database");
        }

        if(favoriteSongRepository.findByUserIdAndSongId(userId, songId) == null){
            favoriteSongRepository.save(favoriteSong);
            return  "This song was saved to favorites! ";
        }
        else return "The Song is already in your favorites list ";
    }

    public List<FavoriteSong> findAll() {
        return favoriteSongRepository.findAll();
    }

}
