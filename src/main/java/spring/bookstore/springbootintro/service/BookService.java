package spring.bookstore.springbootintro.service;

import java.util.List;
import spring.bookstore.springbootintro.dto.BookDto;
import spring.bookstore.springbootintro.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestBookDto);

    BookDto getById(Long id);

    List<BookDto> getAll();

    BookDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto);

    void deleteBookById(Long id);
}
