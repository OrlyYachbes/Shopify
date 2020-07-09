package factory;

import util.Employee;
import util.Manager;
import util.User;

public class UserFactory {

	public User makeUser(String type) {
		
		User user = null;
		
		if(type.equals("E")) {
			return new Employee();
		}
		
		else if(type.equals("M")) {
			return new Manager();
		}
		else return null;
	}

}
