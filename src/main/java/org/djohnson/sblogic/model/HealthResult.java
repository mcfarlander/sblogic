package org.djohnson.sblogic.model;

import java.util.Date;

/**
 * HealthResult is a model of the application's health.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class HealthResult {
	
	/** Health status is good.        */
	public static final String HEALTH_OK = "OK";
	/** Health status is poor.        */
	public static final String HEALTH_BAD = "BAD";
	
	private String serviceHealth;
	private String serviceDate;
	
	public String getServiceHealth() {
		return serviceHealth;
	}
	
	public String getServiceDate() {
		return serviceDate;
	}
	
	public void setServiceHealth(String serviceHealth) {
		this.serviceHealth = serviceHealth;
	}
	
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	
	/**
	 * Create a new instance of HealthResult.
	 */
	public HealthResult() {
		
		this.serviceHealth = HEALTH_OK;
		this.serviceDate = new Date().toString();
		
	}
	
	/**
	 * Create a new instance of HealthResult.
	 * @param serviceHealth the health status of the application
	 */
	public HealthResult(String serviceHealth) {
		
		this.serviceHealth = serviceHealth;
		this.serviceDate = new Date().toString();
		
	}

}
