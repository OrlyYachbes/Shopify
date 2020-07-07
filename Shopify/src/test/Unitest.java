package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Item;

class Unitest {

	@Test
	void addNewProductText() {
		
		Item item = new Item();
		
		String testString = "test";
		int testInt = 123456;
		
		item.setItemId(testString);
		item.setItemName(testString);
		item.setPrice(testInt);
		item.setQuantity(testInt);
		item.setCategory(testString);
		item.setSleeve(testString);
		item.setNeck_shape(testString);
		item.setSize(testInt);
		item.setForm(testString);
		item.setGoldfilled(false);
		
		//need to create 'equals' function for item.
		//and get item method from db inside Database class.
				
	}

}
