package model;

import database.DataBase;

public class OrderPageModel {
	private DataBase db;
	private FrameManager fm;
	
	public  OrderPageModel () {
		this.db = DataBase.getInstance();
		this.fm = FrameManager.getInstance();
	}

}
