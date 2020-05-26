package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ManagerMainMenuController.btnActionListener;
import model.ManagerMainMenuModel;
import model.OrderPageModel;
import view.ManagerMainMenuView;
import view.OrderPageView;

public class OrderPageController {


	private OrderPageView view;
	private OrderPageModel model;
	
	public OrderPageController(OrderPageView view,OrderPageModel model)
	{
		this.view = view;
		this.model = model;
		this.view.addBtnAl(new btnActionListener());
		view.setProductsListToTable(model.getProductsList());
	}
	
	class btnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getBtnAdd()) {
				
				String id = view.getId();
				int quantity = Integer.parseInt(view.getQuantity());
				int currentQuantity = model.getItemQuantity(id);
				int updatedQuantity = currentQuantity - quantity;
				
				if(quantity < currentQuantity) {
					
					view.addToOrderList();
					model.addToOrdersList(id, updatedQuantity);
				}
				else {
					view.displayMessage("Quantity equired is more than the supply!!");
				}
				
			}else if (e.getSource() == view.getBtnBack()) {
				model.moveToMainMenu();
				view.setVisible(false);
				view.dispose();
				
			}else if(e.getSource() == view.getBtnPlaceOrder()) {
				model.addOrdersListToDb();
				view.displayMessage("Order completed!");
				
			}
			
		}
		
	}
}
