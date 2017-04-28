package com.catering.classes;

import java.sql.Date;

public class Schedule {

	private int EventID, EmployeeID, StartTime, EndTime;
	private String day;
	private java.sql.Date date;

	public Schedule() {

	}

	public Schedule(int eventID, int employeeID, int startTime, int endTime, String day, Date date) {
		super();
		EventID = eventID;
		EmployeeID = employeeID;
		StartTime = startTime;
		EndTime = endTime;
		this.day = day;
		this.date = date;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public int getEventID() {
		return EventID;
	}

	public void setEventID(int eventID) {
		EventID = eventID;
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
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
