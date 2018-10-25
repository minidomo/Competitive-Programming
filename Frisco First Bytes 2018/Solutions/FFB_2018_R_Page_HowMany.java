/**
 * Frisco First Bytes, October 2018.
 * Problem R.How Many Will It Take?
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_R_Page_HowMany
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("R.txt"));
        
        int attackers = kb.nextInt();
        if(attackers > 12)
            System.out.println("They've broken through!");
        else
            System.out.println("All is well.");
       
    }
}
