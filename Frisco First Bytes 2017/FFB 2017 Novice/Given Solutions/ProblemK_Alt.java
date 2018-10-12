import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2017 Sept
 */
public class ProblemK_Alt {

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("snipchit.txt"));

        int n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            String one = scan.next();
            String two = scan.next();

            int start = one.length()-two.length();
            if(start<0)
                start = 0;
            String answer = one+two;
            for(int j = start; j <one.length(); j++ )
            {
                String part1 = one.substring(j);
                String part2 = two.substring(0, one.length()-j);
                if(part1.equals(part2))
                {
                    answer = one.substring(0,j)+two.substring(one.length()-j);
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
