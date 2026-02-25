package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import model.Book;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }
}