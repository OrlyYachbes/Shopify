package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static DataBase dataBase_instance = null;
    private DataBase(){};
    public static DataBase getInstance(){
        if(dataBase_instance == null)
            dataBase_instance = new DataBase();
        return  dataBase_instance;
    }
    
    
 
    	
    private Connection connect() {  
        // SQLite connection string  
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
    
    
}
