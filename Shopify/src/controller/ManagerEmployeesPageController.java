package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				if(model.deleteEmp(view.getTextFieldEmpId())) {
					view.setEmployeesListToTable(model.getEmployeesList());
					view.displayMassage("Employee Deleted!");
				} else
					view.displayMassage("Could not delete employee.");
					
			}
			
			
			else if(e.getSource() == view.getBtnAdd()) {
				
			    Employee emp = new Employee();
				initialEmp(emp);			
				
				if(model.addEmp(emp)) {
					view.setEmployeesListToTable(model.getEmployeesList());
					view.displayMassage("Employee added succesfully!");
				} else
					view.displayMassage("Could not add Employee.");
			}
			
			
			else if(e.getSource() == view.getBtnUpdate()) {
				Employee emp = new Employee();
				initialEmp(emp);	
				if(model.updateEmp(emp, view.getTextFieldEmpId())) {
					view.setEmployeesListToTable(model.getEmployeesList());
					view.displayMassage("Employee updated succesfully!");
				}  else
					view.displayMassage("Could not update employee.");
			}
			
			
		}	
		
	}
	
	
	public void initialEmp(Employee emp) {
		emp.setEmpId(view.getTextFieldEmpId());
		emp.setEmpFirstName(view.getTextFieldEmpFirstName());
		emp.setEmpLastName(view.getTextFieldEmpLastName());
		emp.setPassword(view.getTextFieldPassword());
		
	}
	
	

}

