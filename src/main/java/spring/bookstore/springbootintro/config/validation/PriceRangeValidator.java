package spring.bookstore.springbootintro.config.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import spring.bookstore.springbootintro.dto.BookSearchParameters;

public class PriceRangeValidator
        implements ConstraintValidator<ValidPriceRange, BookSearchParameters> {

    @Override
    public boolean isValid(BookSearchParameters params, ConstraintValidatorContext context) {
        if (params.minPrice() == null || params.maxPrice() == null) {
            return true;
        }
        return params.minPrice().compareTo(params.maxPrice()) <= 0;
    }
}
