package testFadi;

import java.util.ArrayList;  
import java.util.List;  

import java.sql.*;


//import org.arpit.java2blog.bean.Country;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;  
  
@RestController  
public class PhoneBookController {  
   
 @RequestMapping(value = "/listNumbers", method = RequestMethod.GET,headers="Accept=application/json")  
 public List<PhoneBook> getNumbers()  
 {  
  List<PhoneBook> listOfNumbers = new ArrayList<PhoneBook>();  
  listOfNumbers=createNumberList();  
  return listOfNumbers;  
 }  
  
 @RequestMapping(value = "/getNumber/{id}", method = RequestMethod.GET,headers="Accept=application/json")  
 public PhoneBook getNumberByID(@PathVariable int id)  
 {  
  List<PhoneBook> listOfNumbers = new ArrayList<PhoneBook>();  
  listOfNumbers=createNumberList();  
  
  for (PhoneBook phoneBook: listOfNumbers) {  
   if(phoneBook.getId()==id)  	
    return phoneBook;  
  }  
    
  return null;  
 }  
 
 
 //Insert one row
 @RequestMapping(value = "/insert/{namee}/{numberr}", method = RequestMethod.GET,headers="Accept=application/json")  
 public void insertRow(@PathVariable String namee , @PathVariable String numberr )  
 {
	 sqlConnection conn = new sqlConnection();
	 conn.openConnection();
	 conn.InsertNumber(namee, numberr);
	 conn.closeConnection();
  
 }  
// Utiliy method to create number lists  
 
 public List<PhoneBook> createNumberList()  
 { 
	 List<PhoneBook> listOfNumbers = new ArrayList<PhoneBook>();  
	 sqlConnection myConnection = new sqlConnection();
	 myConnection.openConnection();
	 listOfNumbers = myConnection.SelectAll();
	 myConnection.closeConnection();
	 return listOfNumbers;
 }
 public List<PhoneBook> createNumberList2()  
 {  
PhoneBook fadiOne=new PhoneBook(11, "Fadi" , "1" );  
PhoneBook fadiTwo=new PhoneBook(2, "Fadi" , "2");  
PhoneBook fadiThree=new PhoneBook(3, "Fadi" , "3");  
PhoneBook fadiFour=new PhoneBook(4, "Fadi" , "4");  
  
  List<PhoneBook> listOfNumbers = new ArrayList<PhoneBook>();  
  listOfNumbers.add(fadiOne);  
  listOfNumbers.add(fadiTwo);  
  listOfNumbers.add(fadiThree);  
  listOfNumbers.add(fadiFour);  
  
  //Add select from DB
  
  try
  {
      //Class.forName("net.sourceforge.jtds.jdbc.Driver");
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  
      //Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/SQLEXPRESS;databaseName=PhoneBookDB","sa","P@ssw0rd");

	  Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PhoneBookDB;user=sa;password=P@ssw0rd");

      PhoneBook fadiFive=new PhoneBook(5, "Fadi" , "5");  
	  listOfNumbers.add(fadiFive);  

      //System.out.println("connected");
      String sql="select * from tbData";      
      Statement st=conn.createStatement();      
      ResultSet rs=st.executeQuery(sql);
      
      while(rs.next())
      {
    	  int selectedID = rs.getInt("ID");
    	  String selectedName = rs.getString("Name");
    	  String selectedNumber = rs.getString("PhoneNumber");
    	  
    	  PhoneBook fadiSix=new PhoneBook(selectedID, selectedName , selectedNumber);  
    	  listOfNumbers.add(fadiSix);  

      }
      
	  if(st!=null)
	      st.close();
	      if(conn!=null)
	          conn.close(); 
  }
  catch (SQLException e)
  {
	  PhoneBook fadiSix=new PhoneBook(6, "Fadi_SQLException: " + e.getMessage() , "6");  
	  listOfNumbers.add(fadiSix); 
      //e.printStackTrace();
  }
  catch (ClassNotFoundException e) {
	// TODO: handle exception
	  PhoneBook fadiSix=new PhoneBook(6, "Fadi_ClassNotFound: " + e.getMessage() , "6");  
	  listOfNumbers.add(fadiSix); 
}
  
  //End Add select from DB
  
  return listOfNumbers;  
  
  
  
 }  
}  
