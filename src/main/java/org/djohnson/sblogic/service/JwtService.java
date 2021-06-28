package org.djohnson.sblogic.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class JwtService {
	
	/** Default timeout of the token is 5 minutes. Set by property. */
	private static final long DEFAULT_EXPIRE_IN_FIVE_MINS = 60 * 5 * 1000;

	/** Default secret to encrypt with. Set by property. */
	private static final String secret = "Vulcan4@sblogical";

	/** Algorithm to use when encrypting. */
	private Algorithm algorithm = Algorithm.HMAC256(secret);
	
	/** The issuer of the token. Set by property. */
	private static final String JWT_ISSUER = "SBLOGIC";

	/**
	 * Generate a JWT given the inputs.
	 * 
	 * @param username	the user name 
	 * @param role		the uer's role
	 * @return 			JWT string token
	 */
	public String generateJwtToken(String username, String role) {
		long now = new Date().getTime();
		long expireTime = now + (DEFAULT_EXPIRE_IN_FIVE_MINS);
		Date expireDate = new Date(expireTime);

		String jwtToken = JWT.create()
				.withIssuer(JWT_ISSUER)
				.withClaim("username", username)
				.withClaim("role", role)
				.withExpiresAt(expireDate)
				.sign(algorithm);

		return jwtToken;
	}

	/**
	 * Verify the JWT by the issuer and expiration time.
	 * 
	 * @param token	the JWT to verify
	 * @return true if OK, false otherwise
	 */
	public boolean verifyJwtToken(String token) {
		
		try {
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer(JWT_ISSUER)
					.acceptExpiresAt(DEFAULT_EXPIRE_IN_FIVE_MINS)
					.build();

			verifier.verify(token);
			return true;
		} catch (JWTVerificationException ex) {
			return false;
		}
	}

	/**
	 * Get a claim from the JWT. 
	 * @param token		the JWT
	 * @param claimKey	the claim to look up
	 * @return	the string value of the claim
	 */
	public String getClaimFromToken(String token, String claimKey) {
		DecodedJWT decodedJWT = JWT.decode(token);
		return decodedJWT.getClaims().get(claimKey).toString();
	}

}
