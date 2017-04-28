package com.catering.sodexo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage {

	private JFrame mainFrame;
	Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage mainPage = new MainPage();
					mainPage.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
		//conn = SQLiteConnection.dbConnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 1280, 720);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JLabel lblAdministratorTools = new JLabel("Administrator Tools");
		lblAdministratorTools.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministratorTools.setBounds(841, 76, 296, 60);
		mainFrame.getContentPane().add(lblAdministratorTools);
		
		JButton btnNewButton = new JButton("View Employees");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.setVisible(false);
				ViewEmployees.main(null);
				mainFrame.dispose();
			}
		});
		btnNewButton.setBounds(841, 157, 296, 60);
		mainFrame.getContentPane().add(btnNewButton);
		
		JButton btnAddNewEmploye = new JButton("Add NEW Employe");
		btnAddNewEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.setVisible(false);
				AddEmplyee.main(null);
				mainFrame.dispose();
			}
		});
		btnAddNewEmploye.setBounds(841, 235, 296, 60);
		mainFrame.getContentPane().add(btnAddNewEmploye);
		
		JButton btnRemoveEmploye = new JButton("Remove Employe");
		btnRemoveEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.setVisible(false);
				DeleteEmployee.main(null);
				mainFrame.dispose();
			}
		});
		btnRemoveEmploye.setBounds(841, 313, 296, 60);
		mainFrame.getContentPane().add(btnRemoveEmploye);
		
		JButton btnEditEmployeSchedule = new JButton("Edit Employe Schedule");
		btnEditEmployeSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.setVisible(false);
				ViewEmployees.main(null);
				mainFrame.dispose();
			}
		});
		btnEditEmployeSchedule.setBounds(841, 393, 296, 60);
		mainFrame.getContentPane().add(btnEditEmployeSchedule);
		
		JButton btnEmailStudents = new JButton("Email Students");
		btnEmailStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mainFrame.setVisible(false);
				EmailEmployees.main(null);
				mainFrame.dispose();
			}
		});
		btnEmailStudents.setBounds(841, 474, 296, 60);
		mainFrame.getContentPane().add(btnEmailStudents);
		
		JButton btnScheduleEmployees = new JButton("Schedule Employees");
		btnScheduleEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeScheduler.main(null);
				mainFrame.dispose();
			}
		});
		btnScheduleEmployees.setBounds(114, 474, 603, 60);
		mainFrame.getContentPane().add(btnScheduleEmployees);
		
		JLabel lblCatering = new JLabel("Catering");
		lblCatering.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatering.setBounds(114, 157, 603, 296);
		mainFrame.getContentPane().add(lblCatering);
	}
}
