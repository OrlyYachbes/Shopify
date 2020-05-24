package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EmpProductsPageView extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTextField textSearch;
	private JButton btnSearch;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpProductsPageView frame = new EmpProductsPageView();
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
	public EmpProductsPageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		textSearch = new JTextField();
		textSearch.setBounds(204, 95, 146, 20);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Products Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(204, 11, 227, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Product ID:");
		lblNewLabel_1.setBounds(204, 70, 129, 14);
		contentPane.add(lblNewLabel_1);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(377, 94, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 124, 452, 252);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	//Action Listeners:
	
	public void addBtnActionListner(ActionListener al) {
		this.btnBack.addActionListener(al);
		this.btnSearch.addActionListener(al);
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
	
	//Other methods:
	
	public void setProductsListToTable(ResultSet rs) {
		this.table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
}
