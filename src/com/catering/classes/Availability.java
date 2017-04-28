/**
 * 
 */
package com.catering.classes;

/**
 * @author Omkar Nibandhe
 *  Apr 25, 2017 
 *  https://www.linkedin.com/in/omkarnibandhe
 */
public class Availability {

	private int EmployeeID, StartTime, EndTime;
	private String Day;

	public Availability() {
	}

	public Availability(int employeeID, int startTime, int endTime, String day) {
		super();
		EmployeeID = employeeID;
		StartTime = startTime;
		EndTime = endTime;
		Day = day;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public int getStartTime() {
		return StartTime;
	}

	public void setStartTime(int startTime) {
		StartTime = startTime;
	}

	public int getEndTime() {
		return EndTime;
	}

	public void setEndTime(int endTime) {
		EndTime = endTime;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

}
