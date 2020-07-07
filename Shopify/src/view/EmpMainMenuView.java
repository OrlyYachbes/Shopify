package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EmpMainMenuView extends JFrame {

	private JPanel contentPane;
	private JButton btnProductsPage;
	private JButton btnOrdersPage;
	private JButton btnLogOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpMainMenuView frame = new EmpMainMenuView();
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
	public EmpMainMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Main Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(168, 32, 304, 54);
		contentPane.add(lblNewLabel);
		
		btnProductsPage = new JButton("Products Page");
		btnProductsPage.setBounds(369, 332, 118, 23);
		contentPane.add(btnProductsPage);
		
		btnOrdersPage = new JButton("Orders Page");
		btnOrdersPage.setBounds(157, 332, 118, 23);
		contentPane.add(btnOrdersPage);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(10, 11, 89, 23);
		contentPane.add(btnLogOut);
	}
	
	
	//Methods:
	public void addBtnAl(ActionListener al) {
		
		this.btnProductsPage.addActionListener(al);
		this.btnOrdersPage.addActionListener(al);
		this.btnLogOut.addActionListener(al);	
		
	}

	public JButton getBtnProductsPage() {
		return btnProductsPage;
	}

	public JButton getBtnOrdersPage() {
		return btnOrdersPage;
	}


	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	
	
	
}
