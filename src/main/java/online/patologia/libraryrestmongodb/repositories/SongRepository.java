package online.patologia.libraryrestmongodb.repositories;

import online.patologia.libraryrestmongodb.models.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<Song,String> {
}
