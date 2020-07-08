package view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;



public class ManagerEmployeesPageView extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField textSearch;
	private JButton btnSearch;
	private JTable table;
	private JTextField textFieldEmpId;
	private JTextField textFieldEmpFirstName;
	private JTextField textFieldEmpLastName;
	private JTextField textFieldPassword;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClearButton;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerProductsPageView frame = new ManagerProductsPageView();
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
	
	public ManagerEmployeesPageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		textSearch = new JTextField();
		textSearch.setBounds(182, 88, 146, 20);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Employees Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(204, 11, 227, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Employee ID:");
		lblNewLabel_1.setBounds(182, 63, 129, 14);
		contentPane.add(lblNewLabel_1);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(355, 87, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 125, 534, 284);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textFieldEmpId = new JTextField();
		textFieldEmpId.setBounds(599, 154, 86, 20);
		contentPane.add(textFieldEmpId);
		textFieldEmpId.setColumns(10);
		
		textFieldEmpFirstName = new JTextField();
		textFieldEmpFirstName.setBounds(599, 195, 86, 20);
		contentPane.add(textFieldEmpFirstName);
		textFieldEmpFirstName.setColumns(10);
		
		textFieldEmpLastName = new JTextField();
		textFieldEmpLastName.setBounds(599, 237, 86, 20);
		contentPane.add(textFieldEmpLastName);
		textFieldEmpLastName.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(599, 275, 86, 20);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setBounds(599, 178, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Id:");
		lblNewLabel_3.setBounds(599, 139, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Last Name:");
		lblNewLabel_4.setBounds(599, 219, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password:");
		lblNewLabel_5.setBounds(599, 257, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(102, 420, 89, 23);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(262, 420, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(413, 420, 89, 23);
		contentPane.add(btnDelete);
		
		btnClearButton = new JButton("Clear");
		btnClearButton.setBounds(599, 306, 86, 20);
		contentPane.add(btnClearButton);
		
		
		table.addMouseListener(new MouseListener() {
			 
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow(); 
				
				
				String id = table.getModel().getValueAt(row, 0).toString(); 
				textFieldEmpId.setText(id); 
				String firstName = table.getModel().getValueAt(row, 1).toString();
				textFieldEmpFirstName.setText(firstName);
				String lastName = table.getModel().getValueAt(row, 2).toString();
				textFieldEmpLastName.setText(lastName);
				String password = table.getModel().getValueAt(row, 3).toString();
				textFieldPassword.setText(password);
				
				
				
			}
		});
	}
	
	
	//Action Listeners:
	public void addBtnActionListner(ActionListener al) { // יצרנו מתודת הוספת ליסינרים לכפתורים
		
		this.btnBack.addActionListener(al);
		this.btnSearch.addActionListener(al);
		this.btnAdd.addActionListener(al);
		this.btnDelete.addActionListener(al);
		this.btnUpdate.addActionListener(al);
		this.btnClearButton.addActionListener(al);
	
	}
	
	
	//Getters and setters:
	
	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}
	
	public String getSearchText() {
		return this.textSearch.getText();
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}
	
	
	public String getTextSearch() {
		return textSearch.getText();
	}

	
	public String getTextFieldEmpId() {
		return textFieldEmpId.getText();
	}

	public String getTextFieldEmpFirstName() {
		return textFieldEmpFirstName.getText();
	}

	public String getTextFieldEmpLastName() {
		return textFieldEmpLastName.getText();
	}

	public String getTextFieldPassword() {
		return textFieldPassword.getText();
	}
	public JButton getBtnClear() {
		return btnClearButton;
	}

	
	
	//Other methods:
	
	
	public void setEmployeesListToTable(ResultSet rs) {
		this.table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void displayMassage(String msg) {
		JOptionPane.showMessageDialog(this,msg);
	}
	
	public void clearFields() {
		this.textFieldEmpFirstName.setText("");
		this.textFieldEmpId.setText("");
		this.textFieldEmpLastName.setText("");
		this.textFieldPassword.setText("");
	}
}
