package org.djohnson.sblogic.controller;

import org.djohnson.sblogic.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The JwtController is a controller for handling user JWT.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/api")
public class JwtController {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtController.class);
	
	@Autowired
	JwtService jwtService;
	
	private static final String DEFAULT_USER = "user";
	
	private static final String DEFAULT_ROLE = "role";
	
	/**
	 * Generate a JWT from a fixed user.
	 * @return 
	 * 
	 * @return the generated jwt
	 */
	@RequestMapping(value= "/jwt", method = RequestMethod.GET)
	public @ResponseBody String generateJwt() {
		
		logger.debug("generating jwt");
		return jwtService.generateJwtToken(DEFAULT_USER, DEFAULT_ROLE);
		
	}
	
	/**
	 * Verify a JWT from a fixed user. The URL will end /api/jwt/verify?jwt=xxxxxxx.
	 *
	 * 
	 * @param token the JWT token to verify
	 * 
	 * @return true if the token is valid, false otherwise
	 */
	@RequestMapping(value= "/jwt/verify", method = RequestMethod.GET)
	public boolean verfiyJwt(@RequestParam("token") String token) {
		
		logger.debug("verifying jwt");
		return jwtService.verifyJwtToken(token);
		
	}

}
