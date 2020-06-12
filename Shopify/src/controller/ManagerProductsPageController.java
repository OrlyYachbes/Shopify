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
				if(model.deleteItem(view.getTextFieldItemId())) {
					view.setProductsListToTable(model.getProductsList());
					view.displayMassage("Item Deleted!");
				} else
					view.displayMassage("Could not delete item.");
					
			}
			
			
			else if(e.getSource() == view.getBtnAdd()) {
				
				Item item = new Item();
				initialItem(item);			
				
				if(model.addItem(item)) {
					view.setProductsListToTable(model.getProductsList());
					view.displayMassage("Item added succesfully!");
				} else
					view.displayMassage("Could not add item.");
			}
			
			
			else if(e.getSource() == view.getBtnUpdate()) {
				Item item = new Item();
				initialItem(item);	
				if(model.updateItem(item, view.getTextFieldItemId())) {
					view.setProductsListToTable(model.getProductsList());
					view.displayMassage("Item updated succesfully!");
				}  else
					view.displayMassage("Could not update item.");
			}
			
			
		}	
		
	}
	
	
	public void initialItem(Item item) {
		item.setItemId(view.getTextFieldItemId());
		item.setItemName(view.getTextFieldItemName());
		item.setPrice(view.getTextFieldPrice());
		item.setQuantity(view.getTextFieldQuantity());
		item.setCategory(view.getComboBoxCategory());
		item.setSleeve(view.getComboBoxSleeve());
		item.setNeck_shape(view.getTextFieldNeckShape());
		item.setSize(view.getTextFieldSize());
		item.setForm(view.getTextFieldForm());
		item.setGoldfilled(view.getCheckBoxGoldFilled());
		
		
	}
	
	

}
