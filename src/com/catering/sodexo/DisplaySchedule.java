package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;

public class DisplaySchedule {

	private JFrame frame;
	private JTable table_1;
	private JLabel label_Friday, label_Saturday, label_Sunday, label_Monday, label_Tuesday, label_Wednesday, label_Thursday;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					DisplaySchedule window = new DisplaySchedule(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplaySchedule(String[] args) {
		initialize();
		hitLabels(args);
		loadTable(args);
	}

	private void hitLabels(String[] args) {
		label_Friday.setText("Fri: "+args[1]);
		label_Saturday.setText("Sat: "+args[2]);
		label_Sunday.setText("Sun: "+args[3]);
		label_Monday.setText("Mon: "+args[4]);		
		label_Tuesday.setText("Tue: "+args[5]);
		label_Wednesday.setText("Wed: "+args[6]);
		label_Thursday.setText("Thur:"+args[7]);
		
	}

	private void loadTable(String[] args) {
		if (args[0].equalsIgnoreCase("week")) {
			String sqlQuerry = "SELECT E.LName || ' ' || E.FName as Name, S.Day, S.StartTime || '-' || S.EndTime as Time from EmployeeTable E left join ScheduleDB S on E.EmployeeID == S.EmployeeID AND (Date = ? OR Date = ? OR Date = ? OR Date = ? OR Date = ? OR Date = ? OR Date = ?) order by Name, Time";
			showTable(sqlQuerry, table_1, args);
		}
		if (args[0].equalsIgnoreCase("events")) {
			String sqlQuerry = "SELECT S.EventID || ' ' || S.EventName as Event, S.EventLocation, S.StartTime || ' - ' || S.EndTIme as EventTime, S.Day, E.FName || ' ' || E.Lname as Name from EventTable S left join EmployeeTable E, ScheduleDB T on S.EventID == T.EventID AND T.EmployeeID == E.EmployeeID AND (T.Date = ? OR T.Date = ? OR T.Date = ? OR T.Date = ? OR T.Date = ? OR T.Date = ? OR T.Date = ?) order by Event, EventTime";
			showTable(sqlQuerry, table_1, args);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeScheduler.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(1123, 11, 128, 46);
		frame.getContentPane().add(btnNewButton);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_1.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(1123, 610, 128, 46);
		frame.getContentPane().add(btnPrint);

		table_1 = new JTable();
		table_1.setBounds(27, 56, 1058, 598);
		table_1.setVisible(true);
		frame.getContentPane().add(table_1);
		
		label_Friday = new JLabel("New label");
		label_Friday.setBounds(27, 22, 97, 25);
		frame.getContentPane().add(label_Friday);
		
		label_Saturday = new JLabel("New label");
		label_Saturday.setBounds(134, 20, 97, 25);
		frame.getContentPane().add(label_Saturday);
		
		label_Sunday = new JLabel("New label");
		label_Sunday.setBounds(241, 20, 97, 25);
		frame.getContentPane().add(label_Sunday);
		
		label_Monday = new JLabel("New label");
		label_Monday.setBounds(348, 20, 97, 25);
		frame.getContentPane().add(label_Monday);
		
		label_Tuesday = new JLabel("New label");
		label_Tuesday.setBounds(455, 20, 97, 25);
		frame.getContentPane().add(label_Tuesday);
		
		label_Wednesday = new JLabel("New label");
		label_Wednesday.setBounds(566, 20, 97, 25);
		frame.getContentPane().add(label_Wednesday);
		
		label_Thursday = new JLabel("New label");
		label_Thursday.setBounds(677, 20, 97, 25);
		frame.getContentPane().add(label_Thursday);
	}

	private void showTable(String sqlQuerry, JTable table, String[] date) {
		try {
			Connection viewTable = SQLiteConnection.getInstance();

			PreparedStatement stmt = viewTable.prepareStatement(sqlQuerry);
			// stmt.setString(1, day.toLowerCase());
			for (int i = 1; i < date.length; i++) {
				stmt.setDate(i, java.sql.Date.valueOf(date[i]));

			}

			ResultSet rs = stmt.executeQuery();
			String name[] = { "Name", "Day", "Time" };
			table_1.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// SQLiteConnection.dbClose();
		}
	}
}