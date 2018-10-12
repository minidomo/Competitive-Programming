import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2017 Sept
 */
public class ProblemO_Alt {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("fishLine.txt"));

        int n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            String line = scan.next();
            line = line.replaceAll("[^><~]", "");
            System.out.println("Line #"+(i+1)+" will produce "+line.length()+" Flotsam Fish Nuggets");

        }
    }
}
