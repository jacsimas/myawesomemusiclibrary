package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.model.FavoriteSong;
import com.example.MyAwesomeMusicLibrary.repository.FavoriteSongRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class FavoriteSongService {

    FavoriteSongRepository favoriteSongRepository;

    public FavoriteSongService(FavoriteSongRepository favoriteSongRepository) {
        this.favoriteSongRepository = favoriteSongRepository;
    }

    public String saveFavSong(FavoriteSong favoriteSong){

        Integer userId = favoriteSong.getUserId();
        Integer songId = favoriteSong.getSongId();

        if(favoriteSongRepository.findByUserIdAndSongId(userId, songId) != null){
            favoriteSongRepository.save(favoriteSong);
            return  "This song was saved to favorites! ";
        }
        else return "The Song is already in your favorites list ";
    }

    public List<FavoriteSong> findAll() {
        return favoriteSongRepository.findAll();
    }

}
