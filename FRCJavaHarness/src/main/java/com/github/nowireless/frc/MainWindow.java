package com.github.nowireless.frc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnStart = new JButton("Start");
		springLayout.putConstraint(SpringLayout.NORTH, btnStart, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnStart, 0, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnStart);
		
		JButton btnEnable = new JButton("Enable");
		springLayout.putConstraint(SpringLayout.NORTH, btnEnable, 6, SpringLayout.SOUTH, btnStart);
		springLayout.putConstraint(SpringLayout.WEST, btnEnable, 0, SpringLayout.WEST, btnStart);
		frame.getContentPane().add(btnEnable);
		
		JButton btnTeleop = new JButton("Teleop");
		springLayout.putConstraint(SpringLayout.NORTH, btnTeleop, 6, SpringLayout.SOUTH, btnEnable);
		springLayout.putConstraint(SpringLayout.WEST, btnTeleop, 0, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnTeleop);
	}
}
