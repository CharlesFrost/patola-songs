package online.patologia.libraryrestmongodb.services;

import online.patologia.libraryrestmongodb.models.Book;
import online.patologia.libraryrestmongodb.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book getOne(String id) {
        return bookRepository.findById(id).get();
    }

    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteAll(){
        bookRepository.deleteAll();
    }

    public Book trimBook(Book book) {
        book.setAuthor(book.getAuthor().trim());
        book.setName(book.getName().trim());
        book.setReleaseYear(book.getReleaseYear().trim());
        return book;
    }
}
