package spring.bookstore.springbootintro.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.bookstore.springbootintro.dto.request.UserRegistrationRequestDto;
import spring.bookstore.springbootintro.dto.response.UserResponseDto;
import spring.bookstore.springbootintro.exception.RegistrationException;
import spring.bookstore.springbootintro.service.user.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/registration")
    public UserResponseDto registration(
            @RequestBody @Valid UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {
        return userService.register(userRegistrationRequestDto);
    }
}
