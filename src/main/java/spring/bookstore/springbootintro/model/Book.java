package spring.bookstore.springbootintro.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nullable
    private String title;
    @Nullable
    private String author;
    @Nullable
    @Column(unique = true)
    private String isbn;
    @Nullable
    private BigDecimal price;
    private String description;
    private String coverImage;
}
