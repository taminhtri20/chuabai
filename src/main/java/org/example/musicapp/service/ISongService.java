package org.example.musicapp.service;

import org.example.musicapp.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    Optional<Song> findById(int id);
    void save(Song song);
    void delete(int id);
    void edit(int id, Song song);
}
