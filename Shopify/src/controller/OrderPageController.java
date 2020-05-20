package controller;

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
		//this.view.addBtnAl(new btnActionListener());
	}
}
