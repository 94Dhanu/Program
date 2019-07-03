 
import java.util.Scanner;
 
public class WindChill
{
 
    public static void main(String[] args) {
         
     
        System.out.println("This Program Calculates Wind-chill Temperature.\n");
 
        
        Scanner input = new Scanner(System.in);
 
       
        System.out.println("Enter the outside temperature in Fahrenheit "
                + "(between -58 and 41 degrees):");
        double temperature = input.nextDouble();
        System.out.println("Enter the wind speed in miles per hour "
                + "(greater than or equal to 2 mph):");
        double speed = input.nextDouble();

        double windChillTemperature = 35.74 + (0.6215 * temperature) - (35.75
                * Math.pow(speed, 0.16)) + (0.4275 * temperature * Math.pow(speed, 0.16));
        windChillTemperature = (int) (windChillTemperature * 100000) / 100000.0;
 
        System.out.println("The area of the hexagon is " + windChillTemperature + "\n");
    }
}