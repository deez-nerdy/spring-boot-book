package spring.bookstore.springbootintro.service.user;

import spring.bookstore.springbootintro.dto.request.UserRegistrationRequestDto;
import spring.bookstore.springbootintro.dto.response.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto);
}
