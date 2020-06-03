package model;

import database.DataBase;

public class ManagerMainMenuModel {


	private DataBase db;
	private FrameManager fm;
	
	public  ManagerMainMenuModel () {
		this.db = DataBase.getInstance();
		this.fm = FrameManager.getInstance();
	}
	
	public void moveToManagerProductsPage() {
		fm.moveToManagerProductsPage();
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
	
	public void moveToEditUserPage() {
		fm.moveToManageEmpPage();
	}
}
