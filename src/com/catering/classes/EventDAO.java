/**
 * 
 */
package com.catering.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.catering.sodexo.SQLiteConnection;

/**
 * @author Omkar Nibandhe
 * Apr 25, 2017 	
 * https://www.linkedin.com/in/omkarnibandhe
 */
public class EventDAO {
	public static Event fetchEvent(int SrNo){
		Event e = new Event();
		try {

			Connection editEvent = SQLiteConnection.getInstance();
			String SQLquery = "SELECT * FROM EventTable WHERE SrNo = ?";
			PreparedStatement stmt = editEvent.prepareStatement(SQLquery);
			stmt.setInt(1, SrNo);

	
			ResultSet rs = stmt.executeQuery();
			
			e.setSrNo(rs.getInt("SrNo"));
			e.setEventID(rs.getInt("EventID"));
			e.setEventName(rs.getString("EventName"));
			e.setEventLocation(rs.getString("EventLocation"));
			e.setGuestCount(rs.getInt("GuestCoune"));
			e.setIsDisposable(rs.getBoolean("Disposable"));
			e.setStartTime(rs.getInt("StartTime"));
			e.setEndTime(rs.getInt("EndTime"));
			e.setDate(rs.getDate("Date"));
			e.setDay(rs.getString("Day"));
			
			stmt.close();
			
			return e;

		} catch (Exception err) {
			err.printStackTrace();
		}
		return e;
		
	}
	

	public static void updateEvent(Event e){
		
		try {

			Connection updateEvent = SQLiteConnection.getInstance();
			String sqlQuery = "UPDATE EventTable SET EventID = ?, EventName = ?, EventLocation = ?, GuestCoune = ?, Disposable = ?, StartTime = ?, EndTime = ?, Date = ? WHERE SrNo = ?";
			
			PreparedStatement pstmt = updateEvent.prepareStatement(sqlQuery);
			
			pstmt.setInt(1, e.getEventID());
			pstmt.setString(2, e.getEventName());
			pstmt.setString(3, e.getEventLocation());
			pstmt.setInt(4, e.getGuestCount());
			pstmt.setBoolean(5, e.getIsDisposable());
			pstmt.setInt(6, e.getStartTime());
			pstmt.setInt(7, e.getEndTime());
			pstmt.setDate(8, e.getDate());
			pstmt.setInt(9, e.getSrNo());
	
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception err) {
			err.printStackTrace();
		}	
	}
	
	public static int addEvent(Event e){
		int SrNo = 0;
		try {

			Connection saveConnection = SQLiteConnection.getInstance();
			String sqlQuerry = "INSERT INTO EventTable (EventID, EventName, EventLocation, GuestCoune, Disposable, StartTime, EndTime, Date, Day) VALUES (?,?,?,?,?,?,?,?,?)";
			String sqlQuerry2 = "SELECT * FROM EventTable WHERE EventID = ? and EventName = ? and Date = ?;";

			PreparedStatement pstmt = saveConnection.prepareStatement(sqlQuerry);

			pstmt.setInt(1, e.getEventID());
			pstmt.setString(2, e.getEventName());
			pstmt.setString(3, e.getEventLocation());
			pstmt.setInt(4, e.getGuestCount());
			pstmt.setBoolean(5, e.getIsDisposable());
			pstmt.setInt(6, e.getStartTime());
			pstmt.setInt(7, e.getEndTime());
			pstmt.setDate(8, e.getDate());
			pstmt.setString(9, e.getDay());
			pstmt.executeUpdate();
			
			//saveConnection.commit();
			pstmt.close();

			pstmt = saveConnection.prepareStatement(sqlQuerry2);
			pstmt.setInt(1, e.getEventID());
			pstmt.setString(2, e.getEventName());
			pstmt.setDate(3, e.getDate());
			ResultSet rs = pstmt.executeQuery();
			return rs.getInt("SrNo");

		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
		return SrNo;
	}
	
	public static void removeEvent(int EventID){
		try {

			Connection removeConnection = SQLiteConnection.getInstance();
			String sqlQuerry = "DELETE FROM EventTable WHERE SrNo = ?";
			

			PreparedStatement pstmt = removeConnection.prepareStatement(sqlQuerry);

			pstmt.setInt(1, EventID);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}