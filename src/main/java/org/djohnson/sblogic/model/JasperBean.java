package org.djohnson.sblogic.model;

/**
 * JasperBean represents a simple object to use in a jasper report.
 * 
 * @author DJohnson
 * @since 1.0.0
 *
 */
public class JasperBean {

	String name;
	String color;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}