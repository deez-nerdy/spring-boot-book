package spring.bookstore.springbootintro.service.user;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.bookstore.springbootintro.dto.request.UserRegistrationRequestDto;
import spring.bookstore.springbootintro.dto.response.UserResponseDto;
import spring.bookstore.springbootintro.exception.RegistrationException;
import spring.bookstore.springbootintro.mapper.UserMapper;
import spring.bookstore.springbootintro.model.Role;
import spring.bookstore.springbootintro.model.RoleName;
import spring.bookstore.springbootintro.model.User;
import spring.bookstore.springbootintro.repository.role.RoleRepository;
import spring.bookstore.springbootintro.repository.user.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto)
            throws RegistrationException {
        if (userRepository.existsByEmail(userRegistrationRequestDto.getEmail())) {
            throw new RegistrationException("Email already exists: "
                    + userRegistrationRequestDto.getEmail());
        }

        User user = userMapper.toUser(userRegistrationRequestDto);
        user.setPassword(
                passwordEncoder.encode(userRegistrationRequestDto.getPassword())
        );

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.getRoleByRoleName(RoleName.USER);
        roles.add(userRole);
        user.setRoles(roles);

        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }
}
