package testFadi;

public class PhoneBook {
	int id;
	String personName;
	String phoneNumber;
	
	public PhoneBook(int i, String personName, String phoneNumber) {  
		  super();  
		  this.id = i;  
		  this.personName = personName;
		  this.phoneNumber = phoneNumber;
		 }  
		 public int getId() {  
		  return id;  
		 }  
		 public void setId(int id) {  
		  this.id = id;  
		 }  
		 public String getPersonName() {  
		  return personName;  
		 }  
		 public void setpersonName(String personName) {  
		  this.personName = personName;  
		 }   
		 public String getPhoneNumber()
		 {
			return phoneNumber; 
		 }
		 public void setphoneNumber(String phoneNumber)
		 {
			 this.phoneNumber = phoneNumber;
		 }
}
