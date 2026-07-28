package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.model.FavoriteAlbum;
import com.example.MyAwesomeMusicLibrary.repository.FavoriteAlbumRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FavoriteAlbumServiceImpl {

    final Logger log = LoggerFactory.getLogger(MyAwesomeMusicLibraryApplication.class);

    FavoriteAlbumRepository favoriteAlbumRepository;

    public FavoriteAlbumServiceImpl(FavoriteAlbumRepository favoriteAlbumRepository) {
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
