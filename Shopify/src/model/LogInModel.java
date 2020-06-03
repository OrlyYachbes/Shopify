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
	
	public boolean logIn(String userId, String password){
		
		if(db.selectManager(userId, password)) {
			fm.setManager(true);
			fm.moveToMainMenuPage();
			return true;
		} else if(db.selectEmployee(userId, password)) {
			fm.setManager(false);
			fm.moveToMainMenuPage();
			return true;
		} else
			return false;
	}
	
	
	

}
