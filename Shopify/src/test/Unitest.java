package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import database.DataBase;
import util.Employee;
import util.Item;

class Unitest {
	
	DataBase db = DataBase.getInstance();
	
	
	String testId = "9999999";
	String testString = "123456";
	int testInt = 123456;

	@Test
	void addNewProductTest() {
		
		Item item = new Item();

		
		item.setItemId(testId);
		item.setItemName(testString);
		item.setPrice(testInt);
		item.setQuantity(testInt);
		item.setCategory(testString);
		item.setSleeve(testString);
		item.setNeck_shape(testString);
		item.setSize(testInt);
		item.setForm(testString);
		item.setGoldfilled(false);
		
		db.addItem(item);
		
		Item secItem = db.getItemById(testId);
		
		assertEquals(item, secItem);

				
	}
	
	@Test
	void bupdateProductTest() {
		
		Item item = new Item();
		
		int updatedTestInt = 1111111;

		item.setItemId(testId);
		item.setItemName(testString);
		item.setPrice(updatedTestInt);
		item.setQuantity(updatedTestInt);
		item.setCategory(testString);
		item.setSleeve(testString);
		item.setNeck_shape(testString);
		item.setSize(testInt);
		item.setForm(testString);
		item.setGoldfilled(false);
		
		db.updateItem(item, testId);
		
		Item secItem = db.getItemById(testId);
		
		assertEquals(item, secItem);

				
	}
	
	@Test
	void cdeleteItem() {
				
		db.deleteItem(testId);
		
		boolean isItemExist = db.isItem(testId);
		
		assertFalse(isItemExist);
	}
	
	

	
	
	@Test
	void eaddEmployeeTest() {
		

		Employee emp = new Employee();
		emp.setEmpFirstName(testId);
		emp.setEmpLastName(testString);
		emp.setEmpId(testId);
		emp.setPassword(testString);
		
		db.addEmp(emp);
		
		assertTrue(db.isEmployee(testId));
	}
	
	
	@Test
	void fdeleteEmp() {
		
		String testId = "9999999";
		
		db.deleteEmp(testId);
		
		boolean isItemExist = db.isEmployee(testId);
		
		assertFalse(isItemExist);
	}

}
