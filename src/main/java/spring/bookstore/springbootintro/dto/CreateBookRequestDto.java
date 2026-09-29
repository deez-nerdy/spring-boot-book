package spring.bookstore.springbootintro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequestDto {

    @NotBlank(message = "is required")
    private String title;

    @NotBlank(message = "is required")
    private String author;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotNull(message = "is required")
    @Positive(message = "must be greater than 0")
    private BigDecimal price;

    private String description;
    private String coverImage;
}
