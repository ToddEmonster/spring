package fr.todd.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException {
    public String getMessage() {
        return "Ressource non trouvée ¯\\_(ツ)_/¯";
    }

    @Override
    public String toString() {
        return "Ressource non trouvée ¯\\_(ツ)_/¯";
    }
}
