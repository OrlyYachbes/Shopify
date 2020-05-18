package model;

import database.DataBase;

public class EmpMainMenuModel {
	
	private DataBase db;
	private FrameManager fm;
	
	public EmpMainMenuModel() {
		this.db = DataBase.getInstance();
		this.fm = FrameManager.getInstance();
	}	
	
	public void moveToProductsPage() {
		fm.moveToEmpProductsPage();
	}
	
	public void moveToOrdersPage() {
		fm.moveToOrderPage();
	}
	
	public void moveToChangePassPage() {
		fm.moveToChangePasswordPage();
	}
	
	public void moveToLogInPage() {
		fm.moveToLoginPage();
	}	

}
