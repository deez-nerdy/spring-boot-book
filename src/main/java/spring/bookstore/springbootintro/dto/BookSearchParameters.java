package spring.bookstore.springbootintro.dto;

import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import spring.bookstore.springbootintro.config.validation.ValidPriceRange;

@ValidPriceRange
public record BookSearchParameters(String title,
                                   String author,
                                   String isbn,
                                   @PositiveOrZero(message = "prise must be >= 0")
                                   BigDecimal minPrice,
                                   @PositiveOrZero(message = "prise must be >= 0")
                                   BigDecimal maxPrice) {}
