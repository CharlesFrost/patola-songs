package online.patologia.libraryrestmongodb.services;

import online.patologia.libraryrestmongodb.models.Song;
import online.patologia.libraryrestmongodb.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Song getOne(String id) {
        return songRepository.findById(id).get();
    }

    public void deleteById(String id) {
        songRepository.deleteById(id);
    }

    public Song update(Song song) {
        return songRepository.save(song);
    }

    public Song save(Song song) {
        return songRepository.save(song);
    }

    public void deleteAll(){
        songRepository.deleteAll();
    }

    public Song trimSong(Song song) {
//        song.setAuthor(song.getAuthor().trim());
        return song;
    }
}
