package online.patologia.libraryrestmongodb;

import online.patologia.libraryrestmongodb.models.Book;
import online.patologia.libraryrestmongodb.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class LibraryRestMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryRestMongodbApplication.class, args);
	}

}
