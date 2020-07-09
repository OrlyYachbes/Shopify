package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import database.DataBase;
import util.Employee;
import util.Item;

class Unitest {
	
	DataBase db = DataBase.getInstance();

	@Test
	void addNewProductTest() {
		
		Item item = new Item();
		
		String testId = "9999999";
		String testString = "123456";
		int testInt = 123456;
		
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
		
		Item secItem = db.getItemById(testString);
		
		assertEquals(item, secItem);

				
	}
	
	@Test
	void deleteItem() {
		
		String testId = "9999999";
		
		db.deleteItem(testId);
		
		boolean isItemExist = db.isItem(testId);
		
		assertFalse(isItemExist);
	}
	
	
	@Test
	void UpdateProductTest() {
		
		Item item = new Item();
		
		String testId = "9999999";
		String testString = "123456";
		int testInt = 123456;
		
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
		
		Item secItem = db.getItemById(testString);
		
		assertEquals(item, secItem);

				
	}
	
	
	@Test
	void addEmployeeTest() {
		

		String testId = "9999999";
		String testString = "123456";
		int testInt = 123456;
		
		Employee emp = new Employee();
		emp.setEmpFirstName(testId);
		emp.setEmpLastName(testString);
		emp.setEmpId(testId);
		emp.setPassword(testString);
		
		db.addEmp(emp);
		
		//assertEquals
	}
	
	
	@Test
	void deleteEmp() {
		
		String testId = "9999999";
		
		db.deleteItem(testId);
		
		boolean isItemExist = db.deleteEmp(testId);
		
		assertFalse(isItemExist);
	}

}
