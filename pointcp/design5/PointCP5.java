/**
* @author Sadie Sider-Echenberg
* @author Faiqah Sikder
 * This abstract class contains all of the methods to be implemented in the children classes 
 * Both cartesian and polar point must implement these methods 
 */


public abstract class PointCP5 {
	
	protected double xOrRho; // CP2= rho, CP3= x
	protected double yOrTheta; // CP2= theta, CP3= y


	public abstract double getX (); 
	public abstract double getY();
	public abstract double getRho();
	public abstract double getTheta();
	public abstract PointCP3 convertStorageToCartesian(); // objects of class CP3 represents cartesian points, when convert to cartesian, always return type cartesian 
	public abstract PointCP2 convertStorageToPolar(); // objects of class CP2 represents polar points, when convert to polar always returns type polar
	public abstract double getDistance(PointCP5 pointB);
	public abstract PointCP5 rotatePoint(double rotation);
	public abstract String toString() ;
}