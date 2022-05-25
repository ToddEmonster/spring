package fr.cda.ecommerce.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<ValideUsername, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return value.length() >= 4 && Character.isUpperCase(value.charAt(0));
	}

}
