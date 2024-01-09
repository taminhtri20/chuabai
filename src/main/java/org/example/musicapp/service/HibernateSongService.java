package org.example.musicapp.service;

import org.example.musicapp.model.Song;
import org.example.musicapp.respository.SongRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class HibernateSongService implements ISongService{
    @Autowired
    SongRespository songRespository;

    @Override
    public List<Song> findAll() {
        return songRespository.findAll();
    }

    @Override
    public Optional<Song> findById(int id) {
        return songRespository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRespository.save(song);
    }

    @Override
    public void delete(int id) {
        songRespository.deleteById(id);
    }

    @Override
    public void edit(int id, Song song) {
        songRespository.save(new Song(id, song.getNameSong(), song.getNameSinger(), song.getKindOfMusic(), song.getDirectorySong()));
    }
}
