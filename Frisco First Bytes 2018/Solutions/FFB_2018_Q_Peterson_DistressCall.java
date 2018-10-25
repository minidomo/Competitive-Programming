
import java.io.*;
import java.util.*;


/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_Q_Peterson_DistressCall {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("Q.txt"));
        
        int N = scan.nextInt();
        
        System.out.println("Help! The Statesman is under attack! We have "+(1000-N)+" survivors.");
        
    }
}
