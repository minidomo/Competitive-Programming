
import java.io.*;
import java.util.*;


/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_I_Peterson_Painting {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("I.txt"));
        
        int C = scan.nextInt();
        scan.nextLine();
        
        for(int c = 0 ; c < C; c++)
        {
            String color = scan.nextLine();
            int S = scan.nextInt();
            int length = 0;
            for(int s = 0 ; s < S ; s++)
            {
                length += scan.nextInt();
            }
            scan.nextLine();
            
            int sqInches = length * 120; //10 ft x 12 in/ft
            double sqFeet = sqInches/144.0;
            int gallons = (int)Math.ceil(sqFeet/400);
            
            System.out.println(gallons + " gallon(s) of " + color);
        }
    }
}
