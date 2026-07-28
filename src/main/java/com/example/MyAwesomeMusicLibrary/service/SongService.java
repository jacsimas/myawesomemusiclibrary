package com.example.MyAwesomeMusicLibrary.service;

import com.example.MyAwesomeMusicLibrary.model.Song;
import com.example.MyAwesomeMusicLibrary.modelDTO.response.SongResponseDTO;

import java.util.List;

public interface SongService {

    List<Song> showAll();

    String addNewSong(Song song);

    boolean checkIfSongExists(String songTitle, Integer artist_id);

    List<Song> songsByArtist(int id);

    String updateSong(Song song);

    String updateSongTitle(Song song);

    Song songsByTitle(String title);

    Song getSongById(Integer songId);

    SongResponseDTO getSongByIdUsesDto(Integer songId);

    void deleteSongbyId(Integer id);

}
