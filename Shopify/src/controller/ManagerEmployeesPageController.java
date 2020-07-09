package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.UserFactory;
import model.ManagerEmployeesPageModel;
import util.Employee;
import view.ManagerEmployeesPageView;


public class ManagerEmployeesPageController {
	private ManagerEmployeesPageView view;
	private ManagerEmployeesPageModel model;
	
	public ManagerEmployeesPageController(ManagerEmployeesPageView view, ManagerEmployeesPageModel model)
	{
		this.view = view;
		this.model = model;

		view.addBtnActionListner(new BtnActionListener()); 
		view.setEmployeesListToTable(model.getEmployeesList());

	}
	
	class BtnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource() == view.getBtnBack()){
				view.setVisible(false);
				view.dispose();
				model.moveToMainMenu();
			}
			
			else if(e.getSource() == view. getBtnSearch()) {
				
				String id = view.getSearchText();
				
				ResultSet rs = model.getEmployeesListById(id);
				
			
				boolean isEmpty = false;
				try {
					isEmpty = !rs.isBeforeFirst();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(isEmpty) {
					view.displayMassage("Employee not found");
				}else {
					view.setEmployeesListToTable(rs);
				}
				
			}
			
			else if(e.getSource() == view.getBtnDelete()) {
				String id = view.getTextFieldEmpId();
				if(id.trim().equals("")) {
					view.displayMassage("Id cann't be empty.");
					return;
				}
				if(!model.isEmpExist(id)) {
					view.displayMassage("Employee does'nt exist.");
					return;
				}
				
				if(model.deleteEmp(view.getTextFieldEmpId())) {
					view.setEmployeesListToTable(model.getEmployeesList());
					view.displayMassage("Employee Deleted!");
				} else
					view.displayMassage("Could not delete employee.");
					
			}
			
			
			else if(e.getSource() == view.getBtnAdd()) {
				
				UserFactory userFactory = new UserFactory();
				
			    Employee emp = (Employee)userFactory.makeUser("E");
				if(!initialEmp(emp)) {
					return;
				}			
				
				if(model.addEmp(emp)) {
					view.setEmployeesListToTable(model.getEmployeesList());
					view.displayMassage("Employee added succesfully!");
				} else
					view.displayMassage("Could not add Employee.");
			}
			
			
			else if(e.getSource() == view.getBtnUpdate()) {
				Employee emp = new Employee();
				if(!initialEmp(emp)) {
					return;
				}
				if(!model.isEmpExist(emp.getEmpId())) {
					view.displayMassage("Employee does'nt exist.");
					return;
				}
				if(model.updateEmp(emp, view.getTextFieldEmpId())) {
					view.setEmployeesListToTable(model.getEmployeesList());
					view.displayMassage("Employee updated succesfully!");
				}  else
					view.displayMassage("Could not update employee.");
			}
			
			else if(e.getSource() == view.getBtnClear()) {
				view.clearFields();
			}
			
			
		}	
		
	}
	
	
	public boolean initialEmp(Employee emp) {

		emp.setEmpId(view.getTextFieldEmpId());
		emp.setEmpFirstName(view.getTextFieldEmpFirstName());
		emp.setEmpLastName(view.getTextFieldEmpLastName());
		emp.setPassword(view.getTextFieldPassword());
		
		String firstName = emp.getEmpFirstName();
		String lastName = emp.getEmpLastName();
		String pass = emp.getPassword();
		String id = emp.getEmpId();
		
		if(firstName.trim().equals("") || lastName.trim().equals("")|| pass.trim().equals("") || id.trim().equals("")) {
			view.displayMassage("All fields must contain a value");
			return false;
		} else if(!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")) {
			view.displayMassage("First name and last name can only contain letters");
			return false;
		}
		
		return true;
	}
	
	

}

