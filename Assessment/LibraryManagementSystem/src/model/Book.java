package model;

public class Book {

    private Long id;
    private String title;
    private String author;
    private boolean available = true;

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Long getId() { return id; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return "Book [id=" + id + ", title=" + title +
                ", author=" + author +
                ", available=" + available + "]";
    }
}