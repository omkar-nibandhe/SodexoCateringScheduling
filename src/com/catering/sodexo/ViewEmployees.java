package com.catering.sodexo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import com.catering.classes.SQLiteConnection;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Omkar Nibandhe <br>
 * 		May 5, 2017 <br>
 * 		https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class ViewEmployees {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 * @param args unused
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployees window = new ViewEmployees();
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
	public ViewEmployees() {
		initialize();

	}

	private void showTable(String SQLquery) {
		// TODO Auto-generated method stub
		try {
			Connection viewTable = SQLiteConnection.getInstance();
			// viewTable.dbConnect();

			PreparedStatement stmt = viewTable.prepareStatement(SQLquery);
			ResultSet rs = stmt.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {

		} finally {
			// SQLiteConnection.dbClose();
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

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.main(null);
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
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int row = table.getSelectedRow();
				int option = JOptionPane.showConfirmDialog(null, "Edit " + table.getModel().getValueAt(row, 1) + " "
						+ table.getModel().getValueAt(row, 2) + " ?");
				if (option == 0) {
					// yes option

					int val = (int) (table.getModel().getValueAt(row, 0));

					EditEmployeeSchedule.setEmpID(val);
					EditEmployeeSchedule.main(null);
					frame.dispose();
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

	}
}
