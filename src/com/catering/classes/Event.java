/**
 * 
 */
package com.catering.classes;

/**
 * @author Omkar Nibandhe Apr 25, 2017 https://www.linkedin.com/in/omkarnibandhe
 */
public class Event {

	private int SrNo, EventID, GuestCount, StartTime, EndTime;
	private String EventName, EventLocation, day;
	private Boolean isDisposable;
	private java.sql.Date Date;
	public Event() {

	}

	

	public Event(int srNo, int eventID, int guestCount, int startTime, int endTime, String eventName,
			String eventLocation, String day, Boolean isDisposable, java.sql.Date date) {
		super();
		SrNo = srNo;
		EventID = eventID;
		GuestCount = guestCount;
		StartTime = startTime;
		EndTime = endTime;
		EventName = eventName;
		EventLocation = eventLocation;
		this.day = day;
		this.isDisposable = isDisposable;
		Date = date;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public java.sql.Date getDate() {
		return Date;
	}

	public void setDate(java.sql.Date date) {
		Date = date;
	}


	public int getSrNo() {
		return SrNo;
	}

	public void setSrNo(int srNo) {
		SrNo = srNo;
	}

	public int getEventID() {
		return EventID;
	}

	public void setEventID(int eventID) {
		EventID = eventID;
	}

	public int getGuestCount() {
		return GuestCount;
	}

	public void setGuestCount(int guestCount) {
		GuestCount = guestCount;
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

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getEventLocation() {
		return EventLocation;
	}

	public void setEventLocation(String eventLocation) {
		EventLocation = eventLocation;
	}

	public Boolean getIsDisposable() {
		return isDisposable;
	}

	public void setIsDisposable(Boolean isDisposable) {
		this.isDisposable = isDisposable;
	}

	public void setDay(int day2) {
		switch(day2){
		case 0:
			setDay("sunday");
			break;
		case 1:
			setDay("monday");
			break;
		case 2:
			setDay("tuesday");
			break;
		case 3:
			setDay("wednesday");
			break;
		case 4:
			setDay("thursday");
			break;
		case 5:
			setDay("friday");
			break;
		case 6:
			setDay("saturday");
			break;
		default:
			System.out.println("should not be here ! Event.java switch case");
		}
		
	}

}
