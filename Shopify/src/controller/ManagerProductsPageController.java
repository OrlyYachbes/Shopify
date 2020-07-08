package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ManagerProductsPageModel;
import util.Item;
import view.ManagerProductsPageView;

public class ManagerProductsPageController {
	private ManagerProductsPageView view;
	private ManagerProductsPageModel model;

	public ManagerProductsPageController(ManagerProductsPageView view, ManagerProductsPageModel model)
	{
		this.view = view;
		this.model = model;
		
		view.addBtnActionListner(new BtnActionListener());
		view.setProductsListToTable(model.getProductsList());

	}
	
	
	class BtnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getBtnBack()){
				view.setVisible(false);
				view.dispose();
				model.moveToMainMenu();
			}
			
			else if(e.getSource() == view. getBtnSearch()) {
				
				String id = view.getSearchText();
				
				ResultSet rs = model.getProductsListById(id);
				
				boolean isEmpty = false;
				try {
					isEmpty = !rs.isBeforeFirst();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(isEmpty) {
					view.displayMassage("Product not found");
				}else {
					view.setProductsListToTable(rs);
				}
				
			}
			
			else if(e.getSource() == view.getBtnDelete()) {
				String id = view.getTextFieldItemId();
				if(id.trim().equals("")) {
					view.displayMassage("Id can not be empty.");
					return;
				}
				if(!model.isItemExist(id)) {
					view.displayMassage("Item does'nt exist.");
					return;
				}
				if(model.deleteItem(id)) {
					view.setProductsListToTable(model.getProductsList());
					view.displayMassage("Item Deleted!");
				} else
					view.displayMassage("Could not delete item.");
					
			}
			
			
			else if(e.getSource() == view.getBtnAdd()) {
				
				Item item = new Item();
				if(!initialItem(item))
					return;		
				
				if(model.addItem(item)) {
					view.setProductsListToTable(model.getProductsList());
					view.displayMassage("Item added succesfully!");
				} else
					view.displayMassage("Could not add item.");
			}
			
			
			else if(e.getSource() == view.getBtnUpdate()) {
				Item item = new Item();
				if(!initialItem(item))
					return;
				if(!model.isItemExist(item.getItemId())) {
					view.displayMassage("Item does'nt exist.");
					return;
				}
				if(model.updateItem(item, view.getTextFieldItemId())) {
					view.setProductsListToTable(model.getProductsList());
					view.displayMassage("Item updated succesfully!");
				}  else
					view.displayMassage("Could not update item.");
			}
			
			
		}	
		
	}
	
	
	
	public boolean initialItem(Item item) {
		
		int price;
		int quantity;
		int size;
		
		
		String stringPrice = view.getTextFieldPrice();
		String stringQuantity = view.getTextFieldQuantity();
		String stringSize = view.getTextFieldSize();	
		String id = view.getTextFieldItemId();
		String name = view.getTextFieldItemName();
		String category = view.getComboBoxCategory();
		String sleeve = view.getComboBoxSleeve();
		String neck = view.getTextFieldNeckShape();

		String form = view.getTextFieldForm();
		boolean isgold = view.getCheckBoxGoldFilled();
		
		if(stringPrice.trim().equals("") || stringQuantity.trim().equals("") || stringSize.trim().equals("") || id.trim().equals("") || name.trim().equals("")|| neck.trim().equals("") || form.trim().equals("")) {
			view.displayMassage("All fields must contain a value!");
			return false;
		}
		
		try {
			
			price = Integer.valueOf(stringPrice);
			quantity = Integer.valueOf(stringQuantity);
			size = Integer.valueOf(stringSize);
			
		}catch(Exception e) {
			
			view.displayMassage("Price, Quantity, Size can only contain numbers!");
			
			return false;
		}
		
		
		
		
		item.setItemId(id);
		item.setItemName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		item.setCategory(category);
		item.setSleeve(sleeve);
		item.setNeck_shape(neck);
		item.setSize(size);
		item.setForm(form);
		item.setGoldfilled(isgold);
		
		return true;
		
		
	}
	
	

}
