
import java.io.*;
import java.util.*;


/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_R_Peterson_HowMany {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("R2.txt"));
        
        int attackers = scan.nextInt();
        
        if(attackers>12)
            System.out.println("They've broken through!");
        else
            System.out.println("All is well.");
    }
}
