package spring.bookstore.springbootintro.dto;

import java.math.BigDecimal;

public record BookSearchParameters(String title,
                                   String author,
                                   String isbn,
                                   BigDecimal minPrice,
                                   BigDecimal maxPrice) {}
