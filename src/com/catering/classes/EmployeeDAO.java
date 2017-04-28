package com.catering.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.catering.sodexo.SQLiteConnection;

public class EmployeeDAO {


	public static Employee fetchEmployee(int empID) {
		Employee e = new Employee();
		//System.out.println("empID in DAO " + empID);
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
			//saveConnection.commit();
		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}

	}

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
			saveConnection.commit();
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

	public static void removeEmployee(int empID) {
		try {

			Connection saveConnection = SQLiteConnection.getInstance();
			String sqlQuerry = "DELETE FROM EmployeeTable WHERE EmployeeID = ?";
			PreparedStatement pstmt = saveConnection.prepareStatement(sqlQuerry);
			pstmt.setInt(1, empID);
			pstmt.executeUpdate();
			//saveConnection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
