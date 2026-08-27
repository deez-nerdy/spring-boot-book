package spring.bookstore.springbootintro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.bookstore.springbootintro.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
