package com.catering.classes;

import java.sql.Date;

/**
 * @author Omkar Nibandhe<br>
 *         May 5, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class Schedule {

	private int EventID, EmployeeID, StartTime, EndTime;
	private String day;
	private java.sql.Date date;

	/**
	 * Default Constructor
	 */
	public Schedule() {

	}

	/**
	 * Parametric constructor
	 * 
	 * @param eventID
	 *            int value as a ID for an event
	 * @param employeeID
	 *            int value as Uniquee reference to employees
	 * @param startTime
	 *            24hr format start time of this employee's shift
	 * @param endTime
	 *            24hr formart end time of this employee's shift
	 * @param day
	 *            day of the week in lower case
	 * @param date
	 *            date in java.sql.Date format.
	 */
	public Schedule(int eventID, int employeeID, int startTime, int endTime, String day, Date date) {
		super();
		EventID = eventID;
		EmployeeID = employeeID;
		StartTime = startTime;
		EndTime = endTime;
		this.day = day;
		this.date = date;
	}

	/**
	 * Get the date for this work schedule
	 * 
	 * @return java.sql.Date format date
	 */
	public java.sql.Date getDate() {
		return date;
	}

	/**
	 * Set the Date of this employee's schedule.
	 * 
	 * @param date
	 *            java.sql.Date object
	 */
	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	/**
	 * Fetch the eventID for which this employee has been scheduled.
	 * 
	 * @return int value of the eventID
	 */
	public int getEventID() {
		return EventID;
	}

	/**
	 * Set the eventID for which this employee has been scheduled.
	 * 
	 * @param eventID
	 *            int value of the eventID
	 */
	public void setEventID(int eventID) {
		EventID = eventID;
	}

	/**
	 * Get the employeeID for this event.
	 * 
	 * @return int value for this employee.
	 */
	public int getEmployeeID() {
		return EmployeeID;
	}

	/**
	 * Set the employeeID for this event.
	 * 
	 * @param employeeID
	 *            int value for this employee
	 */
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	/**
	 * Get the starttime 24 hr format for this schedule
	 * 
	 * @return 24 hr int value
	 */
	public int getStartTime() {
		return StartTime;
	}

	/**
	 * Set the starttime 24 hr format for this schedule
	 * 
	 * @param startTime
	 *            24 hr int value
	 */
	public void setStartTime(int startTime) {
		StartTime = startTime;
	}

	/**
	 * Get the endtime 24 hr format for this schedule
	 * 
	 * @return 24 hr int value
	 */
	public int getEndTime() {
		return EndTime;
	}

	/**
	 * Set the endtime 24 hr format for this schedule
	 * 
	 * @param endTime
	 *            24 hr int value
	 */
	public void setEndTime(int endTime) {
		EndTime = endTime;
	}

	/**
	 * Get the day of week this employee has been scheduled for.
	 * 
	 * @return String representation of the day of the week in lower case
	 */
	public String getDay() {
		return day;
	}

	/**
	 * Set the day of week this employee has been scheduled for.
	 * 
	 * @param day
	 *            String representation of the day of the week in lower case
	 */
	public void setDay(String day) {
		this.day = day;
	}

}
