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
 * Apr 26, 2017 	
 * https://www.linkedin.com/in/omkarnibandhe
 */
public class WeekDAO {
	
	public static java.sql.Date[] getWeek(){
		java.sql.Date[] result = new java.sql.Date[2];
		
		try{
			Connection gwConn = SQLiteConnection.getInstance();
			String sqlQuerry = "SELECT * FROM Week";
			PreparedStatement pstmt = gwConn.prepareStatement(sqlQuerry);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.isClosed()){
				result[0] = rs.getDate("StartDate");
				result[1] = rs.getDate("EndDate");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void setWeek(java.sql.Date[] timings){
		try{
			Connection gwConn = SQLiteConnection.getInstance();
			String sqlQuerry = "DELETE FROM Week";
			PreparedStatement pstmt = gwConn.prepareStatement(sqlQuerry);
			pstmt.executeUpdate();
			pstmt.close();
			
			sqlQuerry = "INSERT INTO Week VALUES (?,?)";
			pstmt = gwConn.prepareStatement(sqlQuerry);
			pstmt.setDate(1, timings[0]);
			pstmt.setDate(2, timings[1]);
			pstmt.executeUpdate();
			pstmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
