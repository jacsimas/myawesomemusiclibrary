package com.example.MyAwesomeMusicLibrary.repository;

import com.example.MyAwesomeMusicLibrary.model.Song;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SongRepository extends JpaRepository<Song, Integer> {


    Song findByTitleAndArtistId(String title, Integer artistId);

    List<Song> findByArtistId(Integer artistId);

    List<Song> findByTitleIsNotNull();

    List<Song> findBySongIdAndTitle(Integer songId, String oldTitle);
}

