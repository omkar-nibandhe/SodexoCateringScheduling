/**
 * 
 */
package com.catering.classes;

import java.sql.Date;

/**
 * @author Omkar Nibandhe
 * Apr 26, 2017 	
 * https://www.linkedin.com/in/omkarnibandhe
 */
public class Week {
	
	private java.sql.Date StartDate, EndDate;
	public Week(){
		
	}
	
	public Week(Date startDate, Date endDate) {
		super();
		StartDate = startDate;
		EndDate = endDate;
	}

	public java.sql.Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(java.sql.Date startDate) {
		StartDate = startDate;
	}
	public java.sql.Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(java.sql.Date endDate) {
		EndDate = endDate;
	}



}
