package org.djohnson.sblogic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The health controller is a controller for determining the health of
 * the application.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/api")
public class HealthController {
	
	private static final Logger logger = LoggerFactory.getLogger(HealthController.class);
	
	

}
