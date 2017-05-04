/**
 * 
 */
package com.catering.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.catering.sodexo.SQLiteConnection;

/**
 * @author Omkar Nibandhe Apr 25, 2017 https://www.linkedin.com/in/omkarnibandhe
 */
public class AvailabilityDAO {

	public static StringBuilder[] getAllTimings(int empID) {
		StringBuilder[] results = new StringBuilder[7];
		for (int i = 0; i < 7; i++)
			results[i] = new StringBuilder();

		// TODO Auto-generated method stub
		try {
			Connection editEmployee = SQLiteConnection.getInstance();
			String SQLquery = "SELECT * FROM AvailabilityTable WHERE EmployeeID = ?";
			PreparedStatement stmt = editEmployee.prepareStatement(SQLquery);
			stmt.setInt(1, empID);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String time;
				time = rs.getInt("StartTime") + "-" + rs.getInt("EndTime") + ";";
				switch (rs.getString("Day").toLowerCase()) {
				case "monday":
					results[0].append(time);
					time = null;
					break;
				case "tuesday":
					results[1].append(time);
					time = null;
					break;
				case "wednesday":
					results[2].append(time);
					time = null;
					break;
				case "thursday":
					results[3].append(time);
					time = null;
					break;
				case "friday":
					results[4].append(time);
					time = null;
					break;
				case "saturday":
					results[5].append(time);
					time = null;
					break;
				case "sunday":
					results[6].append(time);
					time = null;
					break;
				default:
					System.out.println("Not of use");
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// SQLiteConnection.dbClose();
		}
		return results;
	}

	public static void deleteTimings(int empID) {
		try {
			Connection deletTime = SQLiteConnection.getInstance();
			String SQLquery = "DELETE FROM AvailabilityTable WHERE EmployeeID = ?";
			PreparedStatement stmt = deletTime.prepareStatement(SQLquery);
			stmt.setInt(1, empID);
			stmt.executeUpdate();
			//deletTime.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void addTimings(int empID, String dayTimings, String day) {
		try {
			Connection addTime = SQLiteConnection.getInstance();
			String sqlQuerry1 = "INSERT INTO AvailabilityTable VALUES(?,?,?,?)";
			PreparedStatement pstmt = addTime.prepareStatement(sqlQuerry1);
			
			AvailabilityDAO.insertTimings(pstmt, dayTimings, day, empID);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	private static int insertTimings(PreparedStatement pstmt, String text, String day, int empID) throws Exception {
		// TODO Auto-generated method stub
		if(text.isEmpty()){
			return 0;
		}
		if (text.contains(";")) {
			String[] timeSet = text.split(";");

			for (String s : timeSet) {
				String[] timeEntry = s.split("-");
				pstmt.setInt(1, empID);
				pstmt.setString(2, day.toLowerCase());
				pstmt.setInt(3, Integer.parseInt(timeEntry[0]));
				pstmt.setInt(4, Integer.parseInt(timeEntry[1]));
				/*//System.out.println(" EmpID : " + empID + " Day: " + day + " Start Time: " + timeEntry[0]
						+ " EndTime: " + timeEntry[1]);*/
				pstmt.executeUpdate();
			}
		} else {
			String[] timeEntry = text.split("-");
			pstmt.setInt(1, empID);
			pstmt.setString(2, day.toLowerCase());
			pstmt.setString(3, timeEntry[0]);
			pstmt.setString(4, timeEntry[1]);
			/*//System.out.println(" EmpID : " + empID + " Day: " + day + " Start Time: " + timeEntry[0]
					+ " EndTime: " + timeEntry[1]);
			*/return pstmt.executeUpdate();
		}

		return 0;

	}

	public static String getAllTimingsForDay(int empID, String day){
		String result = null;
		StringBuilder res = new StringBuilder();
		try {
			Connection editEmployee = SQLiteConnection.getInstance();
			String SQLquery = "SELECT * FROM AvailabilityTable WHERE EmployeeID = ? AND Day = ?";
			PreparedStatement stmt = editEmployee.prepareStatement(SQLquery);
			stmt.setInt(1, empID);
			stmt.setString(2, day.toLowerCase());

			ResultSet rs = stmt.executeQuery();
			String time;
			while(rs.next()){
				time = null;
				time = rs.getInt("StartTime") + "-" + rs.getInt("EndTime") + ";";
				res.append(time);
			}
			result = res.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
	public static List<String> getAllTimingsForDay(String day){
		List<String> result = null;
		try {
			Connection editEmployee = SQLiteConnection.getInstance();
			String SQLquery = "SELECT EmployeeTable.FName, EmployeeTable.LName, AvailabilityTable.Day, AvailabilityTable.EmployeeID, AvailabilityTable.StartTime, AvailabilityTable.EndTIme FROM AvailabilityTable, EmployeeTable WHERE Day = ? AND AvailabilityTable.EmployeeID == EmployeeTable.EmployeeID";
			PreparedStatement stmt = editEmployee.prepareStatement(SQLquery);
			stmt.setString(1, day.toLowerCase());

			ResultSet rs = stmt.executeQuery();
			result = new ArrayList<String>();
			String time = null;
			while(rs.next()){
				time = null;
				time = rs.getInt("EmployeeID")+" "+rs.getString("FName")+ " "+ rs.getString("LName")+ " "+ rs.getInt("StartTime") + " " + rs.getInt("EndTime");
				result.add(time);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
}
