package online.patologia.libraryrestmongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document
public class Book {
    @Id
    private String id;
    private String author;
    private String name;
    private int releaseDate;

    public Book(String author, String name, int releaseDate) {
        this.author = author;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Book(String id, String author, String name, int releaseDate) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.releaseDate = releaseDate;
    }
}
