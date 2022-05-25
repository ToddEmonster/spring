package fr.todd.ecommerce.exception;

public class EmailAlreadyExistsException extends Exception {
    public String getMessage() {
        return "Email existant";
    }

    @Override
    public String toString() {
        return "Email existant";
    }
}
