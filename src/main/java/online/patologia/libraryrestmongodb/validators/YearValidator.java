package online.patologia.libraryrestmongodb.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearValidator implements ConstraintValidator<Year, String> {
    @Override
    public boolean isValid(String year, ConstraintValidatorContext constraintValidatorContext) {
        return year.trim().matches("^[1-9][0-9]*$");
    }

    @Override
    public void initialize(Year constraintAnnotation) {

    }
}
