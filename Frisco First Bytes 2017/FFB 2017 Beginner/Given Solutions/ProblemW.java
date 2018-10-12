import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemW {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("W.txt"));
        //Scanner scan = new Scanner(System.in);

        double maxCarats = -1;
        String maxClarity = "";
        while(true)
        {
            double carats = scan.nextDouble();
            if(carats == 0)
                break;
            String clarity = scan.next();

            if(carats>maxCarats && (clarity.equals("F") ||clarity.equals("VS")))
            {
                maxCarats = carats;
                maxClarity = clarity;
            }
        }

        System.out.println(maxCarats + " " + maxClarity);
    }
}
