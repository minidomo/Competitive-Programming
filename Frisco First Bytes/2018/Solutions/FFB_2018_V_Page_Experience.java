/**
 * Frisco First Bytes, October 2018.
 * Problem V. Experience
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_V_Page_Experience
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("V.txt"));
        
        long a = kb.nextLong();
        long b = kb.nextLong();
        long c = kb.nextLong();
        long d = kb.nextLong();
        long e = kb.nextLong();
        
        long totalSec = a + b + c + d + e;
        long totalMin = totalSec/60;
        long totalHours = totalMin/60;
        long totalDays = totalMin/24;
        long totalYears = totalDays/365;
        
        System.out.println("We've been fighting for " + totalYears + " years.");
       
    }
}
