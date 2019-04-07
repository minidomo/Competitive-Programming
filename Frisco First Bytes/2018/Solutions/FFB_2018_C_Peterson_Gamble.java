
import java.io.*;
import java.util.*;


/**
 *
 * @author Mrs.Peterson 
 * @version Sept 2018
 */
public class FFB_2018_C_Peterson_Gamble {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C.txt"));
        int testNum = 1;

	while(sc.hasNextInt())
	{
		System.out.println("Test Case "+testNum + ":");
		testNum++;
        	int N = sc.nextInt();
	        int M = sc.nextInt();
	        int min = Math.min(N, M);
        	int max = Math.max(N, M);
        
	        for(int i = min + 1; i < max + 1; i++)
	        {
        	    System.out.println(i);
        	}
	}
    }
}
