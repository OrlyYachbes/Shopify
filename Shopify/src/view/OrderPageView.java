package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
		setBounds(100, 100, 886, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(374, 30, 166, 40);
		contentPane.add(lblNewLabel);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(755, 325, 105, 23);
		contentPane.add(btnAdd);
		
		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(755, 359, 105, 23);
		contentPane.add(btnPlaceOrder);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(22, 11, 89, 23);
		contentPane.add(btnBack);
		
		textProductdId = new JTextField();
		textProductdId.setEditable(false);
		textProductdId.setBounds(640, 326, 86, 20);
		contentPane.add(textProductdId);
		textProductdId.setColumns(10);
		
		textProductQuantity = new JTextField();
		textProductQuantity.setBounds(640, 360, 86, 20);
		contentPane.add(textProductQuantity);
		textProductQuantity.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Product Id:");
		lblNewLabel_1.setBounds(639, 312, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity:");
		lblNewLabel_2.setBounds(640, 345, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 95, 607, 287);
		contentPane.add(scrollPane);
		
		tableProductsList = new JTable();
		scrollPane.setViewportView(tableProductsList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(640, 95, 220, 206);
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
		lblNewLabel_4.setBounds(642, 77, 84, 14);
		contentPane.add(lblNewLabel_4);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(771, 61, 89, 23);
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
	
	public String getIdFromOrder() {
		int row = tableOrderList.getSelectedRow();
		return tableOrderList.getModel().getValueAt(row, 0).toString();
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
		this.tableProductsList.getColumnModel().getColumn(1).setPreferredWidth(93);
		this.tableProductsList.getColumnModel().getColumn(6).setPreferredWidth(97);
		this.tableProductsList.getColumnModel().getColumn(2).setPreferredWidth(50);
		this.tableProductsList.getColumnModel().getColumn(7).setPreferredWidth(50);
		this.tableProductsList.getColumnModel().getColumn(8).setPreferredWidth(50);
		this.tableProductsList.getColumnModel().getColumn(9).setPreferredWidth(97);
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
	
	public boolean quantityValidationCheck() {
		String quantity = this.getQuantity();
		
		try {
			int num = Integer.parseInt(quantity);
			if(num >= 0) {
				return true;
			}else
				return false;
		}catch(Exception e) {
			return false;
		}
			 
	}
	
	public void removeDuplicatesFromOrderTable(String id) {
		int rowCount = tableOrderList.getRowCount();
		TableModel model = tableOrderList.getModel();
		DefaultTableModel modelToRemoveFrom = (DefaultTableModel)tableOrderList.getModel();
		for(int i=0; i<rowCount; i++) {
			if(model.getValueAt(i, 0).toString().equals(id)) {
				modelToRemoveFrom.removeRow(i);
				return;
			}
		}
	}
}
