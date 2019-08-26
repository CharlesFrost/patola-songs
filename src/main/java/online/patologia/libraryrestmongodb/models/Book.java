package online.patologia.libraryrestmongodb.models;

import lombok.*;
import online.patologia.libraryrestmongodb.validators.Year;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document
public class Book {
    @Id
    private String id;
    //@NotNull(message = "Proszę podać autora!")
    @NotBlank(message = "Proszę podać autora!")
    //@NotEmpty(message = "Proszę podać autora!")
    private String author;
    //@NotNull(message = "Proszę podać nazwę!")
    @NotBlank(message = "Proszę podać nazwę!")
   // @NotEmpty(message = "Proszę podać nazwę!")
    private String name;
    @Year
    private String releaseYear;

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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
