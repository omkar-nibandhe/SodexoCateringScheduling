package com.catering.classes;

import java.sql.*;
import javax.swing.*;

/**
 * @author Omkar Nibandhe <br>
 *         Apr 21, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class SQLiteConnection {
	/**
	 * Singleton pattern enforcement to JDBC connection for SQLite. Singleton
	 * class to get the object for connecting to database.
	 */
	public static Connection conn = null;

	/**
	 * Making the class singleton.
	 */
	protected SQLiteConnection() {

	}

	/**
	 * Get the instance of the connection class inorder to avoid multiple access
	 * to database.
	 * 
	 * @return connection instance
	 */
	public static Connection getInstance() {
		if (conn == null) {
			try {
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:.\\SodexoCatering.sqlite");
				// JOptionPane.showMessageDialog(null, "Connnection
				// Established.");
				conn.setAutoCommit(true);
				return conn;

			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Connection error.");
			}
		}
		return conn;
	}

	/**
	 * Method to close the connection to the database.
	 */
	public static void dbClose() {
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Close error.");
		}
	}
}
