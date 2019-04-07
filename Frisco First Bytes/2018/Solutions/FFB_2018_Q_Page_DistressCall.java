/**
 * Frisco First Bytes, October 2018.
 * Problem Q.Distress Call
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_Q_Page_DistressCall
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("Q.txt"));
        
        int casualties = kb.nextInt();
        
        System.out.println("Help! The Statesman is under attack! We have " + (1000 - casualties) + " survivors.");
       
    }
}
