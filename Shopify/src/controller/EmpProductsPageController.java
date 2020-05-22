package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EmpProductsPageModel;
import view.EmpProductsPageView;

public class EmpProductsPageController {
	
	private EmpProductsPageView view;
	private EmpProductsPageModel model;

	
	public EmpProductsPageController(EmpProductsPageView view, EmpProductsPageModel model) {
		this.view = view;
		this.model = model;
		view.addBtnActionListner(new BtnActionListener());
		//need to render the list in listView!!
		model.getProductsList();
	}
	
	class BtnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getBtnBack()){
				model.moveToMainMenu();
			}
			
			else if(e.getSource() == view. getBtnSearch()) {
				
				String id = view.getSearchText();
				
				//need to render the list in listView!!
				model.getProductsListById(id);
			}
		}
		
	}
}
