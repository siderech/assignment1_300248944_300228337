
/**
 * This class contains instances of coordinates in 
 * polar format.  It computes them on demand, but doesn't store them
 *
 */
public class PointCP2
{
  //Instance variables ************************************************

  /**
   * Contains P(olar) 
   */
  private char typeCoord;
  
  /**
   * Contains the current value of RHO 
   */
  private double rho;
  
  /**
   * Contains the current value of THETA
   */
  private double theta;
  
  
  //Constructors ******************************************************

  /**
   * Constructs a polar coordinate object, with a type identifier.
   */
  public PointCP2(char type, double xOrRho, double yOrTheta)
  {
    if(type != 'C' && type != 'P'){
      throw new IllegalArgumentException();
    }

    else if (type== 'C'){// they give type cartesian (must change to polar)
      this.rho= ( Math.sqrt( (xOrRho*xOrRho) + (yOrTheta*yOrTheta)) );
      this.theta= Math.atan2(yOrTheta, xOrRho); //returns quotient of arctan in radians
      this.theta= Math.toDegrees(this.theta); //convert to degrees 

    }

    else {
      this.rho= xOrRho;
      this.theta= yOrTheta; 
    }
    
    typeCoord = type;
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
   */
  public PointCP2 convertStorageToCartesian()
  {
      //Calculate X and Y using the get functions. 
  
      double yFromTheta = getY();
      double xFromRho = getX();
    
      typeCoord = 'C';  //update coord type 

      tmpPoint= new PointCP2 (typeCoord, xFromRho, yFromTheta);
      return tmpPoint; 
    }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP pointB)
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

    double newTheta= rotation+ theta; 

    return new PointCP2 ('P', newTheta, rho); 
        
  
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates of this Polar point 
   */
  public String toString()
  {
    return ("Stored as Polar:[" + getRho() + "," + getTheta() + "]" + "\n");
  }
}