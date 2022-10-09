import java.lang.Math; 
/**
 * @author Sadie Sider Echenberg 
 * @author Faiqah Sikder
/**
 * This class contains instances of coordinates in polar format.  It computes cartesian points on demand, but doesn't store them.
 */

public class PointCP2 extends PointCP5{
  //Instance variables ************************************************
 
  private double rho; //current value of rho
  
  private double theta; // current value of theta
  
  //Constructors ******************************************************

  /**
   * Constructs a polar coordinate object, with a type identifier.
   */
  public PointCP2(double xOrRho, double yOrTheta)
  {
   
      this.rho= xOrRho;
      this.theta= yOrTheta; 

  }
  
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
      return (Math.cos(Math.toRadians(theta)) * rho);
  }
  
  public double getY()
  {
      return (Math.sin(Math.toRadians(theta)) * rho);
  }
  
  public double getRho()
  {
    return rho; 
   
  }
  
  public double getTheta()
  {
    return theta; 
  }
  
  
  /**
   * Converts Polar coordinates of this point to Cartesian coordinates. 
   * Not supposed to store the cartesian coordinates based on classes description, just returns 
   */
  public PointCP3 convertStorageToCartesian()
  {
      //Calculate X and Y using the get functions. 
      
      double temp = getX();
      double yFromTheta = getY();
      double xFromRho = temp;
    
      //char typeCoord = 'C';  

      
      return (new PointCP3 (xFromRho, yFromTheta)); //returning this points coordinates in cartesian form 
    }


  public PointCP2 convertStorageToPolar()
  {
    return this; 
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP5 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   * Rotation a polar point is simple because we just have to add the degrees of rotation to theta
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */


  public PointCP2 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP2(
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates of this Polar point 
   */
  
    public String toString()
  {
    return "Stored as Polar [ "+getRho()+ " "+ getTheta()+" ]" +"\n"+ "Cartesian form: ("+ getX()+ " "
            + getY()+ " )"+ "\n"; 
      
  }
  
}







