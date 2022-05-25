package fr.cda.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	 public ResourceNotFoundException(final String message) {
	        super(message);
	    }
}
