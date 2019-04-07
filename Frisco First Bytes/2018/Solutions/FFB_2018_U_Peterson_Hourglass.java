
import java.io.*;
import java.util.*;

/**
 *
 * @author Mrs.Peterson
 * @version Sept 2018
 */
public class FFB_2018_U_Peterson_Hourglass {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Z.txt"));
        
        int n = sc.nextInt();
        int stars = 0;
        int base = n*2 -1;
        for(int i = 0; i < n ; i++)
        {
            for(int j = 0; j < i; j++)
                System.out.print(" ");
            for(int k = 0; k < base; k++)
            {
                System.out.print("*");
                
            }
            stars += base;
            base-=2;
            System.out.println("");
        }
        int spaces = 1;
        for(int i = 0; i < n-2; i++)
        {
            for(int j = 0; j < n-i-2; j++)
            {
                System.out.print(" ");
            }
            System.out.print("*");
            for(int k = 0; k < spaces; k++)
                System.out.print(" ");
            spaces+=2;
            System.out.println("*");
            stars += 2;
        }
        for(int k = 0; k < n*2-1; k++)
            {
                System.out.print("*");
                
            }
        stars += n*2 -1;
        System.out.println("");
        System.out.println(stars);
    }
}
