package spring.bookstore.springbootintro.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.bookstore.springbootintro.dto.BookDto;
import spring.bookstore.springbootintro.dto.BookSearchParameters;
import spring.bookstore.springbootintro.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestBookDto);

    BookDto getById(Long id);

    Page<BookDto> getAll(Pageable pageable);

    List<BookDto> searchBooks(BookSearchParameters bookSearchParameters);

    BookDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto);

    void deleteBookById(Long id);
}
