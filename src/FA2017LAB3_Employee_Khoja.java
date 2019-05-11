
public class FA2017LAB3_Employee_Khoja
{ protected String name;  // key field
   protected String address;
   protected String employeeID;
   protected double salary;
   public FA2017LAB3_Employee_Khoja(){
	   
   }
   public FA2017LAB3_Employee_Khoja(String name, String employeeID , String address, double salary )
  {   this.name = name;
  	  this.employeeID = employeeID;
      this.address = address;
      this.salary = salary;
  }
   public String toString( )
   {   return("Name is : " + name +
		   "\nEmployee ID is : " + employeeID +
                    "\nAddress is : " + address + 
                    "\nSalary is : " + salary);
   }
   public FA2017LAB3_Employee_Khoja deepCopy( )
   {  FA2017LAB3_Employee_Khoja clone = new FA2017LAB3_Employee_Khoja(name, employeeID, address, salary);
      return clone;
   }
   public int compareTo(String targetKey)
   {  
	   return(employeeID.compareTo(targetKey));
   }
   public void setAddress(String a) // coded to demonstrate encapsulation
   {  address = a;
   }
   
   public void setSalary(double salary){
	   this.salary = salary;
   }
   
   public String getAddress(){
	   return address;
   }
 }// end of class Listing

