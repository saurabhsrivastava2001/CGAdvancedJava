package service;

import java.util.List;

import org.springframework.stereotype.Service;
import model.Book;
import repository.BookRepository;

@Service
public class BookService {

    private BookRepository repo;
    long initialId=1;
    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public void addBook(String title, String author) {
        Book book =
                new Book(initialId++,
                        title, author);
        repo.save(book);
        System.out.println("Book Added Successfully");
    }

    public List<Book> getAvailableBooks() {
        return repo.findAll();
    }
}