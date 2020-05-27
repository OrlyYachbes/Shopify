package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ManagerMainMenuModel;
import view.ManagerMainMenuView;

public class ManagerMainMenuController {

	private ManagerMainMenuView view;
	private ManagerMainMenuModel model;
	
	public ManagerMainMenuController(ManagerMainMenuView view, ManagerMainMenuModel model)
	{
		this.view = view;
		this.model = model;
		this.view.addBtnAl(new btnActionListener());
	}
	
	class btnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				
			if(e.getSource() == view.getBtnProductPage()) {
				view.setVisible(false);
				view.dispose();
				model.moveToProductsPage();
			}
			
			if(e.getSource() == view.getBtnOrderPage()) {
				view.setVisible(false);
				view.dispose();
				model.moveToOrdersPage();
			}
			
			if(e.getSource() == view.getBtnChangePass()) {
				view.setVisible(false);
				view.dispose();
				model.moveToChangePassPage();
			}

			if(e.getSource() == view.getBtnLogOut()) {
				view.setVisible(false);
				view.dispose();
				model.moveToLogInPage();
			}
			
			if(e.getSource() == view.getBtnEditUser()) {
				view.setVisible(false);
				view.dispose();
			    model.moveToEditUserPage();
				
			}
		}
	}
}