package spring.bookstore.springbootintro.repository.book.spec;

import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import spring.bookstore.springbootintro.model.Book;
import spring.bookstore.springbootintro.repository.SpecificationProvider;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "title";
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, cb)
                -> root.get("title").in(Arrays.stream(params).toArray());
    }
}
