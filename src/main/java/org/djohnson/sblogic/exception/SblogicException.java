package org.djohnson.sblogic.exception;

/**
 * Custom exception for the sblogic web service.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class SblogicException  extends RuntimeException {


	private static final long serialVersionUID = 3013443354904922830L;
	
	/**
	 * Create a new instance of SblogicException.
	 * 
	 * @param message	the message for the exception
	 * @param ex		the exception
	 */
	public SblogicException(String message, Throwable ex) {
		super(message, ex);
		
	}
	
	

}
