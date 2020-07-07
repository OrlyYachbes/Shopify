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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;


public class ManagerProductsPageView extends JFrame {

    private JPanel contentPane;
	private JButton btnBack;
	private JTextField textSearch;
	private JButton btnSearch;
	private JTable table;
	private JTextField textFieldItemId;
	private JTextField textFieldItemName;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTextField textFieldNeckShape;
	private JTextField textFieldSize;
	private JTextField textFieldForm;
	private JComboBox comboBoxSleeve;
	private JComboBox comboBoxCategory;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JCheckBox CheckBoxGoldFilled;

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
	public ManagerProductsPageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		textSearch = new JTextField();
		textSearch.setBounds(224, 88, 146, 20);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Products Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(259, 11, 227, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Product ID:");
		lblNewLabel_1.setBounds(224, 63, 129, 14);
		contentPane.add(lblNewLabel_1);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(397, 87, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 125, 632, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textFieldItemId = new JTextField();
		textFieldItemId.setBounds(667, 26, 86, 20);
		contentPane.add(textFieldItemId);
		textFieldItemId.setColumns(10);
		
		textFieldItemName = new JTextField();
		textFieldItemName.setBounds(667, 67, 86, 20);
		contentPane.add(textFieldItemName);
		textFieldItemName.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(667, 109, 86, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(667, 147, 86, 20);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		textFieldNeckShape = new JTextField();
		textFieldNeckShape.setBounds(667, 270, 86, 20);
		contentPane.add(textFieldNeckShape);
		textFieldNeckShape.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(667, 50, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Id:");
		lblNewLabel_3.setBounds(667, 11, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price:");
		lblNewLabel_4.setBounds(667, 91, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity:");
		lblNewLabel_5.setBounds(667, 129, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Category:");
		lblNewLabel_6.setBounds(667, 172, 65, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sleeve:");
		lblNewLabel_7.setBounds(667, 209, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Neck Shape:");
		lblNewLabel_8.setBounds(667, 256, 86, 14);
		contentPane.add(lblNewLabel_8);
		
		textFieldSize = new JTextField();
		textFieldSize.setBounds(667, 307, 86, 20);
		contentPane.add(textFieldSize);
		textFieldSize.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Size:");
		lblNewLabel_9.setBounds(667, 292, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		textFieldForm = new JTextField();
		textFieldForm.setBounds(667, 345, 86, 20);
		contentPane.add(textFieldForm);
		textFieldForm.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Form:");
		lblNewLabel_11.setBounds(668, 329, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(139, 378, 89, 23);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(299, 378, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(450, 378, 89, 23);
		contentPane.add(btnDelete);
		
		CheckBoxGoldFilled = new JCheckBox("Is Goldfilled");
		CheckBoxGoldFilled.setBounds(667, 372, 97, 23);
		contentPane.add(CheckBoxGoldFilled);
		
		
		comboBoxCategory = new JComboBox();
		comboBoxCategory.setBounds(667, 187, 86, 20);
		contentPane.add(comboBoxCategory);
		comboBoxCategory.addItem("Pants");
		comboBoxCategory.addItem("Shirt");
		comboBoxCategory.addItem("Accessories");
		
		comboBoxSleeve = new JComboBox();
		comboBoxSleeve.setBounds(667, 225, 86, 20);
		contentPane.add(comboBoxSleeve);
		comboBoxSleeve.addItem("1/2");
		comboBoxSleeve.addItem("3/4");
		comboBoxSleeve.addItem("long");
		comboBoxSleeve.addItem("none");
		comboBoxSleeve.addItem("");
		
		
		
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
				textFieldItemId.setText(id); 
				String name = table.getModel().getValueAt(row, 1).toString();
				textFieldItemName.setText(name);
				String price = table.getModel().getValueAt(row, 2).toString();
				textFieldPrice.setText(price);
				String quantity = table.getModel().getValueAt(row, 3).toString();
				textFieldQuantity.setText(quantity);
				
				
				String category = table.getModel().getValueAt(row, 4).toString();
				comboBoxCategory.setSelectedItem(category);
				
				
				String sleeve = "";
				if(table.getModel().getValueAt(row, 5)!= null) {
			    sleeve = table.getModel().getValueAt(row, 5).toString();
				}
				comboBoxSleeve.setSelectedItem(sleeve);

				
				String neckShape = "";
				if(table.getModel().getValueAt(row, 6)!= null) {
				neckShape = table.getModel().getValueAt(row, 6).toString();
				}
				textFieldNeckShape.setText(neckShape);
				
				String size = "";
				if(table.getModel().getValueAt(row, 7)!= null) {
				size = table.getModel().getValueAt(row, 7).toString();
				}
				textFieldSize.setText(size);
				
				String form = "";
				if(table.getModel().getValueAt(row, 8) != null) {
				form = table.getModel().getValueAt(row, 8).toString();
				
				}
				textFieldForm.setText(form);
				
				boolean isGoldFilled = false;
				if(table.getModel().getValueAt(row, 9) != null) {
					isGoldFilled = table.getModel().getValueAt(row, 9).toString().equals("1");
				}
				CheckBoxGoldFilled.setSelected(isGoldFilled);
		
				
			}
		});
	}


	//Action Listeners:
	public void addBtnActionListner(ActionListener al) { 
		this.btnBack.addActionListener(al);
		this.btnSearch.addActionListener(al);
		this.btnAdd.addActionListener(al);
		this.btnDelete.addActionListener(al);
		this.btnUpdate.addActionListener(al);
	
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

	
	
	public String getTextFieldItemId() {
		return textFieldItemId.getText();
	}

	public String getTextFieldItemName() {
		return textFieldItemName.getText();
	}

	public String getTextFieldPrice() {
		return textFieldPrice.getText();
	}

	public String getTextFieldQuantity() {
		return textFieldQuantity.getText();
	}

	public String getTextFieldNeckShape() {
		return textFieldNeckShape.getText();
	}

	public String getTextFieldSize() {
		return textFieldSize.getText();
	}

	public String getTextFieldForm() {
		return textFieldForm.getText();
	}
	
	
	public String getComboBoxSleeve() {
		return comboBoxSleeve.getSelectedItem().toString();
	}

	public String getComboBoxCategory() {
		return comboBoxCategory.getSelectedItem().toString();
	}
	
	public boolean getCheckBoxGoldFilled() {
		return CheckBoxGoldFilled.isSelected();
	}
	
	

	
	
	//Other methods:
	
	
	public void setProductsListToTable(ResultSet rs) {
		this.table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	public void displayMassage(String msg) {
		JOptionPane.showMessageDialog(this,msg);
	}
}
