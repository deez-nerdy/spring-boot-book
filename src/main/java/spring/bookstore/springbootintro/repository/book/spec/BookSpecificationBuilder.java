package spring.bookstore.springbootintro.repository.book.spec;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import spring.bookstore.springbootintro.dto.BookSearchParameters;
import spring.bookstore.springbootintro.model.Book;
import spring.bookstore.springbootintro.repository.SpecificationBuilder;
import spring.bookstore.springbootintro.repository.SpecificationProviderManager;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private static final String TITLE_KEY = "title";
    private static final String AUTHOR_KEY = "author";
    private static final String ISBN_KEY = "isbn";
    private static final String PRICE_KEY = "price";
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters bookSearchParameters) {
        Specification<Book> specification = Specification.unrestricted();

        if (bookSearchParameters.title() != null && bookSearchParameters.title().length() > 0) {
            specification = specification
                    .and(bookSpecificationProviderManager.getSpecificationProvider(TITLE_KEY)
                    .getSpecification(new String[]{bookSearchParameters.title()}));
        }

        if (bookSearchParameters.author() != null && bookSearchParameters.author().length() > 0) {
            specification = specification
                    .and(bookSpecificationProviderManager.getSpecificationProvider(AUTHOR_KEY)
                    .getSpecification(new String[]{bookSearchParameters.author()}));
        }

        if (bookSearchParameters.isbn() != null && bookSearchParameters.isbn().length() > 0) {
            specification = specification
                    .and(bookSpecificationProviderManager.getSpecificationProvider(ISBN_KEY)
                    .getSpecification(new String[]{bookSearchParameters.isbn()}));
        }

        if (bookSearchParameters.minPrice() != null || bookSearchParameters.maxPrice() != null) {
            specification = specification
                    .and(bookSpecificationProviderManager.getSpecificationProvider(PRICE_KEY)
                    .getSpecification(new String[]{priceToString(bookSearchParameters.minPrice()),
                            priceToString(bookSearchParameters.maxPrice())}));
        }
        return specification;
    }

    private String priceToString(BigDecimal price) {
        return price != null ? price.toString() : null;
    }
}
