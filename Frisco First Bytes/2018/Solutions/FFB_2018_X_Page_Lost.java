/**
 * Frisco First Bytes, October 2018.
 * Problem X. Lost
 * Beginner Category
 * 
 * @author G. Page 
 * @version 4 Oct 2018
 */
import java.util.*;
import java.io.*;

public class FFB_2018_X_Page_Lost
{
    public static void main(String[] args)
        throws Exception
    {
        Scanner kb = new Scanner(System.in);
        //Scanner kb = new Scanner(new File("X.txt"));
        
        int found = 0;
        String friendsFoundMessage = "Friends found:\n";
        
        int foundListCount = kb.nextInt();
        kb.nextLine();
        for(int i=0; i < foundListCount; i++)
        {
            String name = kb.nextLine();
            switch(name)
            {
                case "Adam":
                    friendsFoundMessage += "  Adam" + "\n";
                    found++;
                    break;
                case "Bambi":
                    friendsFoundMessage += "  Bambi" + "\n";
                    found++;
                    break;
                case "Calvin":
                    friendsFoundMessage += "  Calvin" + "\n";
                    found++;
                    break;
                case "Deb":
                    friendsFoundMessage += "  Deb" + "\n";
                    found++;
                    break;
                case "Ernie":
                    friendsFoundMessage += "  Ernie" + "\n";
                    found++;
                    break;
                default: 
            }
        }
        
        System.out.println("Friends missing: " + (5 - found));
        System.out.println(friendsFoundMessage);
    }
}
