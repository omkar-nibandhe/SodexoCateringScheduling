/**
 * 
 */
package com.catering.classes;

/**
 * @author Omkar Nibandhe <br>
 * 		Apr 25, 2017 <br>
 * 		https://www.linkedin.com/in/omkarnibandhe
 */
public class Employee {

	private int ID, Phone, ZIP;
	private String FName, LName, EmailID, Address, State;
	private boolean driver, student;

	/**
	 * Default Constructor
	 */

	public Employee() {

	}

	/**
	 * Parametric Constructor
	 * 
	 * @param iD
	 *            unique employeeid int
	 * @param phone
	 *            phone number 10 digit int value
	 * @param zIP
	 *            ZIP for permenant address
	 * @param fName
	 *            First Name of this employee
	 * @param lName
	 *            Last Name of this employee
	 * @param emailID
	 *            Email address of this employee.
	 * @param address
	 *            Mailing address of this employee
	 * @param state
	 *            Address state of this employee.
	 * @param driver
	 *            Holds a driving authorization in the company.
	 * @param student
	 *            Bool value denotes is a Student or not.
	 */
	public Employee(int iD, int phone, int zIP, String fName, String lName, String emailID, String address,
			String state, boolean driver, boolean student) {
		super();
		ID = iD;
		Phone = phone;
		ZIP = zIP;
		FName = fName;
		LName = lName;
		EmailID = emailID;
		Address = address;
		State = state;
		this.driver = driver;
		this.student = student;
	}

	/**
	 * Get the unique ID of this employee.
	 * 
	 * @return Returns the uniquee id of this employee.
	 */

	public int getID() {
		return ID;
	}

	/**
	 * Set the unique ID of this employee.
	 * 
	 * @param iD
	 *            Uniquee id of this employee.
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Get phonenumber of this employee.
	 * 
	 * @return Returns the 10 digit phone number
	 */
	public int getPhone() {
		return Phone;
	}

	/**
	 * Set phonenumber of this employee.
	 * 
	 * @param phone
	 *            Returns the phone number of this employee.
	 */
	public void setPhone(int phone) {
		Phone = phone;
	}

	/**
	 * Get the zip code for the address provided by this employee.
	 * 
	 * @return int value denoting the zip code.
	 */
	public int getZIP() {
		return ZIP;
	}

	/**
	 * Set the zip code for the address provided by this employee.
	 * 
	 * @param zIP
	 *            value denoting the zip code.
	 */
	public void setZIP(int zIP) {
		ZIP = zIP;
	}

	/**
	 * Get the first name of this employee.
	 * 
	 * @return String value of the first name.
	 */
	public String getFName() {
		return FName;
	}

	/**
	 * Set the first name of this employee.
	 * 
	 * @param fName
	 *            String value of the first name.
	 */
	public void setFName(String fName) {
		FName = fName;
	}

	/**
	 * Get the Last name of this employee.
	 * 
	 * @return String value of the last name.
	 */
	public String getLName() {
		return LName;
	}

	/**
	 * Set the Last name of this employee.
	 * 
	 * @param lName
	 *            String value of the last name.
	 */
	public void setLName(String lName) {
		LName = lName;
	}

	/**
	 * Gets the email id of this employee.
	 * 
	 * @return String denotion of the email address.
	 */

	public String getEmailID() {
		return EmailID;
	}

	/**
	 * Sets the email id of this employee.
	 * 
	 * @param emailID
	 *            String denotion of the email address.
	 */
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}

	/**
	 * Gets the address of the employee.
	 * 
	 * @return String notation of the mailing address.
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * Sets the address of the employee.
	 * 
	 * @param address
	 *            String notation of the mailing address.
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * Gets the State in mailing address.
	 * 
	 * @return String notation of the State in mailing address.
	 */
	public String getState() {
		return State;
	}

	/**
	 * Sets the State in mailing address.
	 * 
	 * @param state
	 *            String notation of the State in mailing address.
	 */
	public void setState(String state) {
		State = state;
	}

	/**
	 * Get driving status for this employee.
	 * 
	 * @return if this employee is a driver to the company.
	 */
	public boolean isDriver() {
		return driver;
	}

	/**
	 * Set driving status for this employee.
	 * 
	 * @param driver
	 *            if this employee is a driver to the company.
	 */
	public void setDriver(boolean driver) {
		this.driver = driver;
	}

	/**
	 * Get if this employee is a student.
	 * 
	 * @return true if this employee is a student.
	 */
	public boolean isStudent() {
		return student;
	}

	/**
	 * Set if this employee is a student.
	 * 
	 * @param student
	 *            Bool value.
	 */
	public void setStudent(boolean student) {
		this.student = student;
	}

}
