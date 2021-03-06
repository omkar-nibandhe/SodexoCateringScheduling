package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import com.catering.classes.Event;
import com.catering.classes.EventDAO;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * @author Omkar Nibandhe <br>
 *         May 5, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class ViewEvents_2 {

	private JFrame frame;
	private static int mySrNo;
	private JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	private JTextField textFieldEventNumber;
	private JTextField textFieldStartTime;
	private JTextField textFieldEndTime;
	private JTextField textFieldEventName;
	private JTextField textFieldEventLocation;
	private JFormattedTextField textFieldGuestCount;
	private JRadioButton rdbtnFriday;
	private JRadioButton rdbtnThursday;
	private JRadioButton rdbtnWednesday;
	private JRadioButton rdbtnTuesday;
	private JRadioButton rdbtnMonday;
	private JRadioButton rdbtnSunday;
	private JRadioButton rdbtnSaturday;
	private ButtonGroup dayGroup;
	private JRadioButton rdbtnDisposable;
	private JRadioButton rdbtnChina;
	private ButtonGroup group;
	private Event evt;

	/**
	 * Get the SrNo for the event to be edit.
	 * 
	 * @return Returns the unique int value for event
	 */
	public static int getMySrNo() {
		return mySrNo;
	}

	/**
	 * Set the SrNo for the event to be edit.
	 * 
	 * @param mySrNo
	 *            the unique int value for event
	 */
	public static void setMySrNo(int mySrNo) {
		ViewEvents_2.mySrNo = mySrNo;
	}

	/**
	 * Launch the application.
	 * @param args unused
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEvents_2 window = new ViewEvents_2();
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
	public ViewEvents_2() {
		initialize();
		setData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("View Events");
		evt = new Event();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try{
			Image image1 = ImageIO.read(new File(".\\Resources\\binghamton_bearcats-alternate-2001.png"));
			frame.setIconImage(image1);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);

		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setText("Date");
		datePicker.setBounds(52, 60, 196, 23);

		frame.getContentPane().add(datePicker);
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEvents_1.main(new String[] {});
				frame.dispose();
			}
		});
		btnBack.setBounds(1124, 11, 116, 47);
		frame.getContentPane().add(btnBack);

		JLabel lblEventNumber = new JLabel("Event Number");
		lblEventNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventNumber.setBounds(52, 119, 115, 30);
		frame.getContentPane().add(lblEventNumber);

		JLabel lblEventName = new JLabel("Start Time");
		lblEventName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventName.setBounds(52, 169, 115, 30);
		frame.getContentPane().add(lblEventName);

		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndTime.setBounds(52, 220, 115, 30);
		frame.getContentPane().add(lblEndTime);

		JLabel label_1 = new JLabel("Event Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(52, 273, 115, 30);
		frame.getContentPane().add(label_1);

		JLabel lblEventLocatino = new JLabel("Event Location");
		lblEventLocatino.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventLocatino.setBounds(52, 329, 115, 30);
		frame.getContentPane().add(lblEventLocatino);

		JLabel lblGuestCount = new JLabel("Guest Count");
		lblGuestCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuestCount.setBounds(52, 389, 115, 30);
		frame.getContentPane().add(lblGuestCount);

		group = new ButtonGroup();

		rdbtnDisposable = new JRadioButton("Disposable");
		rdbtnDisposable.setBounds(52, 446, 109, 23);
		frame.getContentPane().add(rdbtnDisposable);

		rdbtnChina = new JRadioButton("China");
		rdbtnChina.setBounds(52, 490, 109, 23);
		frame.getContentPane().add(rdbtnChina);

		group.add(rdbtnDisposable);
		group.add(rdbtnChina);

		textFieldEventNumber = new JTextField();
		textFieldEventNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c)))
					e.consume();
			}
		});
		textFieldEventNumber.setBounds(177, 119, 513, 37);
		frame.getContentPane().add(textFieldEventNumber);
		textFieldEventNumber.setColumns(10);

		textFieldStartTime = new JTextField();
		textFieldStartTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c)))
					e.consume();
			}
		});
		textFieldStartTime.setColumns(10);
		textFieldStartTime.setBounds(177, 169, 513, 37);
		frame.getContentPane().add(textFieldStartTime);

		textFieldEndTime = new JTextField();
		textFieldEndTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c)))
					e.consume();
			}
		});
		textFieldEndTime.setColumns(10);
		textFieldEndTime.setBounds(177, 220, 513, 37);
		frame.getContentPane().add(textFieldEndTime);

		textFieldEventName = new JTextField();
		textFieldEventName.setColumns(10);
		textFieldEventName.setBounds(177, 273, 513, 37);
		frame.getContentPane().add(textFieldEventName);

		textFieldEventLocation = new JTextField();
		textFieldEventLocation.setColumns(10);
		textFieldEventLocation.setBounds(177, 326, 513, 37);
		frame.getContentPane().add(textFieldEventLocation);

		textFieldGuestCount = new JFormattedTextField();
		textFieldGuestCount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c)))
					e.consume();
			}
		});
		textFieldGuestCount.setColumns(10);
		textFieldGuestCount.setBounds(177, 382, 513, 37);
		frame.getContentPane().add(textFieldGuestCount);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Cancel will discard changes. Continue ?");
				if (choice == 0) {
					EmployeeScheduler.main(null);
					frame.dispose();
				}
			}
		});
		btnCancel.setBounds(818, 566, 206, 60);
		frame.getContentPane().add(btnCancel);

		dayGroup = new ButtonGroup();

		rdbtnFriday = new JRadioButton("Friday");
		rdbtnFriday.setBounds(282, 60, 70, 23);
		frame.getContentPane().add(rdbtnFriday);
		dayGroup.add(rdbtnFriday);

		rdbtnSaturday = new JRadioButton("Saturday");
		rdbtnSaturday.setBounds(354, 60, 81, 23);
		frame.getContentPane().add(rdbtnSaturday);
		dayGroup.add(rdbtnSaturday);

		rdbtnSunday = new JRadioButton("Sunday");
		rdbtnSunday.setBounds(455, 60, 70, 23);
		frame.getContentPane().add(rdbtnSunday);
		dayGroup.add(rdbtnSunday);

		rdbtnMonday = new JRadioButton("Monday");
		rdbtnMonday.setBounds(541, 60, 70, 23);
		frame.getContentPane().add(rdbtnMonday);
		dayGroup.add(rdbtnMonday);

		rdbtnTuesday = new JRadioButton("Tuesday");
		rdbtnTuesday.setBounds(613, 60, 77, 23);
		frame.getContentPane().add(rdbtnTuesday);
		dayGroup.add(rdbtnTuesday);

		rdbtnWednesday = new JRadioButton("Wednesday");
		rdbtnWednesday.setBounds(702, 60, 99, 23);
		frame.getContentPane().add(rdbtnWednesday);
		dayGroup.add(rdbtnWednesday);

		rdbtnThursday = new JRadioButton("Thursday");
		rdbtnThursday.setBounds(803, 60, 81, 23);
		frame.getContentPane().add(rdbtnThursday);
		dayGroup.add(rdbtnThursday);

		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldEventNumber.getText().isEmpty()) {
					evt.setEventID(0);
				} else {
					evt.setEventID(Integer.parseInt(textFieldEventNumber.getText()));
				}
				evt.setEventName(textFieldEventName.getText());
				if (textFieldStartTime.getText().isEmpty()) {
					evt.setStartTime(0);
				} else {
					evt.setStartTime(Integer.parseInt(textFieldStartTime.getText()));
				}
				if (textFieldEndTime.getText().isEmpty()) {
					evt.setEndTime(0);
				} else {
					evt.setEndTime(Integer.parseInt(textFieldEndTime.getText()));
				}
				if (textFieldGuestCount.getText().isEmpty()) {
					evt.setGuestCount(0);
				} else {
					evt.setGuestCount(Integer.parseInt(textFieldGuestCount.getText()));
				}
				evt.setIsDisposable(rdbtnDisposable.isSelected());
				evt.setEventLocation(textFieldEventLocation.getText());
				evt.setDate(java.sql.Date.valueOf(datePicker.getJFormattedTextField().getText()));
				evt.setDay(dayChoose());
				// System.out.println("Day : "+evt.getDay());
				evt.setSrNo(getMySrNo());

				EventDAO.updateEvent(evt);
				JOptionPane.showMessageDialog(null, "Event Saved");
				EmployeeScheduler.main(null);
				frame.dispose();
			}

			/**
			 * Method to save day on the basis of day selected from the radio
			 * button.
			 * 
			 * @return
			 */
			private String dayChoose() {
				if (rdbtnFriday.isSelected())
					return new String("friday");
				if (rdbtnSaturday.isSelected())
					return new String("saturday");
				if (rdbtnSunday.isSelected())
					return new String("sunday");
				if (rdbtnMonday.isSelected())
					return new String("sunday");
				if (rdbtnTuesday.isSelected())
					return new String("tuesday");
				if (rdbtnWednesday.isSelected())
					return new String("wednesday");
				if (rdbtnThursday.isSelected())
					return new String("thursday");
				return null;
			}
		});
		btnSave.setBounds(1034, 566, 206, 60);
		frame.getContentPane().add(btnSave);

	}

	/**
	 * Method to set the date
	 */
	private void setData() {
		Event e = EventDAO.fetchEvent(getMySrNo());

		textFieldEventNumber.setText(Integer.toString(e.getEventID()));
		textFieldEventName.setText(e.getEventName());
		textFieldStartTime.setText(Integer.toString(e.getStartTime()));
		textFieldEndTime.setText(Integer.toString(e.getEndTime()));
		textFieldGuestCount.setText(Integer.toString(e.getGuestCount()));
		textFieldEventLocation.setText((e.getEventLocation()));

		if (e.getIsDisposable()) {
			rdbtnDisposable.setSelected(true);
		} else {
			rdbtnChina.setSelected(true);
		}

		setDay(e.getDay());
		evt.setDate(e.getDate());
		setDate(e.getDate());

	}

	/**
	 * Method to set the Date for the event. Forces user for viewing proper
	 * week.
	 * 
	 * @param date
	 *            java.sql.Date object
	 */
	private void setDate(Date date) {
		// TODO Auto-generated method stub
		if (date == null) {
			JOptionPane.showMessageDialog(null, "Please Enter Date.");
			evt.setDate(null);
			return;
		}
		evt.setDate(date);
		// SdatePicker.getJFormattedTextField().setValue(date);
		datePicker.getJFormattedTextField().setText(date.toString());

	}

	/**
	 * Set the radio button for the day.
	 * 
	 * @param day
	 *            string representation of the day in lower case.
	 */
	private void setDay(String day) {
		// TODO Auto-generated method stub
		if (day.equalsIgnoreCase("friday"))
			rdbtnFriday.setSelected(true);
		else if (day.equalsIgnoreCase("saturday")) {
			rdbtnSaturday.setSelected(true);
		} else if (day.equalsIgnoreCase("sunday")) {
			rdbtnSunday.setSelected(true);
		} else if (day.equalsIgnoreCase("monday")) {
			rdbtnMonday.setSelected(true);
		} else if (day.equalsIgnoreCase("tuesday")) {
			rdbtnTuesday.setSelected(true);
		} else if (day.equalsIgnoreCase("wednesday")) {
			rdbtnWednesday.setSelected(true);
		} else if (day.equalsIgnoreCase("thursday")) {
			rdbtnThursday.setSelected(true);
		}

	}

}
