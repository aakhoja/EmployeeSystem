
public class FA2017LAB3_EmployeeWithTitle_Khoja extends FA2017LAB3_Employee_Khoja {

	protected String title;
	public FA2017LAB3_EmployeeWithTitle_Khoja() {
		// TODO Auto-generated constructor stub
	}
	
	public FA2017LAB3_EmployeeWithTitle_Khoja(String name, String employeeID, String address, double salary, String title){
		super(name,employeeID,address,salary);
		this.title = title; 
	}
	
	public FA2017LAB3_EmployeeWithTitle_Khoja deepCopy(){
		FA2017LAB3_EmployeeWithTitle_Khoja clone = new FA2017LAB3_EmployeeWithTitle_Khoja(name, employeeID, address, salary, title);
		
		return clone;
	}
	
	public String toString(){
		
		String s = super.toString() + 
					"\nTitle : " + title;
		
		return s;
	}

}
