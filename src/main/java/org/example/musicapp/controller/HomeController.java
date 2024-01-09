package org.example.musicapp.controller;

import org.example.musicapp.model.Song;
import org.example.musicapp.service.HibernateSongService;
import org.example.musicapp.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/musicapp")
public class HomeController {
    @Autowired
    ISongService songService = new HibernateSongService();

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listSong", songService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("song", songService.findById(id).get());
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("song", songService.findById(id).get());
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("song", songService.findById(id).get());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song",new Song());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam("filePath")MultipartFile filePath, Song song) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/musicapp");
        String fileName = filePath.getOriginalFilename();
        FileCopyUtils.copy(filePath.getBytes(), new File(fileUpload + fileName));
        songService.save(new Song(song.getNameSong(), song.getNameSinger(), song.getKindOfMusic(), fileName));
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "filePath", required = false)MultipartFile filePath , Song song) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/musicapp");
        String fileName = filePath.getOriginalFilename();
        if (!fileName.isEmpty()){
            FileCopyUtils.copy(song.getDirectorySong().getBytes(), new File(fileUpload + fileName));
            songService.edit(song.getId(), new Song(song.getNameSong(), song.getNameSinger(), song.getKindOfMusic(), fileName));
        }else {
            songService.edit(song.getId(), new Song(song.getNameSong(), song.getNameSinger(), song.getKindOfMusic(), song.getDirectorySong()));
        }
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(Song song){
        ModelAndView modelAndView = new ModelAndView("redirect:/musicapp");
        songService.delete(song.getId());
        return modelAndView;
    }
}
