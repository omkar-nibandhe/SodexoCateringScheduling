package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import com.catering.classes.Event;
import com.catering.classes.EventDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Omkar Nibandhe <br>
 * 		May 5, 2017 <br>
 * 		https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class AddEvent {

	private JFrame frame;
	private JTextField textFieldEventNumber;
	private JTextField textFieldStartTime;
	private JTextField textFieldEndTime;
	private JTextField textFieldEventName;
	private JTextField textFieldEventLocation;
	private JFormattedTextField textFieldGuestCount;

	/**
	 * Launch the application.
	 *
	 * @param args
	 *            Usually null. Unused
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEvent window = new AddEvent();
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
	public AddEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setText("Date");
		datePicker.setBounds(52, 60, 196, 23);

		frame.getContentPane().add(datePicker);
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeScheduler.main(null);
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

		ButtonGroup group = new ButtonGroup();

		JRadioButton rdbtnDisposable = new JRadioButton("Disposable");
		rdbtnDisposable.setBounds(52, 446, 109, 23);
		frame.getContentPane().add(rdbtnDisposable);

		JRadioButton rdbtnChina = new JRadioButton("China");
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
					MainPage.main(null);
					frame.dispose();
				}
			}
		});
		btnCancel.setBounds(818, 566, 206, 60);
		frame.getContentPane().add(btnCancel);

		ButtonGroup dayGroup = new ButtonGroup();

		JRadioButton rdbtnFriday = new JRadioButton("Friday");
		rdbtnFriday.setBounds(282, 60, 70, 23);
		frame.getContentPane().add(rdbtnFriday);
		dayGroup.add(rdbtnFriday);

		JRadioButton rdbtnSaturday = new JRadioButton("Saturday");
		rdbtnSaturday.setBounds(354, 60, 81, 23);
		frame.getContentPane().add(rdbtnSaturday);
		dayGroup.add(rdbtnSaturday);

		JRadioButton rdbtnSunday = new JRadioButton("Sunday");
		rdbtnSunday.setBounds(455, 60, 70, 23);
		frame.getContentPane().add(rdbtnSunday);
		dayGroup.add(rdbtnSunday);

		JRadioButton rdbtnMonday = new JRadioButton("Monday");
		rdbtnMonday.setBounds(541, 60, 70, 23);
		frame.getContentPane().add(rdbtnMonday);
		dayGroup.add(rdbtnMonday);

		JRadioButton rdbtnTuesday = new JRadioButton("Tuesday");
		rdbtnTuesday.setBounds(613, 60, 77, 23);
		frame.getContentPane().add(rdbtnTuesday);
		dayGroup.add(rdbtnTuesday);

		JRadioButton rdbtnWednesday = new JRadioButton("Wednesday");
		rdbtnWednesday.setBounds(702, 60, 99, 23);
		frame.getContentPane().add(rdbtnWednesday);
		dayGroup.add(rdbtnWednesday);

		JRadioButton rdbtnThursday = new JRadioButton("Thursday");
		rdbtnThursday.setBounds(803, 60, 81, 23);
		frame.getContentPane().add(rdbtnThursday);
		dayGroup.add(rdbtnThursday);

		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event evt = new Event();

				evt.setEventID(Integer.parseInt(textFieldEventNumber.getText()));
				evt.setEventName(textFieldEventName.getText());
				evt.setStartTime(Integer.parseInt(textFieldStartTime.getText()));
				evt.setEndTime(Integer.parseInt(textFieldEndTime.getText()));
				evt.setGuestCount(Integer.parseInt(textFieldGuestCount.getText()));
				evt.setIsDisposable(rdbtnDisposable.isSelected());
				evt.setEventLocation(textFieldEventLocation.getText());
				evt.setDate((java.sql.Date.valueOf(datePicker.getModel().getValue().toString())));
				evt.setDay(dayChoose(evt.getDate()));

				EventDAO.addEvent(evt);
				JOptionPane.showMessageDialog(null, "Event Saved");
				EmployeeScheduler.main(null);
				frame.dispose();
			}

			private String dayChoose(Date date) {
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				switch (c.get(Calendar.DAY_OF_WEEK)) {
				case Calendar.SUNDAY:
					return new String("sunday");

				case Calendar.MONDAY:
					return new String("monday");

				case Calendar.TUESDAY:
					return new String("tuesday");

				case Calendar.WEDNESDAY:
					return new String("wednesday");

				case Calendar.THURSDAY:
					return new String("thursday");
				case Calendar.FRIDAY:
					return new String("friday");
				case Calendar.SATURDAY:
					return new String("saturday");
				}

				return null;
			}
		});
		btnSave.setBounds(1034, 566, 206, 60);
		frame.getContentPane().add(btnSave);

	}
}
