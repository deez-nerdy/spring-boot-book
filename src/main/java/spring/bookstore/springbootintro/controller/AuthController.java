package spring.bookstore.springbootintro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spring.bookstore.springbootintro.dto.request.UserLoginRequestDto;
import spring.bookstore.springbootintro.dto.request.UserRegistrationRequestDto;
import spring.bookstore.springbootintro.dto.response.UserLoginResponseDto;
import spring.bookstore.springbootintro.dto.response.UserResponseDto;
import spring.bookstore.springbootintro.exception.RegistrationException;
import spring.bookstore.springbootintro.security.AuthenticationService;
import spring.bookstore.springbootintro.service.user.UserService;

@Tag(name = "User registration, authentication",
        description = "Endpoints for user registration, authentication")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "User registration", description = "Register new user")
    public UserResponseDto registration(
            @RequestBody @Valid UserRegistrationRequestDto userRegistrationRequestDto
    ) throws RegistrationException {
        return userService.register(userRegistrationRequestDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "User login", description = "Authenticate user")
    public UserLoginResponseDto login(
            @RequestBody @Valid UserLoginRequestDto userLoginRequestDto
    ) {
        return authenticationService.authenticate(userLoginRequestDto);
    }
}
