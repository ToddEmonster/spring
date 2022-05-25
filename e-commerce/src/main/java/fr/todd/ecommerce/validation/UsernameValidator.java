package fr.todd.ecommerce.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Classe de contrainte de validation du username.
 * Un username doit
 * - contenir au moins 4 caractères alphanumériques
 * - commencer par une majuscule
 */
public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return Pattern.matches("^([A-Z])([A-Za-z0-9]){3,}$", username);
    }
}
