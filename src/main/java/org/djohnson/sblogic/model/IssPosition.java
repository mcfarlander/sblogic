package org.djohnson.sblogic.model;

/**
 * IssPosition represents the latitude and longitude of the ISS.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class IssPosition {
	
	private String latitude;
	private String longitude;
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
