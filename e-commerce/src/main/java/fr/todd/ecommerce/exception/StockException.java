package fr.todd.ecommerce.exception;

public class StockException extends Exception {
    public String getMessage() {
        return "Stock invalide.";
    }

    @Override
    public String toString() {
        return "Stock invalide.";
    }
}
