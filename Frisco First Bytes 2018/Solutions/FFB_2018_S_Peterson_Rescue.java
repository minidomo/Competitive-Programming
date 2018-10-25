
import java.io.*;
import java.util.*;


/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_S_Peterson_Rescue {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("S3.txt"));
        
        int Maw = scan.nextInt();
        int Hero = scan.nextInt() + scan.nextInt() + scan.nextInt();
        
        if(Hero< Maw)
            System.out.println("The time stone is lost!");
        else if (Hero > Maw *2)
            System.out.println("Aiee!");
        else
            System.out.println("We win!");
        
    }
}
