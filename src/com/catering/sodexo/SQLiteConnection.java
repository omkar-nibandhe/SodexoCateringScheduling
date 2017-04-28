package com.catering.sodexo;
import java.sql.*;
import javax.swing.*;
/**
 * @author Omkar Nibandhe
 * Apr 21, 2017 	
 * https://www.linkedin.com/in/omkarnibandhe
 */
public class SQLiteConnection {

	public static Connection conn = null;
	protected SQLiteConnection(){
		
	}
	public static Connection getInstance(){
		if (conn == null){
			try {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:.\\SodexoCatering.sqlite");
				//JOptionPane.showMessageDialog(null, "Connnection Established.");
				conn.setAutoCommit(true);
				return conn;
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Connection error.");
			}
		}
		return conn;
	}

	public static void dbClose(){
		try{
			conn.close();
			conn = null;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Connection Close error.");
		}
	}
}
