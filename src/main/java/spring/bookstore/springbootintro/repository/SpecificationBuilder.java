package spring.bookstore.springbootintro.repository;

import org.springframework.data.jpa.domain.Specification;
import spring.bookstore.springbootintro.dto.BookSearchParameters;

public interface SpecificationBuilder<T> {
    Specification<T> build(BookSearchParameters bookSearchParameters);
}
