package spring.bookstore.springbootintro.service.book;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.bookstore.springbootintro.dto.BookSearchParameters;
import spring.bookstore.springbootintro.dto.request.CreateBookRequestDto;
import spring.bookstore.springbootintro.dto.response.BookDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestBookDto);

    BookDto getById(Long id);

    Page<BookDto> getAll(Pageable pageable);

    List<BookDto> searchBooks(BookSearchParameters bookSearchParameters);

    BookDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto);

    void deleteBookById(Long id);
}
