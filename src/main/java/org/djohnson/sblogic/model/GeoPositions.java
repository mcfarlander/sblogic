package org.djohnson.sblogic.model;

/**
 * GeoPositions represents the points to present on the map.
 * 
 * @author DJohnson
 * @since 1.0
 *
 */
public class GeoPositions {
	
	private String issLong;
	private String issLat;
	private String ipLong;
	private String ipLat;
	
	public String getIssLong() {
		return issLong;
	}
	
	public void setIssLong(String issLong) {
		this.issLong = issLong;
	}
	
	public String getIssLat() {
		return issLat;
	}
	
	public void setIssLat(String issLat) {
		this.issLat = issLat;
	}
	
	public String getIpLong() {
		return ipLong;
	}
	
	public void setIpLong(String ipLong) {
		this.ipLong = ipLong;
	}
	
	public String getIpLat() {
		return ipLat;
	}
	
	public void setIpLat(String ipLat) {
		this.ipLat = ipLat;
	}
	
	/**
	 * Create a new instance of GeoPositions.
	 */
	public GeoPositions() {
		// no-opt
	}
	
	/**
	 * Create a new instance of GeoPositions.
	 * @param issLong
	 * @param issLat
	 * @param ipLong
	 * @param ipLat
	 */
	public GeoPositions(String issLong, String issLat, String ipLong, String ipLat) {
		this.issLong = issLong;
		this.issLat = issLat;
		this.ipLong = ipLong;
		this.ipLat = ipLat;
	}

}
