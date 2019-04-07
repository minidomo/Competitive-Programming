/**
 * Frisco First Bytes, October 2018.
 * Problem W. How Many Futures?
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_W_Page_HowManyFutures
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("W.txt"));
        
        int count = 0;
        int howMany = kb.nextInt();
        for(int i=0; i < howMany; i++)
        {
            int dead = kb.nextInt();
            if(dead == 0)
                count++;
        }
        System.out.println("Number of good futures = " + count);
    }
}
