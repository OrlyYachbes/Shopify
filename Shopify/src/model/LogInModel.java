package model;
import database.DataBase;
import model.FrameManager;



public class LogInModel {
	private DataBase db;
	private FrameManager fm;
	
	public LogInModel() {
		db = DataBase.getInstance();
		fm = FrameManager.getInstance();
	}
	
	public boolean logIn(String userName, String password){
		//implement...
		//move to...
		return true;
	};
	
	

}
