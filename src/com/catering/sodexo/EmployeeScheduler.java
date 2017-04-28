package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


import com.catering.classes.WeekDAO;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EmployeeScheduler {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeScheduler window = new EmployeeScheduler();
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
	public EmployeeScheduler() {
		
		initialize();
		pullWeek();
		/*
		 * 1. Init
		 * 2. Pull dates for 1 week's Schedule (SCDB)
		 * 3. Ask if scheduling scheduling for same week. If yes then load all the data into days of week. Continue on 6 
		 * 4. Create New week schedule. - > Truncate all the events from the current week.
		 * 5. Add schedule details in the SCDB - > truncate SCDB details first.
		 * 
		 * 6. Add event for a day. Take details.   
		 */
	}

	private void pullWeek() {
		java.sql.Date[] date = WeekDAO.getWeek();
		System.out.println(date[0]);
		System.out.println(date[1]);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		frame.getContentPane().setLayout(null);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setText("Date");
		datePicker.setBounds(52, 60, 196, 23);
		
		frame.getContentPane().add(datePicker);
		 
	
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(1124, 11, 116, 47);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.main(new String[]{});
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnBack);
		
		JButton btnPrintEvents = new JButton("Print Events");
		btnPrintEvents.setBounds(1041, 582, 199, 66);
		frame.getContentPane().add(btnPrintEvents);
		
		JButton btnPrintWeek = new JButton("Print Week");
		btnPrintWeek.setBounds(1041, 494, 199, 66);
		frame.getContentPane().add(btnPrintWeek);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(52, 122, 918, 526);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1024, 469, 230, 3);
		frame.getContentPane().add(separator);
		
		JButton btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEvent.main(null);
				frame.dispose();
			}
		});
		btnDeleteEvent.setBounds(1041, 378, 199, 66);
		frame.getContentPane().add(btnDeleteEvent);
		
		JButton btnEditEvent = new JButton("View / Edit Event");
		btnEditEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewEvents_1.main(null);
				frame.dispose();
			}
		});
		btnEditEvent.setBounds(1041, 285, 199, 66);
		frame.getContentPane().add(btnEditEvent);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEvent.main(null);
				frame.dispose();
			}
		});
		btnAddEvent.setBounds(1041, 194, 199, 66);
		frame.getContentPane().add(btnAddEvent);
		
		JLabel lblSelectDate = new JLabel("Select Date");
		lblSelectDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectDate.setBounds(52, 11, 193, 37);
		frame.getContentPane().add(lblSelectDate);
	}
}
