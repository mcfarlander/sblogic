package org.djohnson.sblogic.model;

import java.util.Date;

/**
 * IssNow represents the response from the querying the location of ISS.
 * 
 * @author DJohnson
 * @since 1/0
 *
 */
public class IssNow {
	
	public static final String SUCCESS = "sucess";
	
	private String message;
	private long timestamp;
	private IssPosition iss_position;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public IssPosition getIss_position() {
		return iss_position;
	}
	
	public void setIss_position(IssPosition iss_position) {
		this.iss_position = iss_position;
	}
	
	@Override 
	public String toString() {
		
		Date date = new Date();
		date.setTime(timestamp * 1000);
		
		
		return "message: " + message + ", time: " + date + ", " + iss_position.toString();
	}
	
}
