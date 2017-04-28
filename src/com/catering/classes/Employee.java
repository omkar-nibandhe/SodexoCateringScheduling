/**
 * 
 */
package com.catering.classes;

/**
 * @author Omkar Nibandhe
 * Apr 25, 2017 	
 * https://www.linkedin.com/in/omkarnibandhe
 */
public class Employee {

	private int ID, Phone, ZIP;
	private String FName, LName, EmailID, Address, State;
	private boolean driver, student;
	
	
	
	
	public Employee(){
		
	}
	
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
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public int getZIP() {
		return ZIP;
	}
	public void setZIP(int zIP) {
		ZIP = zIP;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public boolean isDriver() {
		return driver;
	}
	public void setDriver(boolean driver) {
		this.driver = driver;
	}
	public boolean isStudent() {
		return student;
	}
	public void setStudent(boolean student) {
		this.student = student;
	}
	
	
	
}
