/**
 * 
 */
package com.catering.classes;

/**
 * @author Omkar Nibandhe <br>
 *         Apr 25, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 */
public class Event {

	private int SrNo, EventID, GuestCount, StartTime, EndTime;
	private String EventName, EventLocation, day;
	private Boolean isDisposable;
	private java.sql.Date Date;

	/**
	 * Default constructor
	 */

	public Event() {

	}

	/**
	 * Parametric constructor
	 * 
	 * @param srNo
	 *            Unique ID (int value) for this event.
	 * @param eventID
	 *            Specific number for this event. May be duplicate.
	 * @param guestCount
	 *            Count of the guest in this event.
	 * @param startTime
	 *            Start time of this event. 24 hr format.
	 * @param endTime
	 *            End time of this event. 24 hr format.
	 * @param eventName
	 *            Name of this event (if any)
	 * @param eventLocation
	 *            Location/Venue of this event.
	 * @param day
	 *            Day of the week for this event.
	 * @param isDisposable
	 *            Service type of this event: Disposable or China.
	 * @param date
	 *            Date on which this event is supposed to happen.
	 */
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

	/**
	 * Get day of week when this event is scheduled.
	 * 
	 * @return Day of week in lower case.
	 */
	public String getDay() {
		return day;
	}

	/**
	 * Set day of week when this event is to be scheduled.
	 * 
	 * @param day
	 *            Day of week in lower case.
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * Get day of week when this event is scheduled.
	 * 
	 * @return Day of week in lower case
	 */
	public java.sql.Date getDate() {
		return Date;
	}

	/**
	 * Set date when this event is scheduled.
	 * 
	 * @param date
	 *            Java.sql.Date format
	 */
	public void setDate(java.sql.Date date) {
		Date = date;
	}

	/**
	 * Get Unique ID of the Event
	 * 
	 * @return Return unique int value for Events.
	 */
	public int getSrNo() {
		return SrNo;
	}

	/**
	 * Set Sr.No. Never to be called. This value is auto generated.
	 * 
	 * @param srNo
	 *            New Sr.No for this event
	 */
	public void setSrNo(int srNo) {
		SrNo = srNo;
	}

	/**
	 * Get EventID of this event.
	 * 
	 * @return int value non-unique EventID.
	 */
	public int getEventID() {
		return EventID;
	}

	/**
	 * Set EventID for this event.
	 * 
	 * @param eventID
	 *            int value as event ID for this event.
	 */
	public void setEventID(int eventID) {
		EventID = eventID;
	}

	/**
	 * Get the number of people for this event.
	 * 
	 * @return guest count.
	 */
	public int getGuestCount() {
		return GuestCount;
	}

	/**
	 * Set the number of people for this event.
	 * 
	 * @param guestCount
	 *            int value for the guest count in this event.
	 */
	public void setGuestCount(int guestCount) {
		GuestCount = guestCount;
	}

	/**
	 * Get the start time for this event.
	 * 
	 * @return 24hr time format.
	 */
	public int getStartTime() {
		return StartTime;
	}

	/**
	 * Set the start time for this event.
	 * 
	 * @param startTime
	 *            24 hr time format.
	 */
	public void setStartTime(int startTime) {
		StartTime = startTime;
	}

	/**
	 * Get the end time for this event.
	 * 
	 * @return 24 hr time format.
	 */
	public int getEndTime() {
		return EndTime;
	}

	/**
	 * Set the end time for this event.
	 * 
	 * @param endTime
	 *            int value as end time. 24 hr format.
	 */
	public void setEndTime(int endTime) {
		EndTime = endTime;
	}

	/**
	 * Get the event name of this event.
	 * 
	 * @return Event name as String
	 */
	public String getEventName() {
		return EventName;
	}

	/**
	 * Set the event name of this event.
	 * 
	 * @param eventName
	 *            Update the event name with new String.
	 */
	public void setEventName(String eventName) {
		EventName = eventName;
	}

	/**
	 * Get the event location of this event.
	 * 
	 * @return location/Venue of this event.
	 */
	public String getEventLocation() {
		return EventLocation;
	}

	/**
	 * Set the event location of this event.
	 * 
	 * @param eventLocation
	 *            New Event Location as a String.
	 */
	public void setEventLocation(String eventLocation) {
		EventLocation = eventLocation;
	}

	/**
	 * Get the service type of this event as Disposable or China.
	 * 
	 * @return true if disposable.
	 */
	public Boolean getIsDisposable() {
		return isDisposable;
	}

	/**
	 * Set the service type of this event.
	 * 
	 * @param isDisposable true if type of service is disposable
	 */
	public void setIsDisposable(Boolean isDisposable) {
		this.isDisposable = isDisposable;
	}

	/**
	 * Internal method for converting int value to day of week. Sunday - 0
	 * 
	 * @param day2
	 *            int representation for the day of week/
	 */
	public void setDay(int day2) {
		switch (day2) {
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
