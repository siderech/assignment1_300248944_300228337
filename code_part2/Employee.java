public class Employee {
	private String name; 
	private int hours; 
	private double rate; 
	private Address [] arrayAddresses; 
	private int spot; 

	public Employee (String name, int hours, double rate){
		this.name= name; 
		this.hours= hours; 
		this.rate= rate; 

		arrayAddresses= new Address[5];
		spot= 0; 
	}

	public void add (Address newadd){
		arrayAddresses[spot]= newadd; 
		spot++; 
	}

	public String getName(){
		return name; 
	}

	public int getHours(){
		return hours; 
	}

	public double getRate(){
		return rate; 
	}

	

}