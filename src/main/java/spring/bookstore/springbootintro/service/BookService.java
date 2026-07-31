package spring.bookstore.springbootintro.service;

import java.util.List;
import spring.bookstore.springbootintro.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
