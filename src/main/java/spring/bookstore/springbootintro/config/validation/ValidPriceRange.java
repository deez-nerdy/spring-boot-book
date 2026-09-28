package spring.bookstore.springbootintro.config.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PriceRangeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPriceRange {
    String message() default "minPrice must be less or equal to maxPrice";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
