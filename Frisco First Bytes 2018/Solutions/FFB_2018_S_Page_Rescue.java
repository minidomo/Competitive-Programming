/**
 * Frisco First Bytes, October 2018.
 * Problem S.Rescue
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_S_Page_Rescue
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("S.txt"));
        
        int maw = kb.nextInt();
        int strange = kb.nextInt();
        int stark = kb.nextInt();
        int spidey = kb.nextInt();
        int combined = strange + stark + spidey;
        if(combined < maw)
            System.out.println("The time stone is lost!");
        else if(combined > 2 * maw)
            System.out.println("Aiee!");
        else
            System.out.println("We win!");
       
    }
}
