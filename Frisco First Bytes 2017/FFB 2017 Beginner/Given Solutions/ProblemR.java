import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemR {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("R.txt"));
        //Scanner scan = new Scanner(System.in);

        int ships = scan.nextInt();
        int totalContainers = ships * 12000;
        System.out.println(totalContainers);
    }
}
