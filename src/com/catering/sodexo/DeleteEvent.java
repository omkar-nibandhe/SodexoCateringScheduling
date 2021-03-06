package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.catering.classes.EventDAO;
import com.catering.classes.SQLiteConnection;
import com.catering.classes.ScheduleDAO;

import net.proteanit.sql.DbUtils;

/**
 * @author Omkar Nibandhe <br>
 *         May 5, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class DeleteEvent {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 *
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEvent window = new DeleteEvent();
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
	public DeleteEvent() {
		frame = new JFrame("Delete Event");
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			Image image1 = ImageIO.read(new File(".\\Resources\\binghamton_bearcats-alternate-2001.png"));
			frame.setIconImage(image1);

		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeScheduler.main(null);
				frame.dispose();
			}
		});
		btnBack.setBounds(1124, 11, 116, 47);
		frame.getContentPane().add(btnBack);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 77, 1214, 568);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			/**
			 * Get confirmation before deleting the event and related scheduled
			 * employees.
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int row = table.getSelectedRow();
				int option = JOptionPane.showConfirmDialog(null, "Delete " + table.getModel().getValueAt(row, 1) + " "
						+ table.getModel().getValueAt(row, 2) + " ?");
				if (option == 0) {
					// yes option
					/*
					 * int val = (int) (table.getModel().getValueAt(row, 0));
					 * ViewEvents_2.setMySrNo(val); ViewEvents_2.main(null);
					 */
					EventDAO.removeEvent((int) table.getModel().getValueAt(row, 0));
					ScheduleDAO.removeSchedulebyEventID((int) table.getModel().getValueAt(row, 1));
					EmployeeScheduler.main(null);
					frame.dispose();
				}
			}
		});
		scrollPane.setViewportView(table);

		JButton btnAllEmployees = new JButton("All Events");
		btnAllEmployees.addActionListener(new ActionListener() {
			/**
			 * Fetch all events.
			 */
			public void actionPerformed(ActionEvent arg0) {
				String sqlQuerry = "SELECT * FROM EventTable";
				showTable(sqlQuerry);
			}
		});
		btnAllEmployees.setBounds(24, 11, 178, 47);
		frame.getContentPane().add(btnAllEmployees);

		JButton btnAllStudents = new JButton("China Events");
		btnAllStudents.addActionListener(new ActionListener() {
			/**
			 * Fetch all china service events
			 */
			public void actionPerformed(ActionEvent e) {

				String sqlQuerry = "SELECT * FROM EventTable where Disposable = 0";
				showTable(sqlQuerry);
			}
		});
		btnAllStudents.setBounds(232, 11, 178, 47);
		frame.getContentPane().add(btnAllStudents);

		JButton btnAllLeads = new JButton("Disposable Events");
		btnAllLeads.addActionListener(new ActionListener() {
			/**
			 * Fetch all disposable service type events.
			 */
			public void actionPerformed(ActionEvent e) {
				String sqlQuerry = "SELECT * FROM EventTable where Disposable = 1";
				showTable(sqlQuerry);
			}
		});
		btnAllLeads.setBounds(440, 11, 178, 47);
		frame.getContentPane().add(btnAllLeads);

	}

	/**
	 * This method sets the model for the table using the ResultSet from the
	 * querry fired.
	 * 
	 * @param SQLquery
	 *            SQL querry for the prepared statement in order to fetch
	 *            results and display in the JTable.
	 */
	private void showTable(String SQLquery) {
		// TODO Auto-generated method stub
		try {
			Connection viewTable = SQLiteConnection.getInstance();
			// viewTable.dbConnect();

			PreparedStatement stmt = viewTable.prepareStatement(SQLquery);
			ResultSet rs = stmt.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

			// SQLiteConnection.dbClose();

		} catch (Exception e) {

		} finally {
			// SQLiteConnection.dbClose();
		}
	}

}
