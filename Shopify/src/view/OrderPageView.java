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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class OrderPageView extends JFrame {

	private JPanel contentPane;
	private JButton btnPlaceOrder;
	private JButton btnAdd;
	private JButton btnBack;
	private JTextField textProductdId;
	private JTextField textProductQuantity;
	private JTable tableProductsList;
	private JTable tableOrderList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPageView frame = new OrderPageView();
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
	public OrderPageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(228, 33, 166, 40);
		contentPane.add(lblNewLabel);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(491, 325, 105, 23);
		contentPane.add(btnAdd);
		
		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(491, 359, 105, 23);
		contentPane.add(btnPlaceOrder);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(22, 11, 89, 23);
		contentPane.add(btnBack);
		
		textProductdId = new JTextField();
		textProductdId.setEditable(false);
		textProductdId.setBounds(376, 326, 86, 20);
		contentPane.add(textProductdId);
		textProductdId.setColumns(10);
		
		textProductQuantity = new JTextField();
		textProductQuantity.setBounds(376, 360, 86, 20);
		contentPane.add(textProductQuantity);
		textProductQuantity.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Product Id:");
		lblNewLabel_1.setBounds(375, 312, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity:");
		lblNewLabel_2.setBounds(376, 345, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 95, 303, 287);
		contentPane.add(scrollPane);
		
		tableProductsList = new JTable();
		scrollPane.setViewportView(tableProductsList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 95, 220, 206);
		contentPane.add(scrollPane_1);
		
		tableOrderList = new JTable();
		scrollPane_1.setViewportView(tableOrderList);
		
		JLabel lblNewLabel_3 = new JLabel("Products List:");
		lblNewLabel_3.setBounds(22, 77, 105, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Order List:");
		lblNewLabel_4.setBounds(378, 77, 84, 14);
		contentPane.add(lblNewLabel_4);
	}
	
	//Methods:
	public void addBtnAl(ActionListener al) {
		
		this.btnPlaceOrder.addActionListener(al);
		this.btnAdd.addActionListener(al);
		this.btnBack.addActionListener(al);
		
	}

	public JButton getBtnPlaceOrder() {
		return btnPlaceOrder;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnBack() {
		return btnBack;
	}
	
	


}
