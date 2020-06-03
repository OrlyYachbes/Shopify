package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ManagerMainMenuView extends JFrame {

	private JPanel contentPane;
	private JButton btnProductPage;
	private JButton btnOrderPage;
	private JButton btnChangePass;
	private JButton btnEditUser;
	private JButton btnLogOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMainMenuView frame = new ManagerMainMenuView();
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
	public ManagerMainMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager Main Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(180, 31, 286, 75);
		contentPane.add(lblNewLabel);
		
		btnProductPage = new JButton("Product Page");
		btnProductPage.setBounds(478, 341, 118, 23);
		contentPane.add(btnProductPage);
		
		btnOrderPage = new JButton("Order Page");
		btnOrderPage.setBounds(336, 341, 118, 23);
		contentPane.add(btnOrderPage);
		
		btnChangePass = new JButton("Change Pass");
		btnChangePass.setBounds(180, 341, 133, 23);
		contentPane.add(btnChangePass);
		
		btnEditUser = new JButton("Edit User");
		btnEditUser.setBounds(66, 341, 89, 23);
		contentPane.add(btnEditUser);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(21, 31, 89, 23);
		contentPane.add(btnLogOut);
	}
	
	//Methods:
	
	public void addBtnAl(ActionListener al) {
		
		this.btnProductPage.addActionListener(al);
		this.btnOrderPage.addActionListener(al);
		this.btnChangePass.addActionListener(al);
		this.btnLogOut.addActionListener(al);	
		this.btnEditUser.addActionListener(al);
	}

	public JButton getBtnProductPage() {
		return btnProductPage;
	}

	public JButton getBtnOrderPage() {
		return btnOrderPage;
	}

	public JButton getBtnChangePass() {
		return btnChangePass;
	}

	public JButton getBtnEditUser() {
		return btnEditUser;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	
}
