package org.djohnson.sblogic.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The hello controller is the main controller for basic testing.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@RestController
@CrossOrigin
@RequestMapping("hello")
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	/**
	 * The helloWord method for the web application. A GET request that returns the date.
	 * 
	 * @return message with the current date
	 */
	@GetMapping(value="")
	public String index() {
		
		logger.debug("accessing bootme ping GET");
		return "sblogic hello world message " + new Date();
		
	}

}
