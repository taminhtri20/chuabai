package org.example.musicapp.respository;

import org.example.musicapp.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRespository extends JpaRepository<Song, Integer> {
}
