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
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document
public class Song implements Comparable<Song> {
    @Id
    private String id;
    private String author;
    @NotBlank(message = "Proszę podać link do piosenki!")
    @NotEmpty(message = "Proszę podać link do piosenki!")
    @NotNull(message = "Proszę podać link do piosenki!")
    @Size(min = 8, message = "Link jest zbyt krótki!")
    private String link;
    //@Year
    private LocalDateTime date;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public int compareTo(Song o) {
        return o.getDate().compareTo(getDate());
    }
}
