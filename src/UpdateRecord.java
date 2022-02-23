//STEP 1. Import required packcourses
import java.sql.*;

public class UpdateRecord {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/STUDENTSDB";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void  main(String[] args) {
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
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql = "UPDATE student " +
                   "SET course = 30 WHERE studentid in (100, 101)";
      stmt.executeUpdate(sql);

      // Now you can extract all the records
      // to see the updated records
      sql = "SELECT studentid, firstname, lastname, course FROM student";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name
         int studentid  = rs.getInt("studentid");
         int course = rs.getInt("course");
         String firstname = rs.getString("firstname");
         String lastname = rs.getString("lastname");

         //Display values
         System.out.print("studentid: " + studentid);
         System.out.print(", course: " + course);
         System.out.print(", firstname: " + firstname);
         System.out.println(", lastname: " + lastname);
      }
      rs.close();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
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