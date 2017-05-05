/**
 * 
 */
package com.catering.classes;

import java.sql.Date;

/**
 * @author Omkar Nibandhe <br>
 * 		Apr 26, 2017 <br>
 * 		https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 * 
 */
public class Week {

	private java.sql.Date StartDate, EndDate;

	/*
	 * Default Constructor.
	 */
	public Week() {

	}

	/**
	 * Parametric constructor.
	 * 
	 * @param startDate
	 *            Start date java.sql.Date object. Strictly start date should be
	 *            a friday.
	 * @param endDate
	 *            End Date of the week. java.sql.Date object. usually Start Date
	 *            + 7.
	 */
	public Week(Date startDate, Date endDate) {
		super();
		StartDate = startDate;
		EndDate = endDate;
	}

	/**
	 * Get the start date for the week under consideration.
	 * 
	 * @return java.sql.Date object
	 */
	public java.sql.Date getStartDate() {
		return StartDate;
	}

	/**
	 * Set the start date for the week under consideration.
	 * 
	 * @param startDate
	 *            java.sql.Date object
	 */
	public void setStartDate(java.sql.Date startDate) {
		StartDate = startDate;
	}

	/**
	 * Get the end date for the week under consideration.
	 * 
	 * @return java.sql.Date object
	 */
	public java.sql.Date getEndDate() {
		return EndDate;
	}

	/**
	 * Set the end date for the week under consideration
	 * 
	 * @param endDate
	 *            java.sql.Date object
	 */
	public void setEndDate(java.sql.Date endDate) {
		EndDate = endDate;
	}

}
