/**
 * 
 */
package com.catering.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Omkar Nibandhe<br>
 *         Apr 25, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 */
public class EventDAO {
	/**
	 * Fetch the events from EventTable database by specifying Sr.No.
	 * 
	 * @param SrNo
	 *            Unique identification for the event.
	 * @return Event object
	 */
	public static Event fetchEvent(int SrNo) {
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

	/**
	 * Update the event details.
	 * 
	 * @param e
	 *            Event object containing the updated event details.
	 */
	public static void updateEvent(Event e) {

		try {

			Connection updateEvent = SQLiteConnection.getInstance();
			String sqlQuery = "UPDATE EventTable SET EventID = ?, EventName = ?, EventLocation = ?, GuestCoune = ?, Disposable = ?, StartTime = ?, EndTime = ?, Date = ?, Day = ? WHERE SrNo = ?";

			PreparedStatement pstmt = updateEvent.prepareStatement(sqlQuery);

			pstmt.setInt(1, e.getEventID());
			pstmt.setString(2, e.getEventName());
			pstmt.setString(3, e.getEventLocation());
			pstmt.setInt(4, e.getGuestCount());
			pstmt.setBoolean(5, e.getIsDisposable());
			pstmt.setInt(6, e.getStartTime());
			pstmt.setInt(7, e.getEndTime());
			pstmt.setDate(8, e.getDate());
			pstmt.setString(9, e.getDay());
			pstmt.setInt(10, e.getSrNo());

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * Add new event to the database EventTable.
	 * 
	 * @param e
	 *            Event object with all the details.
	 * @return Returns the Unique ID number for the newly added record.
	 */
	public static int addEvent(Event e) {
		int SrNo = 0;
		try {

			Connection saveConnection = SQLiteConnection.getInstance();
			String sqlQuerry = "INSERT INTO EventTable (EventID, EventName, EventLocation, GuestCoune, Disposable, StartTime, EndTime, Date, Day) VALUES (?,?,?,?,?,?,?,?,?)";
			String sqlQuerry2 = "SELECT * FROM EventTable WHERE EventID = ? and EventName = ?";

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

			// saveConnection.commit();
			pstmt.close();

			pstmt = saveConnection.prepareStatement(sqlQuerry2);
			pstmt.setInt(1, e.getEventID());
			pstmt.setString(2, e.getEventName());
			ResultSet rs = pstmt.executeQuery();
			SrNo = rs.getInt("SrNo");
			return SrNo;

		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
		return SrNo;
	}

	/**
	 * Remove the event from the database with reference to EventID.
	 * 
	 * @param EventID
	 *            Event number
	 */
	public static void removeEvent(int EventID) {
		try {

			Connection removeConnection = SQLiteConnection.getInstance();
			String sqlQuerry = "DELETE FROM EventTable WHERE SrNo = ?";

			PreparedStatement pstmt = removeConnection.prepareStatement(sqlQuerry);

			pstmt.setInt(1, EventID);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
