package online.patologia.libraryrestmongodb.repositories;

import online.patologia.libraryrestmongodb.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {
}
