
import java.io.*;
import java.util.*;


/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_P_Peterson_Happy {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("P.txt"));
        
        int N = scan.nextInt();
        
        for (int i = 0; i < N; i++)
        {
            int num = scan.nextInt();
            
            int temp = num;
            
            Set<Integer> set = new HashSet<>();
            set.add(temp);
            while (temp != 1 )
            {
                temp = sumOfSqDigits(temp);
                if(!set.add(temp))
                    break;
            }
            
            if(temp == 1)
                System.out.println(num + " is happy");
            else
                System.out.println(num + " is sad");
        }
        
    }

    private static int sumOfSqDigits(int temp) {
        int sum = 0;
        while(temp>0)
        {
            sum += (temp%10) * (temp%10);
            temp /= 10;
        }
        return sum;
    }
}
