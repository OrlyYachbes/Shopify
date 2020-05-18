package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LogInView extends JFrame {

	private JPanel contentPane;
	private JTextField textFielduserName;
	private JPasswordField passwordField;
	private JButton btnNewButtonLogIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInView frame = new LogInView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(230, 11, 183, 52);
		contentPane.add(lblNewLabel);
		
		textFielduserName = new JTextField();
		textFielduserName.setBounds(266, 116, 86, 20);
		contentPane.add(textFielduserName);
		textFielduserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(266, 165, 86, 20);
		contentPane.add(passwordField);
		
		JLabel labelUserName = new JLabel("username:");
		labelUserName.setBounds(197, 119, 68, 14);
		contentPane.add(labelUserName);
		
		JLabel labelPassword = new JLabel("password:");
		labelPassword.setBounds(202, 168, 63, 14);
		contentPane.add(labelPassword);
		
		btnNewButtonLogIn = new JButton("Login");
		btnNewButtonLogIn.setBounds(266, 234, 89, 23);
		contentPane.add(btnNewButtonLogIn);
	}
	
	//Methods:
	public String getUserName() {
		return this.textFielduserName.getText();
	}
	
	public String getPass() {
		//implement
		return "";
	}
	
	public void displayMessage(String msg) {
		//implement	
	}
	
	public void setLogInAL(ActionListener actionListener) {
		this.btnNewButtonLogIn.addActionListener(actionListener);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	