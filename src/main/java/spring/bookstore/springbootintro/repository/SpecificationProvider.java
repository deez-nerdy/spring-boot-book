package spring.bookstore.springbootintro.repository;

import org.springframework.data.jpa.domain.Specification;
import spring.bookstore.springbootintro.model.Book;

public interface SpecificationProvider<T> {
    String getKey();

    Specification<Book> getSpecification(String[] params);
}
