package spring.bookstore.springbootintro.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bookstore.springbootintro.dto.BookDto;
import spring.bookstore.springbootintro.dto.CreateBookRequestDto;
import spring.bookstore.springbootintro.exception.EntityNotFoundException;
import spring.bookstore.springbootintro.mapper.BookMapper;
import spring.bookstore.springbootintro.model.Book;
import spring.bookstore.springbootintro.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestBookDto) {
        Book book = bookMapper.toModel(requestBookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookDto(savedBook);
    }

    @Override
    public BookDto getById(Long id) {
        Book book = bookRepository.getById(id).orElseThrow(()
                -> new EntityNotFoundException("Can't find book with id: " + id));
        return bookMapper.toBookDto(book);
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.getAll().stream()
                .map(bookMapper::toBookDto)
                .toList();
    }
}
