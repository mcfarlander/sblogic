package org.djohnson.sblogic.service;

import org.djohnson.sblogic.model.HealthResult;
import org.springframework.stereotype.Service;

/**
 * A service class determining the health of the application.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@Service
public class HealthService {
	
	/**
	 * Get an updated health status of the application.
	 * @return {@link HealthResult} the health status
	 */
	public HealthResult getHealthResult() {
		
		// at some point, connect to a database or other service(s) and
		// determine if everything is ok. otherwise, return an ok status.
		return new HealthResult();
		
	}

}
