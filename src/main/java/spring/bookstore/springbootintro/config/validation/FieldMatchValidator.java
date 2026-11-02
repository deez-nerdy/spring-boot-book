package spring.bookstore.springbootintro.config.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;
import spring.bookstore.springbootintro.dto.request.UserRegistrationRequestDto;

public class FieldMatchValidator
        implements ConstraintValidator<FieldMatch, UserRegistrationRequestDto> {
    private String firstField;
    private String secondField;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstField = constraintAnnotation.first();
        this.secondField = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(UserRegistrationRequestDto value, ConstraintValidatorContext context) {
        try {
            Field first = value.getClass().getDeclaredField(firstField);
            Field second = value.getClass().getDeclaredField(secondField);
            first.setAccessible(true);
            second.setAccessible(true);
            return Objects.equals(first.get(value), second.get(value));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
