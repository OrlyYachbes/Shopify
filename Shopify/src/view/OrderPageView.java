package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

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
	private DefaultTableModel model;
	private JButton btnRemove;

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
		
		model = new DefaultTableModel(); 
		tableOrderList = new JTable(model);
		
		model.addColumn("Product id"); 
		model.addColumn("Quantity");
		
		scrollPane_1.setViewportView(tableOrderList);
		
		JLabel lblNewLabel_3 = new JLabel("Products List:");
		lblNewLabel_3.setBounds(22, 77, 105, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Order List:");
		lblNewLabel_4.setBounds(378, 77, 84, 14);
		contentPane.add(lblNewLabel_4);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(507, 61, 89, 23);
		contentPane.add(btnRemove);
		
		tableProductsList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = tableProductsList.getSelectedRow();
				
				String id = tableProductsList.getModel().getValueAt(row, 0).toString();
				textProductdId.setText(id);
				textProductQuantity.setText("");
			}
		});
	}
	
	//getters and setters:
	public String getId() {
		return textProductdId.getText();
	}
	
	public String getQuantity() {
		return textProductQuantity.getText();
	}
	
	//Methods:
	public void addBtnAl(ActionListener al) {
		
		this.btnPlaceOrder.addActionListener(al);
		this.btnAdd.addActionListener(al);
		this.btnBack.addActionListener(al);
		this.btnRemove.addActionListener(al);
		
	}
	
	public void addTextFieldAl(DocumentListener dl) {
		this.textProductQuantity.getDocument().addDocumentListener(dl);
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
	public JButton getBtnRemove() {
		return btnRemove;
	}
	
	
	//Other methods:
	
	public void setProductsListToTable(ResultSet rs) {
		this.tableProductsList.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void addToOrderList() {
		
		
		String id = textProductdId.getText();
		String quantity = textProductQuantity.getText();
		
		model.addRow(new Object[]{id, quantity});
	}
	
	public void displayMessage(String msg) {
		JOptionPane.showMessageDialog(this,msg);
	}
	
	public void clearTable() {
		DefaultTableModel model = (DefaultTableModel) tableOrderList.getModel();
		model.setRowCount(0);
	}
	
	public void clearQuantityTextField(){
		this.textProductQuantity.setText("");
	}
	
	public void removeSelctedRowFromOrderList() {
		
		DefaultTableModel model = (DefaultTableModel) tableOrderList.getModel();
		
		try {
			int row = tableOrderList.getSelectedRow();
			model.removeRow(row);
		}catch(Exception e){
			
		}

	}
}
