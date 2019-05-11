import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FA2017LAB3_EmployeeSystem_Khoja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FA2017LAB3_Employee_Khoja employee = new FA2017LAB3_Employee_Khoja();
		FA2017LAB3_UnsortedOptimizedArray_Khoja employeeData = new FA2017LAB3_UnsortedOptimizedArray_Khoja(10);
		
		String name;
		String employID;
		String address;
		double salaryRate;
		String title;
		int selection;
		String id = " ";
		Scanner reader = new Scanner(System.in);
		
		do{
		System.out.println("\t\t COMPANY XYZ - EMPLOYEES \n");
		System.out.println("\t\t 1.Insert \n");
		System.out.println("\t\t 2.Fetch \n");
		System.out.println("\t\t 3.Verify Encapsulation \n");
		System.out.println("\t\t 4.Delete \n");
		System.out.println("\t\t 5.Update \n");
		System.out.println("\t\t 6.Show All Employees \n ");
		System.out.print("Please enter your selection  :");
		selection = reader.nextInt();
		
		//JOptionPane.showMessageDialog(null, "The selection was " +selection);
		
		switch(selection){
		case 1 : {
					System.out.print("Does this employee have a title? (1 - Yes, 2 - No) : ");
				 selection = reader.nextInt();
				 reader.nextLine();
				 if(selection == 1){
					 System.out.print("Employee Name : ");
					 name = reader.nextLine();
					 System.out.print("Employee ID : ");
					 employID = reader.nextLine();
					 System.out.print("Employee Address : ");
					 address = reader.nextLine();
					 System.out.print("Employee Salary : ");
					 salaryRate = reader.nextDouble();
					 reader.nextLine();
					 System.out.print("Employee Title : ");
					 title = reader.nextLine();
					 FA2017LAB3_EmployeeWithTitle_Khoja employeeeee = new FA2017LAB3_EmployeeWithTitle_Khoja(name,employID,address,salaryRate,title);
					 employeeData.insert(employeeeee);
				 }
				 else if(selection == 2){
					 System.out.print("Employee Name : ");
					 name = reader.nextLine();
					 System.out.print("Employee ID : ");
					 employID = reader.nextLine();
					 System.out.print("Employee Address : ");
					 address = reader.nextLine();
					 System.out.print("Employee Salary : ");
					 salaryRate = reader.nextDouble();
					 reader.nextLine();
					 employee = new FA2017LAB3_Employee_Khoja(name,employID,address,salaryRate);
					 employeeData.insert(employee);
				 }
			}
		break;
		case 2 : {
				id = JOptionPane.showInputDialog("Enter the ID number of the Employee : ");
				if(employeeData.fetch(id) == null)
					JOptionPane.showMessageDialog(null, "Employee with ID " + id + " cannot be found");
				else
					JOptionPane.showMessageDialog(null, employeeData.fetch(id).toString());
				break;
				//JOptionPane.showMessageDialog(null,employeeData.fetch(ID).toString());
				}
		case 3 : {
					FA2017LAB3_Employee_Khoja temp1 = null;
					FA2017LAB3_Employee_Khoja temp2;
					id = JOptionPane.showInputDialog("Enter the ID number of the Employee : ");
					if(employeeData.fetch(id) == null)
						JOptionPane.showMessageDialog(null, "Employee with ID " + id + " cannot be found");
					else{
						temp1 = employeeData.fetch(id);
						temp1.setAddress("Address Changed");
						temp2 = employeeData.fetch(id);
						
						if(temp1.getAddress() != temp2.getAddress()) // if two objects address is different then encapsulated
							JOptionPane.showMessageDialog(null, "Unsorted Optimized Array Structure is encapsulated");
						else
							JOptionPane.showMessageDialog(null, "Unsorted Optimized Array Structure is unencapsulated");
					}
					break;
				}
		case 4 : {
			id = JOptionPane.showInputDialog("Enter the ID number of the Employee : ");
			if(employeeData.delete(id))
				JOptionPane.showMessageDialog(null, "Employ with ID : "+ id + " has been deleted.");
			else
				JOptionPane.showMessageDialog(null, "Employee with ID " + id + " cannot be found");
			break;
		}
		case 5 : {
			id = JOptionPane.showInputDialog("Enter the ID number of the Employee : ");
			String newAddress;
			double newSalary;
			int choice;
			
				if(employeeData.fetch(id) == null)
					JOptionPane.showMessageDialog(null, "Employee with ID " + id + " cannot be found");
				else{
					choice = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to change address or 2 to change the salary of the employ : "));
					if(choice == 1)
					{
						newAddress = JOptionPane.showInputDialog("Enter the new address of the employee " + id);
						employee = employeeData.fetch(id);
						employee.setAddress(newAddress);
					}
					else{
						newSalary = Integer.parseInt(JOptionPane.showInputDialog("Enter the new salary for the employee " + id + " : $"));
						employee = employeeData.fetch(id);
						employee.setSalary(newSalary);
					}
				}
				
				employeeData.update(id, employee);
				JOptionPane.showMessageDialog(null, employeeData.fetch(id).toString());
				break;
		}
		case 6 : 
				employeeData.showAll();
				break;
			
		}
		}while(selection != 0);
	}
}

