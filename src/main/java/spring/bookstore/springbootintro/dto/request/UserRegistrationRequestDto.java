package spring.bookstore.springbootintro.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import spring.bookstore.springbootintro.config.validation.FieldMatch;

@FieldMatch(first = "password", second = "repeatPassword",
        message = "password are not equals")
@Getter
@Setter
public class UserRegistrationRequestDto {

    @NotBlank(message = "is required")
    @Length(min = 8, max = 20)
    @Email
    private String email;

    @NotBlank(message = "is required")
    @Length(min = 8, max = 20)
    private String password;

    @NotBlank(message = "is required")
    @Length(min = 8, max = 20)
    private String repeatPassword;

    @NotEmpty
    @Length(max = 20)
    private String firstName;

    @NotEmpty
    @Length(max = 20)
    private String lastName;

    private String shippingAddress;
}
