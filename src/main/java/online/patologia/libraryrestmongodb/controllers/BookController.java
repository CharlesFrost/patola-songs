package online.patologia.libraryrestmongodb.controllers;

import online.patologia.libraryrestmongodb.models.Book;
import online.patologia.libraryrestmongodb.repositories.BookRepository;
import online.patologia.libraryrestmongodb.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;



    @GetMapping("/book")
    public ResponseEntity<List<Book>> getALlBooks() {
        bookService.findAll();
        return new ResponseEntity<List<Book>>(bookService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.save(book), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") String id) {
        bookService.deleteById(id);
        return new ResponseEntity<String>("success",HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getOneBook(@PathVariable("id") String id) {
        return new ResponseEntity<Book>(bookService.getOne(id), HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.update(book),HttpStatus.OK);
    }

    @DeleteMapping("/book")
    public ResponseEntity<?> deleteAll() {
        bookService.deleteAll();
        return new ResponseEntity<String>("success",HttpStatus.OK);
    }
}
