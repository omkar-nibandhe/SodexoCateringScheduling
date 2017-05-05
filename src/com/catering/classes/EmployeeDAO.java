package com.catering.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Omkar Nibandhe<br>
 *         May 4, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class EmployeeDAO {

	/**
	 * Returns Employee class object from EmployeeTable by searching with
	 * EmployeeID (int).
	 * 
	 * @param empID
	 *            unique int value referencing employee
	 * @return Employee class object
	 */
	public static Employee fetchEmployee(int empID) {
		Employee e = new Employee();
		// System.out.println("empID in DAO " + empID);
		try {

			Connection editEmployee = SQLiteConnection.getInstance();
			String SQLquery = "SELECT * FROM EmployeeTable WHERE EmployeeID = ?";
			PreparedStatement stmt = editEmployee.prepareStatement(SQLquery);
			stmt.setInt(1, empID);

			ResultSet rs = stmt.executeQuery();
			e.setID(rs.getInt("EmployeeID"));
			e.setFName(rs.getString("FName"));
			e.setLName(rs.getString("LName"));
			e.setPhone(rs.getInt("Phone"));
			e.setEmailID(rs.getString("EmailID"));
			e.setAddress(rs.getString("Address"));
			e.setState(rs.getString("State"));
			e.setZIP(rs.getInt("ZIP"));
			e.setDriver(rs.getBoolean("Drives"));
			e.setStudent(rs.getBoolean("Student"));

		} catch (Exception err) {
			err.printStackTrace();
		}
		return e;
	}

	/**
	 * Update Employee record.
	 * 
	 * @param e
	 *            Employee object to set new values to existing record.
	 */
	public static void updateEmployee(Employee e) {
		try {

			Connection saveConnection = SQLiteConnection.getInstance();
			String sqlQuery = "UPDATE EmployeeTable SET FName = ?, LName = ?, Phone = ?, EmailID= ?, Address = ?, State = ?, ZIP = ?, Drives = ?, Student = ? WHERE EmployeeID = ?";
			PreparedStatement pstmt = saveConnection.prepareStatement(sqlQuery);
			pstmt.setString(1, e.getFName());
			pstmt.setString(2, e.getLName());
			pstmt.setInt(3, e.getPhone());
			pstmt.setString(4, e.getEmailID());
			pstmt.setString(5, e.getAddress());
			pstmt.setString(6, e.getState());
			pstmt.setInt(7, e.getZIP());
			pstmt.setBoolean(8, e.isDriver());
			pstmt.setBoolean(9, e.isStudent());
			pstmt.setInt(10, e.getID());

			pstmt.executeUpdate();
			// saveConnection.commit();
		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}

	}

	/**
	 * Adds employee to the EmployeeTable database
	 * 
	 * @param e
	 *            Employee class object specifying all the details related to
	 *            employee.
	 * @return Unique identification number (EmployeeID)
	 */
	public static int addEmployee(Employee e) {
		int i = 0;
		try {

			Connection saveConnection = SQLiteConnection.getInstance();
			String sqlQuerry = "INSERT INTO EmployeeTable(FName, LName, Phone, EmailID, Address, State, ZIP, Drives, Student) VALUES (?,?,?,?,?,?,?,?,?)";
			String sqlQuerry2 = "SELECT * FROM EmployeeTable WHERE FName = ? and LName = ? and EmailID = ?;";

			PreparedStatement pstmt = saveConnection.prepareStatement(sqlQuerry);

			pstmt.setString(1, e.getFName());
			pstmt.setString(2, e.getLName());
			pstmt.setInt(3, e.getPhone());
			pstmt.setString(4, e.getEmailID());
			pstmt.setString(5, e.getAddress());
			pstmt.setString(6, e.getState());
			pstmt.setInt(7, e.getZIP());
			pstmt.setBoolean(8, e.isDriver());
			pstmt.setBoolean(9, e.isStudent());

			pstmt.executeUpdate();
			// saveConnection.commit();
			pstmt.close();

			pstmt = saveConnection.prepareStatement(sqlQuerry2);
			pstmt.setString(1, e.getFName());
			pstmt.setString(2, e.getLName());
			pstmt.setString(3, e.getEmailID());
			ResultSet rs = pstmt.executeQuery();
			return rs.getInt("EmployeeID");

		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
		return i;
	}

	/**
	 * Removes employee from the EmployeeTable database by specifying employeeID
	 * (int) value.
	 * 
	 * @param empID
	 *            int value unique employee identification number
	 */
	public static void removeEmployee(int empID) {
		try {

			Connection saveConnection = SQLiteConnection.getInstance();
			String sqlQuerry = "DELETE FROM EmployeeTable WHERE EmployeeID = ?";
			PreparedStatement pstmt = saveConnection.prepareStatement(sqlQuerry);
			pstmt.setInt(1, empID);
			pstmt.executeUpdate();
			pstmt.close();

			sqlQuerry = "DELETE FROM AvailabilityTable WHERE EmployeeID = ?";
			pstmt = saveConnection.prepareStatement(sqlQuerry);
			pstmt.setInt(1, empID);
			pstmt.executeUpdate();
			pstmt.close();

			sqlQuerry = "DELETE FROM ScheduleDB WHERE EmployeeID = ?";
			pstmt = saveConnection.prepareStatement(sqlQuerry);
			pstmt.setInt(1, empID);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
