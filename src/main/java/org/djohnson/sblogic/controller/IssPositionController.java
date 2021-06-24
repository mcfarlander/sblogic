package org.djohnson.sblogic.controller;

import org.djohnson.sblogic.service.IssPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The ISS position controller is a controller for getting the position of ISS.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/api")
public class IssPositionController {
	
	private static final Logger logger = LoggerFactory.getLogger(IssPositionController.class);
	
	@Autowired
	IssPositionService issPositionService;
	
	/**
	 * Get the position of ISS as part of the API.
	 * 
	 * @return the position of ISS
	 */
	@RequestMapping(value= "/iss", method = RequestMethod.GET)
	public String getIssPosition() {
		
		logger.debug("getting the position of ISS");
		return issPositionService.getIssPosition();
		
	}
	
}
