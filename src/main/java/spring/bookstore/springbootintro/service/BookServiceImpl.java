package spring.bookstore.springbootintro.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.bookstore.springbootintro.dto.BookDto;
import spring.bookstore.springbootintro.dto.BookSearchParameters;
import spring.bookstore.springbootintro.dto.CreateBookRequestDto;
import spring.bookstore.springbootintro.exception.EntityNotFoundException;
import spring.bookstore.springbootintro.mapper.BookMapper;
import spring.bookstore.springbootintro.model.Book;
import spring.bookstore.springbootintro.repository.book.BookRepository;
import spring.bookstore.springbootintro.repository.book.spec.BookSpecificationBuilder;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BookDto save(CreateBookRequestDto requestBookDto) {
        Book book = bookMapper.toModel(requestBookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookDto(savedBook);
    }

    @Transactional(readOnly = true)
    @Override
    public BookDto getById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Can't find book with id: " + id));
        return bookMapper.toBookDto(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<BookDto> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toBookDto);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BookDto updateBookById(Long id, CreateBookRequestDto requestBookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book with id: " + id));
        bookMapper.updateBookFromCreateBookRequestDto(requestBookDto, book);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookDto(savedBook);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDto> searchBooks(BookSearchParameters bookSearchParameters) {
        Specification<Book> specification = bookSpecificationBuilder.build(bookSearchParameters);
        return bookRepository.findAll(specification)
                .stream()
                .map(bookMapper::toBookDto)
                .toList();
    }
}
