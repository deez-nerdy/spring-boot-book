package spring.bookstore.springbootintro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import spring.bookstore.springbootintro.dto.BookDto;
import spring.bookstore.springbootintro.dto.CreateBookRequestDto;
import spring.bookstore.springbootintro.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toBookDto(Book book);

    Book toModel(CreateBookRequestDto requestBookDto);

    void updateBookFromCreateBookRequestDto(CreateBookRequestDto requestBookDto,
                                            @MappingTarget Book book);
}
