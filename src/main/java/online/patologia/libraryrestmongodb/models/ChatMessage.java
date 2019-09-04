package online.patologia.libraryrestmongodb.models;

public class ChatMessage {
    private String value;
    private String author;

    public ChatMessage() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ChatMessage(String value, String author) {
        this.value = value;
        this.author = author;
    }
}
