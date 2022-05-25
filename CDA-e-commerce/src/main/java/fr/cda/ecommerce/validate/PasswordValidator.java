package fr.cda.ecommerce.validate;

import fr.cda.ecommerce.dto.UserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidePassword, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		UserDto userDto = (UserDto) value;

		return checkString(userDto.getPassword()) && userDto.getPassword().equals(userDto.getMatchingPassword());
	}

	/**
	 * Le mot de passe doit contenir au moins 6 caractères dont au moins une lettre
	 * minuscule et une lettre majuscule, un caractère spécial parmi (% * $ - + =)
	 * et un chiffre.
	 * 
	 * @param password
	 * @return
	 */
	private boolean checkString(String password) {
		char ch;
		boolean capitalFlag = false;
		boolean lowerCaseFlag = false;
		boolean numberFlag = false;
		boolean specialCharFlag = false;

		for (int i = 0; i < password.length(); i++) {
			ch = password.charAt(i);
			if (Character.isDigit(ch)) {
				numberFlag = true;
			} else if (Character.isUpperCase(ch)) {
				capitalFlag = true;
			} else if (Character.isLowerCase(ch)) {
				lowerCaseFlag = true;
			} else if (ch == '%' || ch == '*' || ch == '$' || ch == '-' || ch == '+' || ch == '=') {
				specialCharFlag = true;
			}
		}

		if (password.length()>= 6 && numberFlag && capitalFlag && lowerCaseFlag && specialCharFlag)
			return true;

		return false;
	}

}
