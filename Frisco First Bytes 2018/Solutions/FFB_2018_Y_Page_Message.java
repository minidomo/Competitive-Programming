/**
 * Frisco First Bytes, October 2018.
 * Problem Y. The Message
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_Y_Page_Message
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("Y.txt"));
        
        String encoded = kb.nextLine();
        String decoded = "";
        
        int index = -1;
        while(index+2 < encoded.length())
        {
            decoded = decoded + encoded.charAt(index+2) + encoded.charAt(index+1);
            index += 2;
        }
        if(encoded.length() % 2 == 1)
            decoded = decoded + encoded.charAt(encoded.length()-1);
        
        System.out.println(decoded);
    }
}
