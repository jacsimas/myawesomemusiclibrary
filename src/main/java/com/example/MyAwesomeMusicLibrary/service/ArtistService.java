package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.model.Artist;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.repository.ArtistRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ArtistService {

    ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> showAll() {

        return artistRepository.findAll();

    }

    public String addNewArtist(Artist artist) {

        String name = artist.getName();

        boolean result = checkIfArtistExists(name);
        if (!result){
            artistRepository.save(artist);
            return "New Artist was added successfully";
        }
        else return "The artist already exists in the library. Artist wasn't added";
    }

    private boolean checkIfArtistExists(String name) {

        if(artistRepository.findByName(name) != null)
        {
            return true;
        };
        return false;
    }
}
