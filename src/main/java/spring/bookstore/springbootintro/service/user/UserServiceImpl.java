package spring.bookstore.springbootintro.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bookstore.springbootintro.dto.request.UserRegistrationRequestDto;
import spring.bookstore.springbootintro.dto.response.UserResponseDto;
import spring.bookstore.springbootintro.exception.RegistrationException;
import spring.bookstore.springbootintro.mapper.UserMapper;
import spring.bookstore.springbootintro.model.User;
import spring.bookstore.springbootintro.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {
        if (userRepository.existsByEmail(userRegistrationRequestDto.getEmail())) {
            throw new RegistrationException("Email already exists: "
                    + userRegistrationRequestDto.getEmail());
        }

        User user = userMapper.toUser(userRegistrationRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }
}
