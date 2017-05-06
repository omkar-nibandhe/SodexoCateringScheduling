package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.catering.classes.AvailabilityDAO;
import com.catering.classes.EmployeeDAO;
import com.catering.classes.SQLiteConnection;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * @author Omkar Nibandhe <br>
 *         May 5, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class DeleteEmployee {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 *
	 * @param args
	 *            usually null. Unused
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee window = new DeleteEmployee();
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
	public DeleteEmployee() {
		initialize();
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

			PreparedStatement stmt = viewTable.prepareStatement(SQLquery);
			ResultSet rs = stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

			// SQLiteConnection.dbClose();

		} catch (Exception e) {

		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Delete Employee");
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
				MainPage.main(new String[] {});
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
			 * Override mouseClicked event to confirm deletion of the record
			 * from database.
			 */
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = table.getSelectedRow();
					JOptionPane.showMessageDialog(null, "Click DELETE button to delete  "
							+ table.getModel().getValueAt(row, 1).toString().toUpperCase());
				} catch (Exception e) {

				}
			}
		});
		scrollPane.setViewportView(table);

		JButton btnAllEmployees = new JButton("All Employees");
		btnAllEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sqlQuerry = "SELECT EmployeeID, FName, LName, Phone, EmailID FROM EmployeeTable";
				showTable(sqlQuerry);
			}
		});
		btnAllEmployees.setBounds(24, 11, 178, 47);
		frame.getContentPane().add(btnAllEmployees);

		JButton btnAllStudents = new JButton("All Students");
		btnAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlQuerry = "SELECT EmployeeID, FName, LName, Phone, EmailID FROM EmployeeTable where Student = 1";
				showTable(sqlQuerry);
			}
		});
		btnAllStudents.setBounds(232, 11, 178, 47);
		frame.getContentPane().add(btnAllStudents);

		JButton btnAllLeads = new JButton("All Leads");
		btnAllLeads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlQuerry = "SELECT EmployeeID, FName, LName, Phone, EmailID FROM EmployeeTable where Student = 0";
				showTable(sqlQuerry);
			}
		});
		btnAllLeads.setBounds(440, 11, 178, 47);
		frame.getContentPane().add(btnAllLeads);

		JButton btnAllDrivers = new JButton("All Drivers");
		btnAllDrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlQuerry = "SELECT EmployeeID, FName, LName, Phone, EmailID FROM EmployeeTable where Drives = 1";
				showTable(sqlQuerry);
			}
		});
		btnAllDrivers.setBounds(641, 11, 178, 47);
		frame.getContentPane().add(btnAllDrivers);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			/**
			 * Confirm deletion of the record and corresponding records from
			 * Employee database and Availability Database.
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					if (row > 0) {
						switch (JOptionPane.showConfirmDialog(null,
								"Do you want to delete " + table.getModel().getValueAt(row, 1))) {
						case 0:
							int deleteID = (int) table.getModel().getValueAt(row, 0);
							AvailabilityDAO.deleteTimings(deleteID);
							EmployeeDAO.removeEmployee(deleteID);
							DeleteEmployee.main(null);
							frame.dispose();
							break;
						case 1:
							break;
						case 2:
							break;
						default:
							break;
						}
					}
				} catch (Exception er) {

				}

			}
		});
		btnDelete.setForeground(Color.RED);
		btnDelete.setBounds(844, 11, 178, 47);
		frame.getContentPane().add(btnDelete);

	}

}
