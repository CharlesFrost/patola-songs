package online.patologia.libraryrestmongodb.controllers;

import online.patologia.libraryrestmongodb.models.Song;
import online.patologia.libraryrestmongodb.services.SongService;
import online.patologia.libraryrestmongodb.services.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class SongController {
    @Autowired
    private SongService songService;



    @GetMapping("/song")
    public ResponseEntity<Object> getALlSongs() {
        ServiceResponse<List<Song>> serviceResponse = new ServiceResponse<>("success", songService.findAll());
        return new ResponseEntity<Object>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/song")
    public ResponseEntity<Object> saveSong(@RequestBody @Valid Song song) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        song.setAuthor(((UserDetails)principal).getUsername());
        song.setDate(LocalDateTime.now());
        ServiceResponse<Song> serviceResponse = new ServiceResponse<>("success", songService.save(songService.trimSong(song)));
        return new ResponseEntity<Object>(serviceResponse, HttpStatus.OK);
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<Object> deleteSong(@PathVariable("id") String id) {
        songService.deleteById(id);
        ServiceResponse<Boolean> serviceResponse = new ServiceResponse<>("success", true);
        return new ResponseEntity<Object>(serviceResponse,HttpStatus.OK);
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<Object> getOneSong(@PathVariable("id") String id) {
        ServiceResponse<Song> serviceResponse = new ServiceResponse<>("success", songService.getOne(id));
        return new ResponseEntity<Object>(serviceResponse, HttpStatus.OK);
    }

    @PutMapping("/song")
    public ResponseEntity<Object> updateSong(@RequestBody @Valid Song song) {
        ServiceResponse<Song> serviceResponse = new ServiceResponse<>("success", songService.update(songService.trimSong(song)));
        return new ResponseEntity<Object>(songService.update(song),HttpStatus.OK);
    }

    @DeleteMapping("/song")
    public ResponseEntity<Object> deleteAll() {
        songService.deleteAll();
        ServiceResponse<Boolean> serviceResponse = new ServiceResponse<>("success", true);
        return new ResponseEntity<Object>("success",HttpStatus.OK);
    }
}
