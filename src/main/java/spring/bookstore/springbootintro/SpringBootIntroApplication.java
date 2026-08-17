package spring.bookstore.springbootintro;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.bookstore.springbootintro.dto.CreateBookRequestDto;
import spring.bookstore.springbootintro.service.BookService;

@SpringBootApplication
public class SpringBootIntroApplication {
    private static final String BOOK_TITLE = "Title example";
    private static final String BOOK_AUTHOR = "Author example";
    private static final String BOOK_ISBN = "1-2-3-4-5-6-1-2-3-4-5-6-7 example";
    private static final BigDecimal BOOK_PRICE = new BigDecimal("100");
    private static final String BOOK_DESCRIPTION = "Description example";

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            CreateBookRequestDto bookDto = new CreateBookRequestDto();
            bookDto.setTitle(BOOK_TITLE);
            bookDto.setAuthor(BOOK_AUTHOR);
            bookDto.setIsbn(BOOK_ISBN);
            bookDto.setPrice(BOOK_PRICE);
            bookDto.setDescription(BOOK_DESCRIPTION);

            bookService.save(bookDto);

            System.out.println(bookService.getAll());
        };
    }
}
