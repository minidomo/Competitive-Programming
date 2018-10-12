import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemS {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("S.txt"));
        //Scanner scan = new Scanner(System.in);

        int cageCapacity = scan.nextInt();
        int cagesNeeded = (int)Math.ceil(23.0/cageCapacity);
        System.out.println(cagesNeeded);
    }
}
