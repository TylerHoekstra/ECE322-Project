package ece325_lab_assignment4;

public class AlreadyFedException extends Exception {

	/**
	 * AlreadyFedException is an exception that is thrown when an artist attempts to
	 * feed an animal who has already been fed that calendar day. There are 2
	 * constructors for this class, a constructor that takes input of type String
	 * and a constructor that takes no parameters and sets a default string for this
	 * exception.
	 */
	private static final long serialVersionUID = 1L;
	// Eclipse auto added the above line

	public AlreadyFedException() {
		super("This animal has already been fed");
	}

	public AlreadyFedException(String message) {
		super(message);
	}

}