package spring.bookstore.springbootintro.repository.book.spec;

import jakarta.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import spring.bookstore.springbootintro.model.Book;
import spring.bookstore.springbootintro.repository.SpecificationProvider;

@Component
public class PriceSpecificationProvider implements SpecificationProvider<Book> {
    private static final String PRICE_KEY = "price";

    @Override
    public String getKey() {
        return PRICE_KEY;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (params == null || params.length == 0) {
                return criteriaBuilder.conjunction();
            }

            List<Predicate> predicates = new ArrayList<>();

            if (params.length > 0 && params[0] != null && !params[0].isEmpty()) {
                BigDecimal minPrice = new BigDecimal(params[0]);
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(PRICE_KEY), minPrice));
            }

            if (params.length > 1 && params[1] != null && !params[1].isEmpty()) {
                BigDecimal maxPrice = new BigDecimal(params[1]);
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(PRICE_KEY), maxPrice));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
