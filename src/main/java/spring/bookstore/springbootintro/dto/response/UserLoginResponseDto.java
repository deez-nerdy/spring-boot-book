package spring.bookstore.springbootintro.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDto {
    private String token;

    public UserLoginResponseDto(String token) {
        this.token = token;
    }
}
