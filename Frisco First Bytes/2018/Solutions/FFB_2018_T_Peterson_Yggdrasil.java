
import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_T_Peterson_Yggdrasil {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("T.txt"));

        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int z1 = scan.nextInt();
        scan.next();
        
        double distance = 0; 
        
        for (int i = 0; i < 8; i++) {
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int z2 = scan.nextInt();
            scan.next();
            distance += Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)+Math.pow(z2-z1, 2));
            
            x1 = x2;
            y1 = y2;
            z1 = z2;
        }
        System.out.println("The tour is "+Math.round(distance)+" rost.");
    }
}
