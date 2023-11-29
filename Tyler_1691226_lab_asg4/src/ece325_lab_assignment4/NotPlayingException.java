package ece325_lab_assignment4;

public class NotPlayingException extends Exception{
	
	/**
	 * NotPlayingException is an exception that is thrown when an artist attempts to
	 * feed an animal when the artist is not playing any music. There are 2
	 * constructors for this class, a constructor that takes input of type String
	 * and a constructor that takes no parameters and sets a default string for this
	 * exception.
	 */
	private static final long serialVersionUID = 999999L;
	// Eclipse auto added the above line but I changed the value.

	public NotPlayingException() {
		super("You are not playing any music");
	}
	
	public NotPlayingException(String message) {
		super(message);
	}
	
}