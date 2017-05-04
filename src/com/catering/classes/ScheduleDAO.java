package com.catering.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.catering.sodexo.SQLiteConnection;

public class ScheduleDAO {
	
	public static void addBulkSchedule(List<Schedule> multiples){
		for(Schedule singleRecord : multiples){
			try{
				Connection saveSchedule = SQLiteConnection.getInstance();
				String sqlQuerry = "INSERT INTO ScheduleDB VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = saveSchedule.prepareStatement(sqlQuerry);
				stmt.setInt(1, singleRecord.getEventID());
				stmt.setInt(2, singleRecord.getEmployeeID());
				stmt.setInt(3, singleRecord.getStartTime());
				stmt.setInt(4, singleRecord.getEndTime());
				stmt.setString(5, singleRecord.getDay());
				stmt.setDate(6, singleRecord.getDate());
				
				stmt.executeUpdate();
				stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void addSchedule(Schedule singleRecord){
		
			try{
				Connection saveSchedule = SQLiteConnection.getInstance();
				String sqlQuerry = "INSERT INTO ScheduleDB VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = saveSchedule.prepareStatement(sqlQuerry);
				stmt.setInt(1, singleRecord.getEventID());
				stmt.setInt(2, singleRecord.getEmployeeID());
				stmt.setInt(3, singleRecord.getStartTime());
				stmt.setInt(4, singleRecord.getEndTime());
				stmt.setString(5, singleRecord.getDay());
				stmt.setDate(6, singleRecord.getDate());
				
				stmt.executeUpdate();
				stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}
	public static List<Schedule> getSchedulebyEventID(int eventID){
		List<Schedule> sc = new ArrayList<Schedule>();
		try{
			Connection getSchedule = SQLiteConnection.getInstance();
			String sqlQuerry = "SELECT * FROM ScheduleDB WHERE EventID = ?";
			PreparedStatement stmt = getSchedule.prepareStatement(sqlQuerry);
			stmt.setInt(1, eventID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Schedule temp = new Schedule();
				temp.setEventID(rs.getInt("EventID"));
				temp.setEmployeeID(rs.getInt("EmployeeID"));
				temp.setStartTime(rs.getInt("StartTime"));
				temp.setEndTime(rs.getInt("EndTime"));
				temp.setDate(rs.getDate("Date"));
				temp.setDay(rs.getString("Day"));
				
				sc.add(temp);
			}
			stmt.close();
			return sc;
		}catch(Exception e){
			e.printStackTrace();
		}
		return sc;
	}

	public static List<Schedule> getSchedulebyEmployeeID(int employeeID){
		List<Schedule> sc = new ArrayList<Schedule>();
		try{
			Connection getSchedule = SQLiteConnection.getInstance();
			String sqlQuerry = "SELECT * FROM ScheduleDB WHERE EventID = ?";
			PreparedStatement stmt = getSchedule.prepareStatement(sqlQuerry);
			stmt.setInt(1, employeeID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Schedule temp = new Schedule();
				temp.setEventID(rs.getInt("EventID"));
				temp.setEmployeeID(rs.getInt("EmployeeID"));
				temp.setStartTime(rs.getInt("StartTime"));
				temp.setEndTime(rs.getInt("EndTime"));
				temp.setDate(rs.getDate("Date"));
				temp.setDay(rs.getString("Day"));
				
				sc.add(temp);
			}
			stmt.close();
			return sc;
		}catch(Exception e){
			e.printStackTrace();
		}
		return sc;
	}
	
	public static void removeSchedulebyEventID(int eventID){
		try{
			Connection getSchedule = SQLiteConnection.getInstance();
			String sqlQuerry = "DELETE FROM ScheduleDB WHERE EventID = ?";
			PreparedStatement stmt = getSchedule.prepareStatement(sqlQuerry);
			stmt.setInt(1, eventID);
			stmt.executeUpdate();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void removeSchedulebyEmployeeID(int employeeID){
		try{
			Connection getSchedule = SQLiteConnection.getInstance();
			String sqlQuerry = "DELETE FROM ScheduleDB WHERE EmployeeID = ?";
			PreparedStatement stmt = getSchedule.prepareStatement(sqlQuerry);
			stmt.setInt(1, employeeID);
			stmt.executeUpdate();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void removeSchedule(Schedule e){
		try{
			Connection getSchedule = SQLiteConnection.getInstance();
			String sqlQuerry = "DELETE FROM ScheduleDB WHERE EventID = ? AND EmployeeID = ? AND StartTime = ? AND EndTime = ? AND Day = ?";
				
			//System.out.println("EventID: "+e.getEventID()+" EmployeeID: "+e.getEmployeeID()+" StartTime: "+e.getStartTime()+" endTIme: "+e.getEndTime()+" day:"+e.getDay()+" date: "+e.getDate());
			PreparedStatement stmt = getSchedule.prepareStatement(sqlQuerry);
			stmt.setInt(1, e.getEventID());
			stmt.setInt(2, e.getEmployeeID());
			stmt.setInt(3, e.getStartTime());
			stmt.setInt(4, e.getEndTime());
			stmt.setString(5, e.getDay().toLowerCase());
			
			
			stmt.executeUpdate();
			stmt.close();
			
			stmt = getSchedule.prepareStatement(sqlQuerry);
			stmt.setInt(1, 0);
			stmt.setInt(2, e.getEmployeeID());
			stmt.setInt(3, e.getStartTime());
			stmt.setInt(4, e.getEndTime());
			stmt.setString(5, e.getDay().toLowerCase());
			
			
			stmt.executeUpdate();
			stmt.close();
			//System.out.println("HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
