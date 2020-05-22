package database;

import java.sql.Connection;
import java.sql.DriverManager;
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
            	 return false;
             }
             
             else {
            	 rs.close();
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
           	 return false;
            }
            
            else {
           	 rs.close();
           	 return true;
            }
             

       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       }  
       
       return false;
   }
    
    
    
}
