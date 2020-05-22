package model;

import database.DataBase;

public class EmpProductsPageModel {
	
	private DataBase db;
	private FrameManager fm;
	
	public EmpProductsPageModel(){
		db = DataBase.getInstance();
		fm = FrameManager.getInstance();
	}
	
	
	//need to change return type!!
	public void getProductsList() {
		
	}
	
	//need to change return type!!
	public void getProductsListById(String id) {
		
	}
	
	public void moveToMainMenu() {
		fm.moveToMainMenu();
	}
	

}
