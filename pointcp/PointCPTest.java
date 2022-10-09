// This file tests classes CP2 and CP3 (which both implemeent CP5)
// It was developed by modifying the original PointCPTest file 

import java.io.*;

/**
 * @author Sadie Sider-Echenberg
 */
public class PointCPTest
{
  //Class methods *****************************************************

  
  public static void main(String[] args)
  {
    PointCP point;
    PointCP5 runnablePoint;

    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, extract the 2 necessary coordinates to create CP2 and CP3 objects
    // If he did not, prompt the user for them.
    String type = args[0].toUpperCase().charAt(0)
    double coord_1 = Double.valueOf(args[1]).doubleValue()
    double coord_2 = Double.valueOf(args[2]).doubleValue()
    
    try
    {
      if (type == "P") {
        runnablePoint = PointCP2(coord_1, coord_2) // create a polar point object
      } else if (type == "C") {
        runnablePoint = PointCP3(coord_1, coord_2) //create a coordinate point object
      }
    }

    runTests(runnablePoint);// run tests with appropriate object 

    catch(Exception e)
    {
      // If we arrive here, it is because either there were no
      // command line arguments, or they were invalid
      if(args.length != 0)
        System.out.println("Invalid arguments on command line");

      try
      {
        point = getInput();

        char typeCoord = point.getTypeCoord();

        if (typeCoord == 'P') {
            runnablePoint = PointCP2(point.getRho(), point.getTheta()) // create a polar point object with vals given
         } else if (typeCoord == 'C') {
            runnablePoint =  PointCP3(point.getX(), point.getY())//create a coordinate point objects with coordinate values given
         } 

         runTests(runnablePoint); // run tests 
      }

      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
    }
  }

  private void runTests(PointCP5 point) { //method to run tests and make sure the 2 classe's methods work 
    System.out.println("\nYou entered:\n" + point);

    System.out.println("\nAfter asking to process a Cartesian:\n" + point);
    point.convertStorageToCartesian();

    System.out.println("\nAfter asking to process a Polar:\n" + point);
    point.convertStorageToPolar();
  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static PointCP getInput() throws IOException
  {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information
    
    //Information to be passed to the constructor
    char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++)
    {
      while (!(isOK))
      {
        isOK = true;  //flag set to true assuming input will be valid
          
        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          System.out.print("Enter the type of Coordinates you "
            + "are inputting ((C)artesian / (P)olar): ");
        }
        else // Second and third arguments
        {
          System.out.print("Enter the value of " 
            + (coordType == 'C' 
              ? (i == 1 ? "X " : "Y ")
              : (i == 1 ? "Rho " : "Theta ")) 
            + "using a decimal point(.): ");
        }

        // Get the user's input      
       
        // Initialize the buffer before we read the input
        for(int k=0; k<1024; k++)
        	buffer[k] = '\u0020';        
             
        System.in.read(buffer);
        theInput = new String(buffer).trim();
        
        // Verify the user's input
        try
        {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'C') 
              || (theInput.toUpperCase().charAt(0) == 'P')))
            {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            }
            else
            {
              coordType = theInput.toUpperCase().charAt(0);
            }
          }
          else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        }
        catch(Exception e)
        {
        	System.out.println("Incorrect input");
        	isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;
    }
    //Return a new PointCP object
    return (new PointCP(coordType, a, b));
  }
}