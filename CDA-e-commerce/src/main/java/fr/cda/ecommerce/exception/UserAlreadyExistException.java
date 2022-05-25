package fr.cda.ecommerce.exception;

public class UserAlreadyExistException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1374723829244388687L;

	public UserAlreadyExistException(String message) {
		super(message);
	}
}
