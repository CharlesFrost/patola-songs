package online.patologia.libraryrestmongodb.services;

import com.google.gson.Gson;
import online.patologia.libraryrestmongodb.models.Song;
import online.patologia.libraryrestmongodb.models.youtube.Video;
import online.patologia.libraryrestmongodb.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> findAll() {
        List<Song> songs = songRepository.findAll();
        songs.sort(Song::compareTo);
        return songs;
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

    public Song save(Song song)  {
        try {
        final String key = "AIzaSyAKNnxRiN_NWzpiLzzuR2UpDqQhsnsybtY";
        final URL url = new URL("https://www.googleapis.com/youtube/v3/search/?key=AIzaSyAKNnxRiN_NWzpiLzzuR2UpDqQhsnsybtY&part=snippet&q="+song.getLink());
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Video video = new Gson().fromJson(reader,Video.class);
        song.setLink(video.getItems().get(0).getId().getVideoId());
        song.setTitle(video.getItems().get(0).getSnippet().getTitle());
        return songRepository.save(song);
        } catch (IOException e) {
            return null;
        }
    }

    public void deleteAll(){
        songRepository.deleteAll();
    }

    public Song trimSong(Song song) {
        song.setLink(song.getLink().trim());
        return song;
    }


}
