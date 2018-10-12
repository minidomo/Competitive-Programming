import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemX {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("X.txt"));
        //Scanner scan = new Scanner(System.in);

        double x = scan.nextDouble();
        double y = scan.nextDouble();

        double hypotenuse = Math.sqrt(x*x+y*y);
        System.out.println(Math.round(hypotenuse));
    }
}
