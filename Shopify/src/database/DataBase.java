package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.Employee;
import util.Item;

public class DataBase {
    private static DataBase dataBase_instance = null;
    private DataBase(){};
    public static DataBase getInstance(){
        if(dataBase_instance == null)
            dataBase_instance = new DataBase();
        return  dataBase_instance;
    }
    
    
    private Connection connect() {   
        String url = "jdbc:sqlite:src/database/StorifyDb.db"; 
        Connection conn = null;  
        
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
        
        return conn;  
    }  
   
  
    public boolean selectEmployee(String id, String password){  
    	String sql = "SELECT * FROM employee where id = " + id + " AND password = " + password;  
    	 

         try {  
             Connection conn = this.connect();  
             Statement stmt  = conn.createStatement();  
             ResultSet rs    = stmt.executeQuery(sql);  

             boolean isEmpty = !rs.isBeforeFirst();
             
             if (isEmpty) {
            	 rs.close();
            	 conn.close();
            	 return false;
             }
             
             else {
            	 rs.close();
            	 conn.close();
            	 return true;
             }
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    }
    
    public boolean selectManager(String id, String password){  
   	 String sql = "SELECT * FROM manager where id = " + id + " AND password = " + password;  

        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  

            boolean isEmpty = !rs.isBeforeFirst();
            
            if (isEmpty) {
           	 rs.close();
           	 conn.close();
           	 return false;
            }
            
            else {
           	 rs.close();
           	 conn.close();
           	 return true;
            }
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
   }
    
    
    public ResultSet importProductsList(){  
    	
      	 String sql = "SELECT * FROM item";  

           
           try {  
               Connection conn = this.connect();  
               Statement stmt  = conn.createStatement();   
               ResultSet rs    = stmt.executeQuery(sql);  
               return rs;
                

          } catch (SQLException e) {  
              System.out.println(e.getMessage());  
          }  
          
          return null; //need to find something else
      }
    
   
    public ResultSet getProductById(String id) { 
    	if(id.equals("")) {
    		return this.importProductsList();
    	} else {
    		String sql = "SELECT * FROM item where item_id = ?"; //cant fined strings
    		
    		try {
    			Connection conn = this.connect();  
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, id);
    			ResultSet rs = pstmt.executeQuery();
                return rs;
    		} catch (SQLException e) {  
    	           System.out.println(e.getMessage());  
    	       }  
    		
    		return null;
    	}
    	
    } 
  
    
    
    public boolean updateProductQuantity(String id, int quantity){  
    	String sql = "UPDATE item SET quantity = ? WHERE item_id = ?";  
    	 

         try {  
        	 
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, quantity);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            return true;

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    }
    
    public int getItemQuantity(String id){  
    	String sql = "SELECT quantity FROM item where item_id = " + id; 
    	 

         try {  
             Connection conn = this.connect();  
             Statement stmt  = conn.createStatement();  
             ResultSet rs    = stmt.executeQuery(sql);
             int quantity = rs.getInt("quantity");
             conn.close();

            return quantity;
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return 0;
    } 
    
    
    public boolean deleteItem(String id){  
    	String sql = "DELETE FROM item WHERE item_id = ?";
    	

         try {  
             Connection conn = this.connect();  
             PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, id);
             pstmt.executeUpdate();
             conn.close();

            return true;
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    } 
    
    public boolean addItem(Item item){  
    	
   	String sql = "INSERT INTO item(item_id, item_name, price, quantity, category, sleeve, neck_shape, size, form, is_goldfilled)"
   			+ "VALUES(?,?,?,?,?,?,?,?,?,?)";

         try {  
             Connection conn = this.connect();  
             PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, item.getItemId());
             pstmt.setString(2, item.getItemName());
             pstmt.setInt(3, item.getPrice());
             pstmt.setInt(4, item.getQuantity());
             pstmt.setString(5, item.getCategory());
             pstmt.setString(6, item.getSleeve());
             pstmt.setString(7, item.getNeck_shape());
             pstmt.setInt(8, item.getSize());
             pstmt.setString(9, item.getForm());
             pstmt.setBoolean(10, item.getIsGoldfilled());
             
             pstmt.executeUpdate();
             conn.close();

            return true;
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    } 
    
    
    public boolean updateItem(Item item, String id){  
    	
   	String sql = "UPDATE item SET item_name = ?, price = ?, quantity = ?, category = ?, sleeve = ?, "
   			+ "neck_shape = ?, size = ?, form =?, is_goldfilled = ? WHERE item_id = ?";
   			

         try {
        	 
             Connection conn = this.connect();  
             
             PreparedStatement pstmt = conn.prepareStatement(sql); 
             
             pstmt.setString(1, item.getItemName());
             pstmt.setInt(2, item.getPrice());
             pstmt.setInt(3, item.getQuantity());
             pstmt.setString(4, item.getCategory());
             pstmt.setString(5, item.getSleeve());
             pstmt.setString(6, item.getNeck_shape());
             pstmt.setInt(7, item.getSize());
             pstmt.setString(8, item.getForm());
             pstmt.setBoolean(9, item.getIsGoldfilled());
             pstmt.setString(10, item.getItemId());
             
             
             pstmt.executeUpdate();
         
             conn.close();

            return true;
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    } 
    
    
    
   
    public ResultSet importEmployeesList(){  
    	
      	 String sql = "SELECT * FROM employee";  

           
           try {  
               Connection conn = this.connect();  
               Statement stmt  = conn.createStatement();  
               ResultSet rs    = stmt.executeQuery(sql);  
               return rs;
                

          } catch (SQLException e) {  
              System.out.println(e.getMessage());  
          }  
          
          return null; //need to find something else
      }
    
  
    public ResultSet getEmpById(String id) { 
    	if(id.equals("")) {
    		return this.importEmployeesList();
    	} else {
    		String sql = "SELECT * FROM employee where id = ?"; //cant fined strings
    		
    		try {
    			Connection conn = this.connect();  
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, id);
    			ResultSet rs = pstmt.executeQuery();
                return rs;
    		} catch (SQLException e) {  
    	           System.out.println(e.getMessage());  
    	       }  
    		
    		return null;
    	}
    	
    } 
  
    
    public boolean deleteEmp(String id){  
    	String sql = "DELETE FROM employee WHERE id = ?";
    	

         try {  
             Connection conn = this.connect();  
             PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, id);
             pstmt.executeUpdate();
             conn.close();

            return true;
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    } 
    
    
    public boolean addEmp(Employee emp){  
    	
   	String sql = "INSERT INTO employee(id, first_name, last_name, password)" + "VALUES(?,?,?,?)";

         try {  
             Connection conn = this.connect();  
             PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, emp.getEmpId());
             pstmt.setString(2, emp.getEmpFirstName());
             pstmt.setString(3, emp.getEmpLastName());
             pstmt.setString(4, emp.getPassword());
             
             pstmt.executeUpdate();
             conn.close();

            return true;
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    } 
    
    
    
    public boolean updateEmp(Employee emp, String id){  
    	
   	String sql = "UPDATE employee SET first_name = ?, last_name = ?, password = ? WHERE id = ?";
   			

         try {
        	 
             Connection conn = this.connect();  
             PreparedStatement pstmt = conn.prepareStatement(sql); 
             
             
             pstmt.setString(1, emp.getEmpFirstName());
             pstmt.setString(2, emp.getEmpLastName());
             pstmt.setString(3, emp.getPassword());
             pstmt.setString(4, emp.getEmpId());
             
             pstmt.executeUpdate();
             
             conn.close();

            return true;
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    } 
    
    
    public boolean isEmployee(String id){  
    	String sql = "SELECT * FROM employee where id = " + id; 
    	 

         try {  
             Connection conn = this.connect();  
             Statement stmt  = conn.createStatement();  
             ResultSet rs    = stmt.executeQuery(sql);  

             boolean isEmpty = !rs.isBeforeFirst();
             
             if (isEmpty) {
            	 rs.close();
            	 conn.close();
            	 return false;
             }
             
             else {
            	 rs.close();
            	 conn.close();
            	 return true;
             }
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    }
    
    public boolean isItem(String id){  
    	String sql = "SELECT * FROM item where item_id = " + id; 
    	 

         try {  
             Connection conn = this.connect();  
             Statement stmt  = conn.createStatement();  
             ResultSet rs    = stmt.executeQuery(sql);  

             boolean isEmpty = !rs.isBeforeFirst();
             
             if (isEmpty) {
            	 rs.close();
            	 conn.close();
            	 return false;
             }
             
             else {
            	 rs.close();
            	 conn.close();
            	 return true;
             }
              

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
        return false;
    }
    
    //Test methods:
    
    
    public Item getItemById(String id) {
    	
    	String sql = "SELECT * FROM item WHERE item_id = " + id;
			

        try {
       	 
            Connection conn = this.connect();  
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("1");

            String itemId = rs.getString(1);
            String itemName = rs.getString(2);
            int price = rs.getInt(3);
            int quantity = rs.getInt(4);
            
            String category = rs.getString(5);
            String sleeve = rs.getString(6);
            String neck_shape = rs.getString(7);
            int size = rs.getInt(8);
            String form = rs.getString(9);
            boolean isGoldfilled = rs.getBoolean(10);
            
            Item item = new Item(itemId, itemName, price, quantity, category, sleeve, neck_shape, size, form, isGoldfilled);
            
            System.out.println(item.getCategory());
            rs.close();
            conn.close();
            return item;
        
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
           return null;
       }  
       
       
    }
    
    
    
}
