package model;

import java.sql.ResultSet;

import database.DataBase;
import util.Item;

public class ManagerProductsPageModel {
	
	private DataBase db;
	private FrameManager fm;
	
	public ManagerProductsPageModel(){
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
	
	public boolean deleteItem(String id) {
		return db.deleteItem(id);
		
	}
	
	public boolean addItem(Item item) {
		return db.addItem(item);
	}
	
	public boolean updateItem(Item item, String id) {
		return db.updateItem(item, id);
	}
	
	public void moveToMainMenu() {
		fm.moveToMainMenuPage();
	}
	

}
