package util;

public class Employee extends User {
	private String empId;
	private String empFirstName;
	private String empLastName;
	private String password;
	
	public String getEmpId() {
		return empId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public String getPassword() {
		return password;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
