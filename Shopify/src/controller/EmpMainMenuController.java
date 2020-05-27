package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EmpMainMenuModel;
import view.EmpMainMenuView;

public class EmpMainMenuController {
	
	private EmpMainMenuView view;
	private EmpMainMenuModel model;
	
	public EmpMainMenuController(EmpMainMenuView view, EmpMainMenuModel model) {
		this.view = view;
		this.model = model;
		this.view.addBtnAl(new btnActionListener());
	}
	
	class btnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				
			if(e.getSource() == view.getBtnProductsPage()) {
				view.setVisible(false);
				view.dispose();
				model.moveToProductsPage();
			}
			
			if(e.getSource() == view.getBtnOrdersPage()) {
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
		}
	
	}

}
