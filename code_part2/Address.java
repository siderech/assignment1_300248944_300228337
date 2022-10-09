/* * 
 * This class constructs Address objects and contains a toString method to display the information  
 * The toString method is called in the Employee classe's toString to print each address
 * 
 * @author Sadie Sider-Echenberg, 300248944
 */


public class Address {

	public String street; 
	private int number; 
	private String postal; 

	public Address (String street, int number, String postal){ // variables all addresses have 
		this.street= street; 
		this.number= number; 
		this.postal= postal; 
	}

	public String toString() {// to string for testing purposes 
		String ret = "Address: street- "+street+" number- "+number+" postal- "+postal+ "\n";
		return ret; 
	} 
	
}