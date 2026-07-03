package com.example.MyAwesomeMusicLibrary.repository;

import com.example.MyAwesomeMusicLibrary.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SongRepository extends JpaRepository<Song, UUID> {
}
