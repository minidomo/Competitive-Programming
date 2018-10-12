import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2017 Sept
 */
public class ProblemJ_Alt {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("direction.txt"));

        String [] directions = "N NE E SE S SW W NW".split(" ");

        int n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            String dir1 = scan.next();
            String dir2 = scan.next();

            int m;
            for( m = 0; m < directions.length; m++)
            {
                if(dir1.equals(directions[m]))
                    break;
            }
            int p;
            for( p = 0; p < directions.length; p++)
            {
                if(dir2.equals(directions[p]))
                    break;
            }
            int degrees = (Math.abs(m-p)*45);
            if (degrees>180)
                degrees = (360-degrees);
            System.out.println(degrees);
        }
    }
}
