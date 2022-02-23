//STEP 1. Import required packages
import java.sql.*;

public class CreateTable {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/STUDENTSDB";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE student " +
                   "(studentId INTEGER not NULL, " +
                   " firstName VARCHAR(255), " + 
                   " lastName VARCHAR(255), " + 
                   " course INTEGER, " + 
                   " PRIMARY KEY ( studentId ))"; 

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample