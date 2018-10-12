import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2017 Sept
 */
public class ProblemI_Alt {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("middle.txt"));

        int n = scan.nextInt();
        scan.nextLine();

        for(int i = 0; i < n; i++)
        {
            String line = scan.nextLine();
            String middleLabel = line.split(", ")[1];
            String costs[] = line.split(" ");
            String middleCost = costs[costs.length-2];
            System.out.println(middleLabel + " "+ middleCost);
        }
    }
}
