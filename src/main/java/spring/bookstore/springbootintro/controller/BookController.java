package spring.bookstore.springbootintro.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.bookstore.springbootintro.dto.BookDto;
import spring.bookstore.springbootintro.dto.CreateBookRequestDto;
import spring.bookstore.springbootintro.service.BookService;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

    @PostMapping("/api/books")
    public BookDto createBook(@RequestBody CreateBookRequestDto createBookRequestDto) {
        return bookService.save(createBookRequestDto);
    }

    @RequestMapping("/api/books/{id}")
    @ResponseBody
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @RequestMapping("/api/books")
    @ResponseBody
    public List<BookDto> getAll() {
        return bookService.getAll();
    }
}
