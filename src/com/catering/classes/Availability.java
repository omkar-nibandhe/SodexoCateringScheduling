/**
 * 
 */
package com.catering.classes;

/**
 * @author Omkar Nibandhe <br>
 *         Apr 25, 2017 <br>
 * 		https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class Availability {

	private int EmployeeID, StartTime, EndTime;
	private String Day;

	/**
	 * Availability class default constructor. Structure to hold the
	 * Availability data access object.
	 */
	public Availability() {
	}

	/**
	 * Parametric constructor.
	 * 
	 * @param employeeID
	 *            unique id for this employee.
	 * @param startTime
	 *            int value in 24 hr format.
	 * @param endTime
	 *            int value in 24 hr format.
	 * @param day
	 *            string denoting day of week in lower case.
	 */
	public Availability(int employeeID, int startTime, int endTime, String day) {
		super();
		EmployeeID = employeeID;
		StartTime = startTime;
		EndTime = endTime;
		Day = day;
	}

	/**
	 * 
	 * @return EmployeeID of this object
	 */
	public int getEmployeeID() {
		return EmployeeID;
	}

	/**
	 * Set employeeID of this object
	 * 
	 * @param employeeID
	 *            Unique ID for the employee
	 */
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	/**
	 * Returns the time of day when available for work.
	 * 
	 * @return starting time of the shift for this student on specified day.
	 */
	public int getStartTime() {
		return StartTime;
	}

	/**
	 * Set the time of day when available for work.
	 * 
	 * @param startTime
	 *            set starting time of this shift for this student on specified
	 *            day. <br>
	 *            int value specified in 24hr format.
	 */
	public void setStartTime(int startTime) {
		StartTime = startTime;
	}

	/**
	 * Returns the time of day for work when shift ends.
	 * 
	 * @return end time of this shift for this student on specific day. <br>
	 *         int value specified in 24hr format.
	 */
	public int getEndTime() {
		return EndTime;
	}

	/**
	 * Sets the time of day for work when shift ends.
	 * 
	 * @param endTime
	 *            int value specified in 24hr format.
	 */
	public void setEndTime(int endTime) {
		EndTime = endTime;
	}

	/**
	 * Get the day of the week eg: friday, monday, etc.
	 * 
	 * @return day this work shift holds for. <br>
	 *         String in lower case.
	 */
	public String getDay() {
		return Day;
	}

	/**
	 * Set the day of the week eg: friday, monday, etc.
	 * 
	 * @param day
	 *            Set this day for the shift it holds for. <br>
	 *            String in lower case.
	 */
	public void setDay(String day) {
		Day = day;
	}

}
