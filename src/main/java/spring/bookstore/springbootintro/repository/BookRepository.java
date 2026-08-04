package spring.bookstore.springbootintro.repository;

import java.util.List;
import spring.bookstore.springbootintro.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
