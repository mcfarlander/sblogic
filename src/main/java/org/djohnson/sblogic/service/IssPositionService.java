package org.djohnson.sblogic.service;

import org.djohnson.sblogic.model.IssNow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/**
 * IssPositionService is a service to get back the position of ISS.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@Service
public class IssPositionService {
	
	private static final Logger logger = LoggerFactory.getLogger(IssPositionService.class);
	
	/** The URL for getting the position. Put this in a property file. */
	private static final String URL_ISS_POSITION = "http://api.open-notify.org/iss-now.json";
	
	private final WebClient webClient;
	
	/**
	 * Create a new instance of IssPositionService.
	 * 
	 * @param webClientBuilder the web client builder
	 */
	public IssPositionService(WebClient.Builder webClientBuilder) {
		
		logger.debug("creating a ISS position service client");
		logger.debug("base ping url {}", URL_ISS_POSITION );
		
		this.webClient = webClientBuilder
				.baseUrl(URL_ISS_POSITION )
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	/**
	 * Get the current position of ISS.
	 * 
	 * @return the result of the public api for ISS's position.
	 */
	public IssNow getIssPosition() {
		
		logger.debug("calling the ISS position api");
		
		Mono<IssNow> result = webClient.get()
				.uri(URL_ISS_POSITION)
				.retrieve()
				.bodyToMono(IssNow.class);
		
		return result.block();
	}
	
	

}
