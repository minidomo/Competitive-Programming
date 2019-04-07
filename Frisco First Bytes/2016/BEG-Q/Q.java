

/**
 * @(#)Q.java
 *
 *
 * @author 
 * @version 1.00 2016/10/15
 */


import java.util.*;


public class Q {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	int sum = 0;
    	
    	for (int i = 1; i <= 4; i++)
    	{
    		int n = scan.nextInt();
    		
    		if (n < 20)
    			sum = sum + n;
    		else if (n >= 20 && n < 40)
    			sum = sum + n * 2;
    		else 
    			sum = sum + n * 3;
    	}
    	
    	
    	System.out.println("Your trip will take " + sum + " credits.");
    }
    
    
}