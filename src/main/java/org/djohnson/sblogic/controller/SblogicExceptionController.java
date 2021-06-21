package org.djohnson.sblogic.controller;

import org.djohnson.sblogic.exception.SblogicException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The centralized error handler for the controllers.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@ControllerAdvice
public class SblogicExceptionController {
	
	@ExceptionHandler(value = SblogicException.class)
	public ResponseEntity<Object> exception(SblogicException exception) {
	      return new ResponseEntity<>("Sblogic Error " + exception.getMessage(), HttpStatus.OK);
	}

}
