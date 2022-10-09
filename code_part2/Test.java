/* * 
 * This class tests the employee and address classes + their print methods 
 *
 * 
 * @author Sadie Sider-Echenberg, 300248944
 */

public class Test{
	
	public static void main(String[] args){
		Address one= new Address ("Queen", 48, "K1P1N2");
		Address two= new Address ("King Edward", 800, "K1N6N5");
		Address [] addys= new Address[5];

		addys[0]= one;
		addys[1]=(two); 
		Employee o1= new Employee ("Falcao", 40, 15.50, addys); 

		System.out.println (o1); 
	}
}