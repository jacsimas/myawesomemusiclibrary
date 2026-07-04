package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.model.Album;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.repository.AlbumRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AlbumService {

    final Logger log = LoggerFactory.getLogger(MyAwesomeMusicLibraryApplication.class);

    AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> showAll() {
        return albumRepository.findAll();

    }

    public String addNewAlbum(Album album) {

        String title = album.getTitle();
        Integer artistId = album.getArtistId();

        log.info("printing -- {} , {}", title, artistId);

        boolean result = checkIfAlbumExists(title, artistId);
        if (!result){
            albumRepository.save(album);
            return "Album added successfully";
        }
        else return "Album already exists in the library. Album wasn't added";
    }

    private boolean checkIfAlbumExists(String title, Integer artistId) {

        if(albumRepository.findByTitleAndArtistId(title, artistId) != null)
        {
            return true;
        };
        return false;

    }

}
