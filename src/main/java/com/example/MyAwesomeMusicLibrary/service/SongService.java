package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.MyAwesomeMusicLibraryApplication;
import com.example.MyAwesomeMusicLibrary.mapper.SongMapper;
import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.model.User;
import com.example.MyAwesomeMusicLibrary.modelDTO.response.SongResponseDTO;
import com.example.MyAwesomeMusicLibrary.repository.SongRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
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
        if (!result) {
            songRepository.save(song);
            return "Song added successfully";
        } else return "Song already exists. Song wasn't added";
    }

    private boolean checkIfSongExists(String songTitle, Integer artist_id) {

        log.info("printing -- {} , {}", songTitle, artist_id);

        if (songRepository.findByTitleAndArtistId(songTitle, artist_id) != null) {
            return true;
        }
        ;
        return false;
    }

    public List<Song> songsByArtist(int id) {
        return songRepository.findByArtistId(id);
    }

    public String updateSong(Song song) {

        Integer songId = song.getSong_id();
        String songTitle = song.getTitle();

        if (songRepository.findById(songId).isPresent()) {
            songRepository.save(song);
            return songTitle + " song info was updated! ";
        } else return songTitle + " could not be found ";
    }

    public String updateSongTitle(Song song) {

        Integer songId = song.getSong_id();
        String title = song.getTitle();

        log.info("printing parameter values -- {} , {} ", songId, title);

        Optional<Song> songOptional = songRepository.findById(songId);

        log.info("printing returned object value -- {} , ", songOptional.toString());

        if (songOptional.isPresent()) {
            Song SongDataFromDb = songOptional.get();
            SongDataFromDb.setTitle(title);
            songRepository.save(SongDataFromDb);
            return "new title was set!";
        } else return "Song with such title does not exist. ";
    }

    public Song songsByTitle(String title) throws RuntimeException{

        List<Song> foundSongList = songRepository.findByTitleIsNotNull();
        log.info("printing song's: title -- {} , ", title);
        Song checksong = foundSongList.getFirst();
        String checksongtitle = checksong.getTitle();
        log.info("printing  checksongtitle title -- {} , ", checksongtitle);

        Iterator<Song> iterator = foundSongList.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    /*
            for (Song song : foundSongList){
             if (song.getTitle().equals(title)){
                 String checkTitle = song.getTitle();
                 log.info("printing title from repository -- {} , ", checkTitle);
                 return song;
             }
         }
     */
    public Song getSongById(Integer songId) {

        Optional<Song> song = songRepository.findById(songId);
            Song foundSong = song.get();
        if (foundSong == null){
            log.warn("Song with this id wasn't found in the database");
        }
        return foundSong;
    }

    public SongResponseDTO getSongByIdUsesDto(Integer songId) {

        Optional<Song> song = songRepository.findById(songId);
        Song foundSong = song.get();
        if (foundSong == null) {
            log.warn("Song by this id wasn't found in the database");
        }
        Integer albumId = foundSong.getAlbumId();
        Integer artistId = foundSong.getArtistId();
        Integer releaseYear = foundSong.getReleaseYear();
        log.info("Fetched song with id, albumId, artistId, releaseYear: {} , {} , {} . {} ", songId, albumId, artistId, releaseYear);

        return SongMapper.toDto(foundSong);
    }

    public void deleteSongbyId(Integer id) {
        songRepository.deleteById(id);
    }

}
