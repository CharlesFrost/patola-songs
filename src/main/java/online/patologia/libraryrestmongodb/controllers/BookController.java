package online.patologia.libraryrestmongodb.controllers;

import online.patologia.libraryrestmongodb.models.Book;
import online.patologia.libraryrestmongodb.repositories.BookRepository;
import online.patologia.libraryrestmongodb.services.BookService;
import online.patologia.libraryrestmongodb.services.ServiceResponse;
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
    public ResponseEntity<Object> getALlBooks() {
        ServiceResponse<List<Book>> serviceResponse = new ServiceResponse<>("success", bookService.findAll());
        return new ResponseEntity<Object>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<Object> saveBook(@RequestBody Book book) {
        ServiceResponse<Book> serviceResponse = new ServiceResponse<>("success", bookService.save(book));
        return new ResponseEntity<Object>(serviceResponse, HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") String id) {
        bookService.deleteById(id);
        ServiceResponse<Boolean> serviceResponse = new ServiceResponse<>("success", true);
        return new ResponseEntity<Object>(serviceResponse,HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Object> getOneBook(@PathVariable("id") String id) {
        ServiceResponse<Book> serviceResponse = new ServiceResponse<>("success", bookService.getOne(id));
        return new ResponseEntity<Object>(serviceResponse, HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<Object> updateBook(@RequestBody Book book) {
        ServiceResponse<Book> serviceResponse = new ServiceResponse<>("success", bookService.update(book));
        return new ResponseEntity<Object>(bookService.update(book),HttpStatus.OK);
    }

    @DeleteMapping("/book")
    public ResponseEntity<Object> deleteAll() {
        bookService.deleteAll();
        ServiceResponse<Boolean> serviceResponse = new ServiceResponse<>("success", true);
        return new ResponseEntity<Object>("success",HttpStatus.OK);
    }
}
