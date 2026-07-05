package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.model.FavoriteAlbum;
import com.example.MyAwesomeMusicLibrary.model.FavoriteSong;
import com.example.MyAwesomeMusicLibrary.repository.FavoriteAlbumRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class FavoriteAlbumService {

    final Logger log = LoggerFactory.getLogger(MyAwesomeMusicLibraryApplication.class);

    FavoriteAlbumRepository favoriteAlbumRepository;

    public FavoriteAlbumService(FavoriteAlbumRepository favoriteAlbumRepository) {
        this.favoriteAlbumRepository = favoriteAlbumRepository;
    }

    public List<FavoriteAlbum> findAll(){
        return favoriteAlbumRepository.findAll();
    }

    public String saveFavAlbum(FavoriteAlbum favoriteAlbum){

        Integer userId = favoriteAlbum.getUserId();
        Integer albumId = favoriteAlbum.getAlbumId();

        if(favoriteAlbumRepository.findByUserIdAndAlbumId(userId, albumId) != null){
            favoriteAlbumRepository.save(favoriteAlbum);
            return  "This album was saved to favorites! ";
        }
        else return "This album is already in your Album favorites list ";
    }
}
