/**
 * Frisco First Bytes, October 2018.
 * Problem T.Yggdrasil
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_T_Page_Yggdrasil
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("T.txt"));
        
        double totalDist = 0;

        int xFrom = kb.nextInt();
        int yFrom = kb.nextInt();
        int zFrom = kb.nextInt();
        kb.nextLine();
        for(int i=0; i<8; i++)
        {
            int xTo = kb.nextInt();
            int yTo = kb.nextInt();
            int zTo = kb.nextInt();
            kb.nextLine();
                        
            double dist = Math.sqrt( 
                      (xTo - xFrom)*(xTo - xFrom)
                    + (yTo - yFrom)*(yTo - yFrom)
                    + (zTo - zFrom)*(zTo - zFrom));
            totalDist += dist;
            
            xFrom = xTo;
            yFrom = yTo;
            zFrom = zTo;
        }
        int total = (int)Math.round(totalDist);
        System.out.println("The tour is " + total + " rost.");
        
    }
}
