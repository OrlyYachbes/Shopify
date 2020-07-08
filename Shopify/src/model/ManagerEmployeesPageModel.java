package model;

import java.sql.ResultSet;

import database.DataBase;
import util.Employee;


public class ManagerEmployeesPageModel {
	
	private DataBase db;
	private FrameManager fm;
	
	public ManagerEmployeesPageModel(){
		db = DataBase.getInstance();
		fm = FrameManager.getInstance();
	}
	
	public ResultSet getEmployeesList() {
		return db.importEmployeesList();
	}
	
	//need to change return type!!
	public ResultSet getEmployeesListById(String id) {
		return db.getEmpById(id);
		
	}
	
	public boolean deleteEmp(String id) {
		return db.deleteEmp(id);
		
	}
	
	public boolean addEmp(Employee emp) {
		return db.addEmp(emp);
	}
	
	public boolean updateEmp(Employee emp, String id) {
		return db.updateEmp(emp, id);
	}
	
	public void moveToMainMenu() {
		fm.moveToMainMenuPage();
	}
	
	public boolean isEmpExist(String id) {
		return db.isEmployee(id);
	}
	
	
	

}
