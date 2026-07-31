package spring.bookstore.springbootintro.repository;

import spring.bookstore.springbootintro.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
