package model;

import java.sql.ResultSet;

import database.DataBase;

public class EmpProductsPageModel {
	
	private DataBase db;
	private FrameManager fm;
	
	public EmpProductsPageModel(){
		db = DataBase.getInstance();
		fm = FrameManager.getInstance();
	}
	
	

	public ResultSet getProductsList() {
		return db.importProductsList();
	}
	
	//need to change return type!!
	public ResultSet getProductsListById(String id) {
		return db.getProductById(id);
		
	}
	
	public void moveToMainMenu() {
		fm.moveToMainMenu();
	}
	

}
