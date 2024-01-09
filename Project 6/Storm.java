
/**
 * Date: 4/19/2022
 * This class describes a Storm which holds the date of the storm(represented by a String variable), the name of the 
 * storm(represented by a String variable), the windspeed of the storm(represented by a double variable), and the precipitation 
 * of the storm(represented by a double variable). The class has methods that allow the user to manipulate the instance variables 
 * (such as getters and setters). This class implements Serializable.
 * @author Furkan Agamak
 * SBU ID: 114528166
 * CSE 214 - R03 Recitation
 */

import java.io.*;

public class Storm implements Serializable {
	
	/**
	 * A String variable representing the date of the storm(must be formatted as Internet-Style YYYY-MM-DD). This is initialized to null.
	 */
	private String date = null;
	/**
	 * A String variable representing the name of the storm.
	 */
	private String name;
	/**
	 * A double variable representing the windspeed of the storm.
	 */
	private double windspeed;
	/**
	 * A double variable representing the precipitation of the storm.
	 */
	private double precipitation;
	
	/**
	 * This is a constructor which constructs a Storm object with the specified date of the storm.
	 * @param date
	 * 		A String variable representing the date of the storm(must be formatted as Internet-Style YYYY-MM-DD).
	 */
	public Storm(String date) {
		this.date = date;
	}
	
	/**
	 * This is a constructor which constructs a Storm object with the specified date of the storm and the name of the storm.
	 * @param date
	 * 		A String variable representing the date of the storm(must be formatted as Internet-Style YYYY-MM-DD).
	 * @param name
	 * 		A String variable representing the name of the storm.
	 */
	public Storm(String date, String name) {
		this.date = date;
		this.name = name;
	}
	
	/**
	 * This is a constructor which constructs a Storm object with the specified date of the storm, the name of the storm, and 
	 * the windspeed of the storm.
	 * @param date
	 * 		A String variable representing the date of the storm(must be formatted as Internet-Style YYYY-MM-DD).
	 * @param name
	 * 		A String variable representing the name of the storm.
	 * @param windspeed
	 * 		A double variable representing the windspeed of the storm.
	 */
	public Storm(String date, String name, double windspeed) {
		this.date = date;
		this.name = name;
		this.windspeed = windspeed;
	}
	
	/**
	 * This is a constructor which constructs a Storm object with the specified date of the storm, the name of the storm,
	 * the windspeed of the storm, and the precipitation of the storm.
	 * @param date
	 * 		A String variable representing the date of the storm(must be formatted as Internet-Style YYYY-MM-DD).
	 * @param name
	 * 		A String variable representing the name of the storm.
	 * @param windspeed
	 * 		A double variable representing the windspeed of the storm.
	 * @param precipitation
	 * 		A double variable representing the precipitation of the storm.
	 */
	public Storm(String date, String name, double windspeed, double precipitation) {
		this.date = date;
		this.name = name;
		this.windspeed = windspeed;
		this.precipitation = precipitation;
	}
	
	/**
	 * This is a method that gets the date of the storm.
	 * @return
	 * 		A String variable representing the date of the storm.
	 */
	public String getDate() {
		return this.date;
	}
	
	/**
	 * This is a method that sets the date of the storm.
	 * @param date
	 * 		A String variable representing the date of the storm(must be formatted as Internet-Style YYYY-MM-DD).
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * This is a method that gets the name of the storm.
	 * @return
	 * 		A String variable representing the name of the storm.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This is a method that sets the name of the storm.
	 * @param name
	 * 		A String variable representing the name of the storm.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This is a method that gets the precipitation of the storm.
	 * @return
	 * 		A double variable representing the precipitation of the storm.
	 */
	public double getPrecip() {
		return this.precipitation;
	}
	
	/**
	 * This is a method that sets the precipitation of the storm.
	 * @param precipitation
	 * 		A double variable representing the precipitation of the storm.
	 */
	public void setPrecip(double precipitation) {
		this.precipitation = precipitation;
	}
	
	/**
	 * This is a method that gets the windspeed of the storm.
	 * @return
	 * 		A double variable representing the windspeed of the storm.
	 */
	public double getWspeed() {
		return this.windspeed;
	}
	
	/**
	 * This is a method that sets the windspeed of the storm.
	 * @param windspeed
	 * 		A double variable representing the windspeed of the storm.
	 */
	public void setWspeed(double windspeed) {
		this.windspeed = windspeed;
	}
	
	/**
	 * This is a String representation of the Storm class. It displays the Storm with its name, date,
	 * windspeed, and precipitation.
	 * @return
	 * 		A String variable representing the Storm class.
	 */
	public String toString() {
		String str = this.getName().toUpperCase() + ": Date " + this.getDate() + ", " + this.getWspeed() + 
				" km/h windspeed, " + this.getPrecip() + " cm of rain";
		return str;
	}
}
