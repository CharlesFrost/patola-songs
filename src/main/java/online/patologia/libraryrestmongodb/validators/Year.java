package online.patologia.libraryrestmongodb.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = YearValidator.class)
@Documented
public @interface Year {
    String message() default "Proszę podać poprawny rok";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}