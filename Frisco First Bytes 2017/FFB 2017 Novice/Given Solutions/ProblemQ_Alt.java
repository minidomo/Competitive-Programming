import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemQ_Alt {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("map.txt"));

        int n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            int r =  scan.nextInt();
            int c =  scan.nextInt();
            char[][]grid = new char[r][c];

            for(int rr = 0; rr < r; rr++)
            {
                for(int cc = 0; cc < c; cc++)
                {
                    grid[rr][cc] = scan.next().charAt(0);
                }
            }
            int count = 0;
            for(int rr = 1; rr < r-1; rr++)
            {
                for(int cc = 1; cc < c-1; cc++)
                {
                    if (grid[rr-1][cc] =='*'&&
                        grid[rr+1][cc] =='*'&&
                        grid[rr][cc-1] =='*'&&
                        grid[rr][cc+1] =='*'&&
                        grid[rr][cc] == '-')
                    {
                        count++;
                    }
                }
            }
            if(count>0)
                System.out.println(count+" Portals Found");
            else
                System.out.println("No Portals Found");
        }
    }
}
