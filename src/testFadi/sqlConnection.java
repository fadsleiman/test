package testFadi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.function.Function;


public class sqlConnection {
	static Connection conn;
	static Statement st;
	
	public static void openConnection()
	{
		try
		  {
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			  conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PhoneBookDB;user=sa;password=P@ssw0rd");
		      st=conn.createStatement();      
		  }
		  catch (Exception e)
		  {
			//  if(st!=null)
			  //    st.close();
			    //  if(conn!=null)
			      //    conn.close(); 
		  }
		  
	}
	
	public static void closeConnection()
	{
		try
		{
		 if(st!=null)
		      st.close();
	      if(conn!=null)
	          conn.close();
		}
		catch (SQLException e)
		  {
			  //if(st!=null)
			      //st.close();
			      //if(conn!=null)
			    //      conn.close(); 
		  }
		  
	}
	
	public List<PhoneBook> SelectAll()  
	 {  
		 List<PhoneBook> listOfNumbers = new ArrayList<PhoneBook>();  
		try
		  {
		      String sql="select * from tbData";
		      ResultSet rs=st.executeQuery(sql);
		      
		      while(rs.next())
		      {
		    	  int selectedID = rs.getInt("ID");
		    	  String selectedName = rs.getString("Name");
		    	  String selectedNumber = rs.getString("PhoneNumber");
		    	  
		    	  PhoneBook fadiSix=new PhoneBook(selectedID, selectedName , selectedNumber);  
		    	  listOfNumbers.add(fadiSix);  

		      }
		      
			 
		  }
		
		catch (SQLException e)
		  {
			  //if(st!=null)
			      //st.close();
			      //if(conn!=null)
			        //  conn.close(); 
		  }
		  
		return listOfNumbers;
	 }
	 
	public void InsertNumber(String name, String number)
	{
		try
		{
			String sql="insert into tbData (Name , PhoneNumber) values ('"+ name + "',' " + number+ "')";
		   st.executeUpdate(sql);
		}
		catch (SQLException e)
		{}
	}

}
