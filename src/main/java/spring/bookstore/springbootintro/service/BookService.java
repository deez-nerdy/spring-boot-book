package spring.bookstore.springbootintro.service;

import spring.bookstore.springbootintro.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
