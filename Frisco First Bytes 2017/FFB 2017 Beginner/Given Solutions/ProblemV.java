import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2007 Oct
 */
public class ProblemV {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("V.txt"));
        //Scanner scan = new Scanner(System.in);

        int movieTimes = scan.nextInt();
        int totalAttendance = 0;
        for(int t = 0; t < movieTimes; t++)
        {
            int movies = scan.nextInt();
            for(int m = 0; m < movies; m++)
            {
                int attendees = scan.nextInt();
                totalAttendance += attendees;
            }
        }
        System.out.println("Mommoth Movie House had "+totalAttendance+" attendees today.");
    }
}
