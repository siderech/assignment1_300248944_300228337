/* * 
 * This class constructs Employee objects and contains the necessary functions to display an Employee's info
 * 
 * @author Sadie Sider-Echenberg, 300248944
 */

import java.util.*;  // to use the Arrays.toString method

public class Employee {
	private String name; 
	private int hours; 
	private double rate; 
	private Address [] arrayAddresses; 

	public Employee (String name, int hours, double rate, Address[] arrayAddresses){ // variables all employees have 
		this.name= name; 
		this.hours= hours; 
		this.rate= rate; 
		this.arrayAddresses= arrayAddresses; 

	}


	public String toString(){ // to string for testing purposes 

		String arString= Arrays.toString(arrayAddresses); 

		String full = "Employee:"+"\n"+"name- "+name+"\n"+"hours- "+hours+"\n"+"rate- "+rate+"\n"+"address(s)- "+ arString; 
		return full; 
	}
	
}