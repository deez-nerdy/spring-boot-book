package spring.bookstore.springbootintro.repository;

import java.util.List;
import java.util.Optional;
import spring.bookstore.springbootintro.model.Book;

public interface BookRepository {
    Book save(Book book);

    Optional<Book> getById(Long id);

    List<Book> getAll();
}
