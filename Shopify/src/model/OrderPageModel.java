package model;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import database.DataBase;

public class OrderPageModel {
	private DataBase db;
	private FrameManager fm;
	private Map<String, Integer> ordersMap;
	
	public  OrderPageModel () {
		this.db = DataBase.getInstance();
		this.fm = FrameManager.getInstance();
		this.ordersMap = new HashMap<>();
	}
	
	public ResultSet getProductsList() {
		return db.importProductsList();
	}
	
	public void moveToMainMenu() {
		fm.moveToMainMenu();
	}
	
	public void addToOrdersList(String id, int quantity) {
		
		this.ordersMap.put(id, quantity);
	}
	
	public boolean addOrdersListToDb() {
		
		for (Map.Entry<String, Integer> item : ordersMap.entrySet()) {
			db.updateProductQuantity(item.getKey(), item.getValue());
		}
		
		ordersMap = new HashMap<>();
		 
		return true;
	}
	
	public void removeFromOrderList(String id) {
		this.ordersMap.remove(id);
	}
		

	
	public int getItemQuantity(String id) {
		return db.getItemQuantity(id);
	}

}
