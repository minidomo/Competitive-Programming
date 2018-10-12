import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemM_Alt {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("miles.txt"));

        int midnight = 12*(60*60); //seconds

        int n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            int hours = scan.nextInt();
            int mins = scan.nextInt();
            int secs = scan.nextInt();

            int time = hours*(60*60)+mins*(60)+secs;

            int deltaTime = midnight-time;

            long speedMPH = Math.round((17.74*(60*60)) / (deltaTime));
            long speedKPH = Math.round((1.60934*17.74*(60*60))/ (deltaTime));
            System.out.print("If you leave at "+hours+" "+mins+" "+secs+" pm, ");
            System.out.println("you will need to go "+speedMPH+" mph or "+speedKPH+" km/h");
        }
    }
}
