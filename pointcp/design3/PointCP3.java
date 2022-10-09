import java.lang.Math; 
/**
* @author Sadie Sider-Echenberg
* @author Faiqah Sikder
 * This class contains instances of coordinates in cartesian format.  It computes polar coordinates on demand but doesn't store them. 
 * It returns cartesian coordinates. 
 */
public class PointCP3 extends PointCP5{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) 
   */
  
  private double x; // Contains the current value of X

  private double y; // Contains the current value of Y
  
  //Constructors ******************************************************

  /**
   * Constructs a cartesian coordinate object
   */
  public PointCP3(double xOrRho, double yOrTheta)
  {
   
      this.x= xOrRho;
      this.y= yOrTheta;
   
  }
  
  //Instance methods **************************************************
 
  public double getX()
  {
   
      return x; 
  }
  
  public double getY()
  {
    
    return y; 
  }
  
  public double getRho()
  {

      return (Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)));
  }
  
  public double getTheta()
  {
   
      return Math.toDegrees(Math.atan2(this.y, this.x));
  }
  

  /**
   * Converts Cartesian coordinates to Polar coordinates. Doesn't store them! just returns
   */

  public PointCP2 convertStorageToPolar()
  {
      //Calculate RHO and THETA
      double temp = getRho();
      double yFromTheta = getTheta();
      double xFromRho = temp;
      
      //char typeCoord = 'P';  //Change coord type identifier

   
      return new PointCP2 (xFromRho, yFromTheta);
    
  }
  
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public PointCP3 convertStorageToCartesian()
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
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP3 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP3(
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as Cartesian [ " + getX()+ " "+ getY()+ " )"+ "\n"+ "Polar Form: [ "+getRho()+ " "+ getTheta()+" ]" +"\n";
}

}








