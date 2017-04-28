package com.catering.sodexo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class EditEmplyee {

	private JFrame frame;
	private JTextField textField;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	private JTextField textFieldState;
	private JTextField textFieldZip;
	private JLabel lblAvaliability;
	private JLabel lblMonday;
	private JLabel lblTuesday;
	private JLabel lblWednesday;
	private JLabel lblThursday;
	private JLabel lblFriday;
	private JLabel lblSaturday;
	private JLabel lblSunday;
	private JTextField textFieldMonday;
	private JTextField textFieldTuesday;
	private JTextField textFieldWednesday;
	private JTextField textFieldThursday;
	private JTextField textFieldFriday;
	private JTextField textFieldSaturday;
	private JTextField textFieldSunday;
	private JButton AddButton;
	private JButton EditButton;
	private JButton DeleteButton;
	private JButton SaveButton;
	private JButton CancelButton;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmplyee window = new EditEmplyee();
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
	public EditEmplyee() {
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
		
		textField = new JTextField();
		textField.setBounds(70, 11, 706, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBounds(820, 11, 204, 47);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setBounds(70, 115, 88, 34);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setBounds(513, 115, 88, 34);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(70, 160, 88, 34);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(513, 160, 88, 34);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(70, 213, 88, 34);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setBounds(70, 263, 88, 34);
		frame.getContentPane().add(lblState);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setHorizontalAlignment(SwingConstants.CENTER);
		lblZip.setBounds(513, 263, 88, 34);
		frame.getContentPane().add(lblZip);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(186, 115, 305, 34);
		frame.getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(634, 115, 305, 34);
		frame.getContentPane().add(textFieldLastName);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(186, 167, 305, 34);
		frame.getContentPane().add(textFieldEmail);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(634, 167, 305, 34);
		frame.getContentPane().add(textFieldPhone);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(186, 220, 753, 34);
		frame.getContentPane().add(textFieldAddress);
		
		textFieldState = new JTextField();
		textFieldState.setColumns(10);
		textFieldState.setBounds(186, 270, 305, 34);
		frame.getContentPane().add(textFieldState);
		
		textFieldZip = new JTextField();
		textFieldZip.setColumns(10);
		textFieldZip.setBounds(634, 270, 305, 34);
		frame.getContentPane().add(textFieldZip);
		
		lblAvaliability = new JLabel("AVAILABILITY");
		lblAvaliability.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvaliability.setBounds(70, 329, 88, 34);
		frame.getContentPane().add(lblAvaliability);
		
		lblMonday = new JLabel("Monday");
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setBounds(70, 374, 88, 34);
		frame.getContentPane().add(lblMonday);
		
		lblTuesday = new JLabel("Tuesday");
		lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuesday.setBounds(70, 412, 88, 34);
		frame.getContentPane().add(lblTuesday);
		
		lblWednesday = new JLabel("Wednesday");
		lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblWednesday.setBounds(70, 451, 88, 34);
		frame.getContentPane().add(lblWednesday);
		
		lblThursday = new JLabel("Thursday");
		lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblThursday.setBounds(70, 492, 88, 34);
		frame.getContentPane().add(lblThursday);
		
		lblFriday = new JLabel("Friday");
		lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriday.setBounds(70, 535, 88, 34);
		frame.getContentPane().add(lblFriday);
		
		lblSaturday = new JLabel("Saturday");
		lblSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaturday.setBounds(70, 580, 88, 34);
		frame.getContentPane().add(lblSaturday);
		
		lblSunday = new JLabel("Sunday");
		lblSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lblSunday.setBounds(70, 625, 88, 34);
		frame.getContentPane().add(lblSunday);
		
		textFieldMonday = new JTextField();
		textFieldMonday.setBounds(186, 374, 753, 34);
		frame.getContentPane().add(textFieldMonday);
		textFieldMonday.setColumns(10);
		
		textFieldTuesday = new JTextField();
		textFieldTuesday.setColumns(10);
		textFieldTuesday.setBounds(186, 412, 753, 34);
		frame.getContentPane().add(textFieldTuesday);
		
		textFieldWednesday = new JTextField();
		textFieldWednesday.setColumns(10);
		textFieldWednesday.setBounds(186, 451, 753, 34);
		frame.getContentPane().add(textFieldWednesday);
		
		textFieldThursday = new JTextField();
		textFieldThursday.setColumns(10);
		textFieldThursday.setBounds(186, 492, 753, 34);
		frame.getContentPane().add(textFieldThursday);
		
		textFieldFriday = new JTextField();
		textFieldFriday.setColumns(10);
		textFieldFriday.setBounds(186, 537, 753, 34);
		frame.getContentPane().add(textFieldFriday);
		
		textFieldSaturday = new JTextField();
		textFieldSaturday.setColumns(10);
		textFieldSaturday.setBounds(186, 581, 753, 34);
		frame.getContentPane().add(textFieldSaturday);
		
		textFieldSunday = new JTextField();
		textFieldSunday.setColumns(10);
		textFieldSunday.setBounds(186, 625, 753, 34);
		frame.getContentPane().add(textFieldSunday);
		
		AddButton = new JButton("ADD Employee");
		AddButton.setBounds(989, 406, 116, 47);
		frame.getContentPane().add(AddButton);
		
		EditButton = new JButton("EDIT Employee");
		EditButton.setBounds(1124, 406, 116, 47);
		frame.getContentPane().add(EditButton);
		
		DeleteButton = new JButton("DELETE Employee");
		DeleteButton.setBounds(989, 574, 251, 47);
		frame.getContentPane().add(DeleteButton);
		
		SaveButton = new JButton("SAVE");
		SaveButton.setBounds(1124, 486, 116, 47);
		frame.getContentPane().add(SaveButton);
		
		CancelButton = new JButton("CANCEL");
		CancelButton.setBounds(989, 486, 116, 47);
		frame.getContentPane().add(CancelButton);
		
		separator = new JSeparator();
		separator.setBounds(10, 329, 1230, 2);
		frame.getContentPane().add(separator);
	}
}
