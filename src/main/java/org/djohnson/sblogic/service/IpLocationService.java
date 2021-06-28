package org.djohnson.sblogic.service;

import org.djohnson.sblogic.model.IpGeoLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.thymeleaf.util.StringUtils;

import reactor.core.publisher.Mono;

/**
 * IpLocationService obtains your public IP address and determines the location
 * (longitude and latitude) for it.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
@Service
public class IpLocationService {
	
	private static final Logger logger = LoggerFactory.getLogger(IpLocationService.class);
	
	/** Public service URL for determining your public IP address. */
	private static final String URL_PUBLIC_IP = "https://icanhazip.com";
	
	/** Public service URL for determining your location from a public IP address. */
	private static final String URL_IP_LOCATION = "https://freegeoip.app/json/";
	
	private final WebClient webClient;
	
	/**
	 * Create a new instance of IpLocationService.
	 * 
	 * @param webClientBuilder the web client builder
	 */
	public IpLocationService(WebClient.Builder webClientBuilder) {
		
		logger.debug("creating a service client");
		
		this.webClient = webClientBuilder
				.baseUrl(URL_PUBLIC_IP)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	/**
	 * Get the public IP address of this application.
	 * @return the public IP address
	 */
	private String getPublicIpAddress() {
		
		logger.debug("calling the service to get the public IP address");
		
		Mono<String> result = webClient.get()
				.uri(URL_PUBLIC_IP)
				.retrieve()
				.bodyToMono(String.class);
		
		return result.block();
		
	}
	
	/**
	 * Get the current location of the application.
	 * 
	 * @return the result of the public api for the public IP address
	 */
	public IpGeoLocation getIpPosition() {
		
		logger.debug("calling the IP location api");
		
		String ipAddress = getPublicIpAddress();
		String url = URL_IP_LOCATION + StringUtils.trim(ipAddress);
		
		logger.debug("location api url:" + url);
		
		Mono<IpGeoLocation> result = webClient.get()
				.uri(url)
				.retrieve()
				.bodyToMono(IpGeoLocation.class);
		
		return result.block();
	}

}
