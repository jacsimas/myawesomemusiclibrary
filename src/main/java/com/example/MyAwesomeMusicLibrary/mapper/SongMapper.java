package com.example.MyAwesomeMusicLibrary.mapper;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.modelDTO.response.SongResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

@Service
public class SongMapper {

    static final Logger log = LoggerFactory.getLogger(MyAwesomeMusicLibraryApplication.class);

    public static SongResponseDTO toDto(Song song) {

        Integer albumId = song.getAlbumId();
        Integer artistId = song.getArtistId();
        Integer releaseYear = song.getReleaseYear();

        log.info("Fetched song with albumId, artistId, releaseYear: {} , {} , {}  ", albumId, artistId, releaseYear);

        SongResponseDTO songResponseDTO = new SongResponseDTO();
        songResponseDTO.setSongId(song.getSong_id());
        songResponseDTO.setTitle(song.getTitle());
        songResponseDTO.setReleaseYear(song.getReleaseYear());
        songResponseDTO.setArtistId(song.getArtistId());
        songResponseDTO.setDuration(song.getDuration());
        songResponseDTO.setAlbumId(song.getAlbumId());

        return songResponseDTO;
    }

}
