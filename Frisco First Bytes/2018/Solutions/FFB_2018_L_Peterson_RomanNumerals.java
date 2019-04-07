
import java.io.*;
import java.util.*;


/**
 *
 * @author Mrs.Peterson 
 * @version Sept 2018
 */
public class FFB_2018_L_Peterson_RomanNumerals {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("L.txt"));
        
        String values = "MDCLXVI";
        int dec [] = { 1000, 500, 100, 50, 10, 5, 1};
        
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++)
        {
            String n = sc.next();
            int sum = 0;
            int prev = Integer.MAX_VALUE;
            for(int j = 0; j < n.length(); j++)
            {
                int d = dec[values.indexOf(n.substring(j,j+1))];
                if(d>prev)
                    sum -= 2 * prev;
                sum += d;
                prev = d;
            }
            System.out.println(sum);
        }
    }
}
