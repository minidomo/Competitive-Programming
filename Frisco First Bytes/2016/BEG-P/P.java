/**
 * @(#)P.java
 *
 *
 * @author 
 * @version 1.00 2016/10/15
 */

import java.util.*;

public class P {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	int sum = 0;
    	
    	for (int i = 1; i <= 5; i++)
    	{
    		sum = sum + scan.nextInt();
    	}
    	
    	System.out.println();
    	
    	if (sum >= 100)
    		System.out.println("You passed! " + sum + " points");
    	else
    		System.out.println("See the Commandant! " + sum + " points");
    }
    
    
}