package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.catering.classes.AvailabilityDAO;
import com.catering.classes.Schedule;
import com.catering.classes.ScheduleDAO;
import com.catering.classes.WeekDAO;

import net.proteanit.sql.DbUtils;

public class EmployeeScheduler {

	private JFrame frame;
	private JTable tableFriday, tableSaturday, tableSunday, tableMonday, tableTuesday, tableWednesday, tableThursday;
	private JTable tableFridayEmpList, tableSaturdayEmpList, tableSundayEmpList, tableMondayEmpList,
			tableTuesdayEmpList, tableWednesdayEmpList, tableThursdayEmpList;
	private JComboBox<String> comboBoxFriday, comboBoxSaturday, comboBoxSunday, comboBoxMonday, comboBoxTuesday,
			comboBoxWednesday, comboBoxThursday;
	private JTabbedPane tabbedPane;
	private java.sql.Date myDate;
	private Calendar cal = Calendar.getInstance();
	private JLabel lblDateFriday, lblDateSaturday, lblDateSunday, lblDateMonday, lblDateTuesday, lblDateWednesday,
			lblDateThursday;
	private int fridayEventID = 0, saturdayEventID = 0, sundayEventID = 0, mondayEventID = 0, tuesdayEventID = 0,
			wednesdayEventID = 0, thursdayEventID = 0;
	private Schedule fridayDel, saturdayDel, sundayDel, mondayDel, tuesdayDel, wednesdayDel, thursdayDel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeScheduler window = new EmployeeScheduler();
					window.frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Please select a date first.");
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
		//pullWeek();
		fillUpTables();

		fillScheduledEmpTable();
		fillDropDown();
		/*
		 * 1. Init 2. Pull dates for 1 week's Schedule (SCDB) 3. Ask if
		 * scheduling scheduling for same week. If yes then load all the data
		 * into days of week. Continue on 6 4. Create New week schedule. - >
		 * Truncate all the events from the current week. 5. Add schedule
		 * details in the SCDB - > truncate SCDB details first.
		 * 
		 * 6. Add event for a day. Take details.
		 */
	}

	private void fillDropDown() {
		fillDropDownDay(comboBoxFriday, "friday");
		fillDropDownDay(comboBoxThursday, "thursday");
		fillDropDownDay(comboBoxSunday, "sunday");
		fillDropDownDay(comboBoxSaturday, "saturday");
		fillDropDownDay(comboBoxMonday, "monday");
		fillDropDownDay(comboBoxTuesday, "tuesday");
		fillDropDownDay(comboBoxWednesday, "wednesday");

	}

	private void fillDropDownDay(JComboBox<String> comboBox, String day) {
		List<String> l = AvailabilityDAO.getAllTimingsForDay(day);
		for (String s : l) {
			comboBox.addItem(s);
		}
	}

	private void fillScheduledEmpTable() {
		String sqlQuerry = "SELECT ScheduleDB.EventID, ScheduleDB.EmployeeID, EmployeeTable.FName, EmployeeTable.LName, ScheduleDB.StartTime, ScheduleDB.EndTIme FROM EmployeeTable, ScheduleDB WHERE Day = ? AND ScheduleDB.EmployeeID == EmployeeTable.EmployeeID AND ScheduleDB.Date ==?";
		showTable(sqlQuerry, tableFridayEmpList, "friday", lblDateFriday.getText());
		showTable(sqlQuerry, tableSaturdayEmpList, "saturday", lblDateSaturday.getText());
		showTable(sqlQuerry, tableSundayEmpList, "sunday", lblDateSunday.getText());
		showTable(sqlQuerry, tableMondayEmpList, "monday", lblDateMonday.getText());
		showTable(sqlQuerry, tableTuesdayEmpList, "tuesday", lblDateTuesday.getText());
		showTable(sqlQuerry, tableWednesdayEmpList, "wednesday", lblDateWednesday.getText());
		showTable(sqlQuerry, tableThursdayEmpList, "thursday", lblDateThursday.getText());

	}

	private void showTable(String sqlQuerry, JTable table, String day, String date) {
		try {
			Connection viewTable = SQLiteConnection.getInstance();

			PreparedStatement stmt = viewTable.prepareStatement(sqlQuerry);
			stmt.setString(1, day.toLowerCase());
			stmt.setDate(2, java.sql.Date.valueOf(date));
			ResultSet rs = stmt.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

			// SQLiteConnection.dbClose();

		} catch (Exception e) {

		} finally {
			// SQLiteConnection.dbClose();
		}
	}

	private void fillUpTables() {
		String sqlQuerry = "SELECT EventID, EventLocation, StartTime, EndTime FROM EventTable WHERE Day = ? AND Date =?";
		showTable(sqlQuerry, tableFriday, "friday", lblDateFriday.getText());
		showTable(sqlQuerry, tableSaturday, "saturday", lblDateSaturday.getText());
		showTable(sqlQuerry, tableSunday, "sunday", lblDateSunday.getText());
		showTable(sqlQuerry, tableMonday, "monday", lblDateMonday.getText());
		showTable(sqlQuerry, tableTuesday, "tuesday", lblDateTuesday.getText());
		showTable(sqlQuerry, tableWednesday, "wednesday", lblDateWednesday.getText());
		showTable(sqlQuerry, tableThursday, "thursday", lblDateThursday.getText());

	}

	private void pullWeek() {
		java.sql.Date[] date = WeekDAO.getWeek();
		//System.out.println(date[0]);
		//System.out.println(date[1]);
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
		datePicker.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//System.out.println(" Action Performed");
				myDate = java.sql.Date.valueOf(datePicker.getJFormattedTextField().getText());
				cal = Calendar.getInstance();
				cal.setTime(myDate);

				// System.out.println(myDate + " myDate");
				if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY) {
					JOptionPane.showMessageDialog(null, "Please select start day as Friday");
				}
				setLabelsToDate();
				fillUpTables();

				fillScheduledEmpTable();

			}

			private void setLabelsToDate() {
				cal.setTime(myDate);

				lblDateFriday.setText(myDate.toString());

				cal.add(Calendar.DAY_OF_YEAR, 1);
				java.sql.Date sqlnextDay = new java.sql.Date(cal.getTimeInMillis());
				lblDateSaturday.setText(sqlnextDay.toString());

				cal.add(Calendar.DAY_OF_YEAR, 1);
				sqlnextDay = new java.sql.Date(cal.getTimeInMillis());
				lblDateSunday.setText(sqlnextDay.toString());

				cal.add(Calendar.DAY_OF_YEAR, 1);
				sqlnextDay = new java.sql.Date(cal.getTimeInMillis());
				lblDateMonday.setText(sqlnextDay.toString());

				cal.add(Calendar.DAY_OF_YEAR, 1);
				sqlnextDay = new java.sql.Date(cal.getTimeInMillis());
				lblDateTuesday.setText(sqlnextDay.toString());

				cal.add(Calendar.DAY_OF_YEAR, 1);
				sqlnextDay = new java.sql.Date(cal.getTimeInMillis());
				lblDateWednesday.setText(sqlnextDay.toString());

				cal.add(Calendar.DAY_OF_YEAR, 1);
				sqlnextDay = new java.sql.Date(cal.getTimeInMillis());
				lblDateThursday.setText(sqlnextDay.toString());

			}
		});

		datePicker.getJFormattedTextField().setText("Date");
		datePicker.setBounds(52, 60, 196, 23);

		frame.getContentPane().add(datePicker);

		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(1124, 11, 116, 47);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.main(new String[] {});
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnBack);

		JButton btnPrintEvents = new JButton("Print Events");
		btnPrintEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplaySchedule.main(new String[]{"Events", lblDateFriday.getText(),
						lblDateSaturday.getText(), lblDateSunday.getText(), lblDateMonday.getText(),
						lblDateTuesday.getText(), lblDateWednesday.getText(), lblDateThursday.getText()});
			}
		});
		btnPrintEvents.setBounds(1041, 582, 199, 66);
		frame.getContentPane().add(btnPrintEvents);

		JButton btnPrintWeek = new JButton("Print Week");
		btnPrintWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplaySchedule.main(new String[]{"Week", lblDateFriday.getText(),
						lblDateSaturday.getText(), lblDateSunday.getText(), lblDateMonday.getText(),
						lblDateTuesday.getText(), lblDateWednesday.getText(), lblDateThursday.getText()});
			}
		});
		btnPrintWeek.setBounds(1041, 494, 199, 66);
		frame.getContentPane().add(btnPrintWeek);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(52, 122, 918, 526);
		frame.getContentPane().add(tabbedPane);

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

		JLabel lblSelectDate = new JLabel("Select Any Friday");
		lblSelectDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectDate.setBounds(52, 11, 193, 37);
		frame.getContentPane().add(lblSelectDate);

		fetchAllEvents(tabbedPane);
	}

	private void fetchAllEvents(JTabbedPane tabbedPane) {
		addDayFriday(tabbedPane);
		addDaySaturday(tabbedPane);
		addDaySunday(tabbedPane);
		addDayMonday(tabbedPane);
		addDayTuesday(tabbedPane);
		addDayWednesday(tabbedPane);
		addDayThursday(tabbedPane);
	}

	private void addDayThursday(JTabbedPane tabbedPane) {

		// --------------Thursday Panel
		JPanel panelThursday = new JPanel();
		tabbedPane.addTab("Thursday", null, panelThursday, null);
		panelThursday.setLayout(null);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		java.sql.Date sqlThursday = new java.sql.Date(cal.getTimeInMillis());
		lblDateThursday = new JLabel(sqlThursday.toString());
		lblDateThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateThursday.setBounds(10, 11, 84, 26);
		panelThursday.add(lblDateThursday);

		tableThursday = new JTable();
		tableThursday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableThursday.getSelectedRow();
				thursdayEventID = (int) tableThursday.getModel().getValueAt(row, 0);

			}
		});
		tableThursday.setBounds(9, 57, 355, 428);
		panelThursday.add(tableThursday);

		tableThursdayEmpList = new JTable();
		tableThursdayEmpList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableThursdayEmpList.getSelectedRow();

				if (row != -1) {
					thursdayDel = new Schedule();

					thursdayDel.setEventID((int) tableThursdayEmpList.getModel().getValueAt(row, 0));

					thursdayDel.setEmployeeID((int) tableThursdayEmpList.getModel().getValueAt(row, 1));
					thursdayDel.setDay("thursday");
					thursdayDel.setStartTime((int) tableThursdayEmpList.getModel().getValueAt(row, 4));
					thursdayDel.setEndTime((int) tableThursdayEmpList.getModel().getValueAt(row, 5));

				}
			}
		});
		tableThursdayEmpList.setBounds(490, 162, 396, 325);
		panelThursday.add(tableThursdayEmpList);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = (String) comboBoxThursday.getSelectedItem();
				String[] line = result.split(" ");
				line[3] = JOptionPane.showInputDialog("Start time : ", line[3]);
				line[4] = JOptionPane.showInputDialog("End time : ", line[4]);
				if(line[3]==null || line[4] == null){
					return;
				}
				Schedule sc = new Schedule();
				sc.setEmployeeID(Integer.parseInt(line[0]));
				sc.setStartTime(Integer.parseInt(line[3]));
				sc.setEndTime(Integer.parseInt(line[4]));
				sc.setEventID(thursdayEventID);
				sc.setDate(java.sql.Date.valueOf(lblDateThursday.getText()));
				sc.setDay("thursday");

				ScheduleDAO.addSchedule(sc);
				fillScheduledEmpTable();

			}
		});
		btnNewButton.setBounds(488, 107, 184, 44);
		panelThursday.add(btnNewButton);

		JButton button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleDAO.removeSchedule(thursdayDel);
				fillScheduledEmpTable();
			}
		});
		button.setBounds(703, 107, 183, 44);
		panelThursday.add(button);

		comboBoxThursday = new JComboBox<String>();
		comboBoxThursday.setBounds(490, 57, 397, 35);
		panelThursday.add(comboBoxThursday);

	}

	private void addDayWednesday(JTabbedPane tabbedPane) {

		// --------------Wednesday Panel
		JPanel panelWednesday = new JPanel();
		tabbedPane.addTab("Wednesday", null, panelWednesday, null);
		panelWednesday.setLayout(null);

		cal.add(Calendar.DAY_OF_YEAR, 1);
		java.sql.Date sqlWednesday = new java.sql.Date(cal.getTimeInMillis());

		lblDateWednesday = new JLabel(sqlWednesday.toString());
		lblDateWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateWednesday.setBounds(10, 11, 84, 26);
		panelWednesday.add(lblDateWednesday);

		tableWednesday = new JTable();
		tableWednesday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableWednesday.getSelectedRow();
				wednesdayEventID = (int) tableWednesday.getModel().getValueAt(row, 0);

			}
		});
		tableWednesday.setBounds(9, 57, 355, 428);
		panelWednesday.add(tableWednesday);

		tableWednesdayEmpList = new JTable();
		tableWednesdayEmpList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableWednesdayEmpList.getSelectedRow();
				if (row != -1) {
					wednesdayDel = new Schedule();

					wednesdayDel.setEventID((int) tableWednesdayEmpList.getModel().getValueAt(row, 0));

					wednesdayDel.setEmployeeID((int) tableWednesdayEmpList.getModel().getValueAt(row, 1));
					wednesdayDel.setDay("wednesday");
					wednesdayDel.setStartTime((int) tableWednesdayEmpList.getModel().getValueAt(row, 4));
					wednesdayDel.setEndTime((int) tableWednesdayEmpList.getModel().getValueAt(row, 5));

				}
			}
		});
		tableWednesdayEmpList.setBounds(490, 162, 396, 325);
		panelWednesday.add(tableWednesdayEmpList);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = (String) comboBoxWednesday.getSelectedItem();
				String[] line = result.split(" ");
				line[3] = JOptionPane.showInputDialog("Start time : ", line[3]);
				line[4] = JOptionPane.showInputDialog("End time : ", line[4]);
				if(line[3]==null || line[4] == null){
					return;
				}
				Schedule sc = new Schedule();
				sc.setEmployeeID(Integer.parseInt(line[0]));
				sc.setStartTime(Integer.parseInt(line[3]));
				sc.setEndTime(Integer.parseInt(line[4]));
				sc.setEventID(wednesdayEventID);
				sc.setDate(java.sql.Date.valueOf(lblDateWednesday.getText()));
				sc.setDay("wednesday");

				ScheduleDAO.addSchedule(sc);
				fillScheduledEmpTable();

			}
		});
		btnNewButton.setBounds(488, 107, 184, 44);
		panelWednesday.add(btnNewButton);

		JButton button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleDAO.removeSchedule(wednesdayDel);
				fillScheduledEmpTable();
			}
		});
		button.setBounds(703, 107, 183, 44);
		panelWednesday.add(button);

		comboBoxWednesday = new JComboBox<String>();
		comboBoxWednesday.setBounds(490, 57, 397, 35);
		panelWednesday.add(comboBoxWednesday);

	}

	private void addDayTuesday(JTabbedPane tabbedPane) {

		// --------------Tuesday Panel
		JPanel panelTuesday = new JPanel();
		tabbedPane.addTab("Tuesday", null, panelTuesday, null);
		panelTuesday.setLayout(null);

		cal.add(Calendar.DAY_OF_YEAR, 1);
		java.sql.Date sqlTuesday = new java.sql.Date(cal.getTimeInMillis());

		lblDateTuesday = new JLabel(sqlTuesday.toString());
		lblDateTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateTuesday.setBounds(10, 11, 84, 26);
		panelTuesday.add(lblDateTuesday);

		tableTuesday = new JTable();
		tableTuesday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableTuesday.getSelectedRow();
				tuesdayEventID = (int) tableTuesday.getModel().getValueAt(row, 0);

			}
		});
		tableTuesday.setBounds(9, 57, 355, 428);
		panelTuesday.add(tableTuesday);

		tableTuesdayEmpList = new JTable();
		tableTuesdayEmpList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableTuesdayEmpList.getSelectedRow();
				// System.out.println("row : "+row);
				if (row != -1) {
					tuesdayDel = new Schedule();

					tuesdayDel.setEventID((int) tableTuesdayEmpList.getModel().getValueAt(row, 0));

					tuesdayDel.setEmployeeID((int) tableTuesdayEmpList.getModel().getValueAt(row, 1));
					tuesdayDel.setDay("tuesday");
					tuesdayDel.setStartTime((int) tableTuesdayEmpList.getModel().getValueAt(row, 4));
					tuesdayDel.setEndTime((int) tableTuesdayEmpList.getModel().getValueAt(row, 5));
				}
			}
		});
		tableTuesdayEmpList.setBounds(490, 162, 396, 325);
		panelTuesday.add(tableTuesdayEmpList);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = (String) comboBoxTuesday.getSelectedItem();
				String[] line = result.split(" ");
				line[3] = JOptionPane.showInputDialog("Start time : ", line[3]);
				line[4] = JOptionPane.showInputDialog("End time : ", line[4]);
				if(line[3]==null || line[4] == null){
					return;
				}
				Schedule sc = new Schedule();
				sc.setEmployeeID(Integer.parseInt(line[0]));
				sc.setStartTime(Integer.parseInt(line[3]));
				sc.setEndTime(Integer.parseInt(line[4]));
				sc.setEventID(tuesdayEventID);
				sc.setDate(java.sql.Date.valueOf(lblDateTuesday.getText()));
				sc.setDay("tuesday");
				ScheduleDAO.addSchedule(sc);
				fillScheduledEmpTable();

			}
		});

		btnNewButton.setBounds(488, 107, 184, 44);
		panelTuesday.add(btnNewButton);

		JButton button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleDAO.removeSchedule(tuesdayDel);
				fillScheduledEmpTable();
			}
		});
		button.setBounds(703, 107, 183, 44);
		panelTuesday.add(button);

		comboBoxTuesday = new JComboBox<String>();
		comboBoxTuesday.setBounds(490, 57, 397, 35);
		panelTuesday.add(comboBoxTuesday);

	}

	private void addDayMonday(JTabbedPane tabbedPane) {
		// --------------Monday Panel
		JPanel panelMonday = new JPanel();
		tabbedPane.addTab("Monday", null, panelMonday, null);
		panelMonday.setLayout(null);

		cal.add(Calendar.DAY_OF_YEAR, 1);
		java.sql.Date sqlMonday = new java.sql.Date(cal.getTimeInMillis());

		lblDateMonday = new JLabel(sqlMonday.toString());
		lblDateMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateMonday.setBounds(10, 11, 84, 26);
		panelMonday.add(lblDateMonday);

		tableMonday = new JTable();
		tableMonday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableMonday.getSelectedRow();
				mondayEventID = (int) tableMonday.getModel().getValueAt(row, 0);

			}
		});
		tableMonday.setBounds(9, 57, 355, 428);
		panelMonday.add(tableMonday);

		tableMondayEmpList = new JTable();
		tableMondayEmpList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableMondayEmpList.getSelectedRow();
				// System.out.println("row : "+row);
				if (row != -1) {
					mondayDel = new Schedule();
					// System.out.println("EventID _-->"+(int)
					// tableFridayEmpList.getModel().getValueAt(row, 0));
					mondayDel.setEventID((int) tableMondayEmpList.getModel().getValueAt(row, 0));
					// System.out.println("EnentID : "+ (int)
					// tableFridayEmpList.getModel().getValueAt(row, 0));
					mondayDel.setEmployeeID((int) tableMondayEmpList.getModel().getValueAt(row, 1));
					mondayDel.setDay("monday");
					mondayDel.setStartTime((int) tableMondayEmpList.getModel().getValueAt(row, 4));
					mondayDel.setEndTime((int) tableMondayEmpList.getModel().getValueAt(row, 5));

					// System.out.println("Here");
				}
			}
		});
		tableMondayEmpList.setBounds(490, 162, 396, 325);
		panelMonday.add(tableMondayEmpList);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = (String) comboBoxMonday.getSelectedItem();
				String[] line = result.split(" ");
				line[3] = JOptionPane.showInputDialog("Start time : ", line[3]);
				line[4] = JOptionPane.showInputDialog("End time : ", line[4]);
				if(line[3]==null || line[4] == null){
					return;
				}
				Schedule sc = new Schedule();
				sc.setEmployeeID(Integer.parseInt(line[0]));
				sc.setStartTime(Integer.parseInt(line[3]));
				sc.setEndTime(Integer.parseInt(line[4]));
				sc.setEventID(mondayEventID);
				sc.setDate(java.sql.Date.valueOf(lblDateMonday.getText()));
				sc.setDay("monday");

				ScheduleDAO.addSchedule(sc);
				fillScheduledEmpTable();

			}
		});
		btnNewButton.setBounds(488, 107, 184, 44);
		panelMonday.add(btnNewButton);

		JButton button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleDAO.removeSchedule(mondayDel);
				fillScheduledEmpTable();
			}
		});
		button.setBounds(703, 107, 183, 44);
		panelMonday.add(button);

		comboBoxMonday = new JComboBox<String>();
		comboBoxMonday.setBounds(490, 57, 397, 35);
		panelMonday.add(comboBoxMonday);

	}

	private void addDaySunday(JTabbedPane tabbedPane) {
		// --------------Sunday Panel
		JPanel panelSunday = new JPanel();
		tabbedPane.addTab("Sunday", null, panelSunday, null);
		panelSunday.setLayout(null);

		cal.add(Calendar.DAY_OF_YEAR, 1);
		java.sql.Date sqlSunday = new java.sql.Date(cal.getTimeInMillis());
		// JLabel lblDateSunday = new JLabel(sqlSaturday.toString());

		lblDateSunday = new JLabel(sqlSunday.toString());
		lblDateSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateSunday.setBounds(10, 11, 84, 26);
		panelSunday.add(lblDateSunday);

		tableSunday = new JTable();
		tableSunday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableSunday.getSelectedRow();
				sundayEventID = (int) tableSunday.getModel().getValueAt(row, 0);
				// System.out.println("EbentID "+fridayEventID);

			}
		});
		tableSunday.setBounds(9, 57, 355, 428);
		panelSunday.add(tableSunday);

		tableSundayEmpList = new JTable();
		tableSundayEmpList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableSundayEmpList.getSelectedRow();

				if (row != -1) {
					sundayDel = new Schedule();

					sundayDel.setEventID((int) tableSundayEmpList.getModel().getValueAt(row, 0));

					sundayDel.setEmployeeID((int) tableSundayEmpList.getModel().getValueAt(row, 1));
					sundayDel.setDay("sunday");
					sundayDel.setStartTime((int) tableSundayEmpList.getModel().getValueAt(row, 4));
					sundayDel.setEndTime((int) tableSundayEmpList.getModel().getValueAt(row, 5));

				}
			}

		});
		tableSundayEmpList.setBounds(490, 162, 396, 325);
		panelSunday.add(tableSundayEmpList);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = (String) comboBoxSunday.getSelectedItem();
				String[] line = result.split(" ");
				line[3] = JOptionPane.showInputDialog("Start time : ", line[3]);
				line[4] = JOptionPane.showInputDialog("End time : ", line[4]);
				if(line[3]==null || line[4] == null){
					return;
				}
				Schedule sc = new Schedule();
				sc.setEmployeeID(Integer.parseInt(line[0]));
				sc.setStartTime(Integer.parseInt(line[3]));
				sc.setEndTime(Integer.parseInt(line[4]));
				sc.setEventID(sundayEventID);
				sc.setDate(java.sql.Date.valueOf(lblDateSunday.getText()));
				sc.setDay("sunday");

				ScheduleDAO.addSchedule(sc);
				fillScheduledEmpTable();

			}
		});

		btnNewButton.setBounds(488, 107, 184, 44);
		panelSunday.add(btnNewButton);

		JButton button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleDAO.removeSchedule(sundayDel);
				fillScheduledEmpTable();
			}
		});
		button.setBounds(703, 107, 183, 44);
		panelSunday.add(button);

		comboBoxSunday = new JComboBox<String>();
		comboBoxSunday.setBounds(490, 57, 397, 35);
		panelSunday.add(comboBoxSunday);

	}

	private void addDaySaturday(JTabbedPane tabbedPane) {
		// --------------Saturday Panel
		JPanel panelSaturday = new JPanel();
		tabbedPane.addTab("Saturday", null, panelSaturday, null);
		panelSaturday.setLayout(null);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		java.sql.Date sqlSaturday = new java.sql.Date(cal.getTimeInMillis());
		lblDateSaturday = new JLabel(sqlSaturday.toString());
		lblDateSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateSaturday.setBounds(10, 11, 84, 26);
		panelSaturday.add(lblDateSaturday);

		tableSaturday = new JTable();
		tableSaturday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableSaturday.getSelectedRow();
				saturdayEventID = (int) tableSaturday.getModel().getValueAt(row, 0);
				// System.out.println("EbentID "+fridayEventID);
			}
		});
		tableSaturday.setBounds(9, 57, 355, 428);
		panelSaturday.add(tableSaturday);

		tableSaturdayEmpList = new JTable();
		tableSaturdayEmpList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableSaturdayEmpList.getSelectedRow();

				if (row != -1) {
					saturdayDel = new Schedule();

					saturdayDel.setEventID((int) tableSaturdayEmpList.getModel().getValueAt(row, 0));

					saturdayDel.setEmployeeID((int) tableSaturdayEmpList.getModel().getValueAt(row, 1));
					saturdayDel.setDay("saturday");
					saturdayDel.setStartTime((int) tableSaturdayEmpList.getModel().getValueAt(row, 4));
					saturdayDel.setEndTime((int) tableSaturdayEmpList.getModel().getValueAt(row, 5));

				}
			}
		});
		tableSaturdayEmpList.setBounds(490, 162, 396, 325);
		panelSaturday.add(tableSaturdayEmpList);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = (String) comboBoxSaturday.getSelectedItem();
				String[] line = result.split(" ");
				line[3] = JOptionPane.showInputDialog("Start time : ", line[3]);
				line[4] = JOptionPane.showInputDialog("End time : ", line[4]);
				if(line[3]==null || line[4] == null){
					return;
				}
				Schedule sc = new Schedule();
				sc.setEmployeeID(Integer.parseInt(line[0]));
				sc.setStartTime(Integer.parseInt(line[3]));
				sc.setEndTime(Integer.parseInt(line[4]));
				sc.setEventID(saturdayEventID);
				sc.setDate(java.sql.Date.valueOf(lblDateSaturday.getText()));
				sc.setDay("saturday");

				ScheduleDAO.addSchedule(sc);
				fillScheduledEmpTable();

			}
		});
		btnNewButton.setBounds(488, 107, 184, 44);
		panelSaturday.add(btnNewButton);

		JButton button = new JButton("REMOVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleDAO.removeSchedule(saturdayDel);
				fillScheduledEmpTable();
			}
		});

		button.setBounds(703, 107, 183, 44);
		panelSaturday.add(button);

		comboBoxSaturday = new JComboBox<String>();
		comboBoxSaturday.setBounds(490, 57, 397, 35);
		panelSaturday.add(comboBoxSaturday);

	}

	private void addDayFriday(JTabbedPane tabbedPane) {
		// ---------------Friday Panel
		JPanel panelFriday = new JPanel();
		tabbedPane.addTab("Friday", null, panelFriday, null);
		panelFriday.setLayout(null);

		java.sql.Date sqlFriday = new java.sql.Date(cal.getTimeInMillis());
		lblDateFriday = new JLabel(sqlFriday.toString());
		lblDateFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateFriday.setBounds(10, 11, 84, 26);
		panelFriday.add(lblDateFriday);

		tableFriday = new JTable();
		tableFriday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableFriday.getSelectedRow();
				fridayEventID = (int) tableFriday.getModel().getValueAt(row, 0);
				
			}
		});
		tableFriday.setBounds(9, 57, 355, 428);
		panelFriday.add(tableFriday);

		tableFridayEmpList = new JTable();
		tableFridayEmpList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableFridayEmpList.getSelectedRow();
				// System.out.println("row : "+row);
				if (row != -1) {
					fridayDel = new Schedule();
					fridayDel.setEventID((int) tableFridayEmpList.getModel().getValueAt(row, 0));
					fridayDel.setEmployeeID((int) tableFridayEmpList.getModel().getValueAt(row, 1));
					fridayDel.setDay("friday");
					fridayDel.setStartTime((int) tableFridayEmpList.getModel().getValueAt(row, 4));
					fridayDel.setEndTime((int) tableFridayEmpList.getModel().getValueAt(row, 5));

					
				}
			}
		});
		tableFridayEmpList.setBounds(490, 162, 396, 325);
		panelFriday.add(tableFridayEmpList);

		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = (String) comboBoxFriday.getSelectedItem();
				String[] line = result.split(" ");
				line[3] = JOptionPane.showInputDialog("Start time : ", line[3]);
				line[4] = JOptionPane.showInputDialog("End time : ", line[4]);
				if(line[3]==null || line[4] == null){
					return;
				}
				Schedule sc = new Schedule();
				sc.setEmployeeID(Integer.parseInt(line[0]));
				sc.setStartTime(Integer.parseInt(line[3]));
				sc.setEndTime(Integer.parseInt(line[4]));
				sc.setEventID(fridayEventID);
				sc.setDate(java.sql.Date.valueOf(lblDateFriday.getText()));
				sc.setDay("friday");

				ScheduleDAO.addSchedule(sc);
				fillScheduledEmpTable();

			}
		});
		btnNewButton.setBounds(488, 107, 184, 44);
		panelFriday.add(btnNewButton);

		JButton button = new JButton("REMOVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleDAO.removeSchedule(fridayDel);
				fillScheduledEmpTable();
			}
		});

		button.setBounds(703, 107, 183, 44);
		panelFriday.add(button);

		comboBoxFriday = new JComboBox<String>();
		comboBoxFriday.setBounds(490, 57, 397, 35);
		panelFriday.add(comboBoxFriday);

	}
}
