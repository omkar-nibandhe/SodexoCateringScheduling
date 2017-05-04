package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.catering.classes.AvailabilityDAO;
import com.catering.classes.EmployeeDAO;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteEmployee {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
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

	private void showTable(String SQLquery) {
		// TODO Auto-generated method stub
		try {
			Connection viewTable = SQLiteConnection.getInstance();
			

			PreparedStatement stmt = viewTable.prepareStatement(SQLquery);
			ResultSet rs = stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			//SQLiteConnection.dbClose();

		} catch (Exception e) {

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
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					if (row > 0) {
						switch(JOptionPane.showConfirmDialog(null, "Do you want to delete "+ table.getModel().getValueAt(row, 1))){
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
