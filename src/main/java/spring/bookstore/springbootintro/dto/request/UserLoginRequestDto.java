package spring.bookstore.springbootintro.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserLoginRequestDto {

    @NotBlank(message = "is required")
    @Length(min = 8, max = 20)
    @Email
    private String email;

    @NotBlank(message = "is required")
    @Length(min = 8, max = 20)
    private String password;
}
