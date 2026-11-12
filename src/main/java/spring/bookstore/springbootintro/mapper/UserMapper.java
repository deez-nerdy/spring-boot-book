package spring.bookstore.springbootintro.mapper;

import org.mapstruct.Mapper;
import spring.bookstore.springbootintro.dto.request.UserRegistrationRequestDto;
import spring.bookstore.springbootintro.dto.response.UserResponseDto;
import spring.bookstore.springbootintro.model.Role;
import spring.bookstore.springbootintro.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRegistrationRequestDto userRegistrationRequestDto);

    UserResponseDto toUserResponse(User user);

    default String mapRoleToString(Role role) {
        return role.getRoleName().name();
    }
}
