package com.catering.sodexo;

import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * @author Omkar Nibandhe <br>
 *         May 5, 2017 <br>
 *         https://www.linkedin.com/in/omkarnibandhe
 * @version 1.0
 */
public class EmailEmployees {

	private JFrame frame;

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
					EmailEmployees window = new EmailEmployees();
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
	public EmailEmployees() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Email Employees");
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
	}

}
