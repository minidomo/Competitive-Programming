/**
 * @(#)R.java
 *
 *
 * @author 
 * @version 1.00 2016/10/15
 */

import java.util.*;


public class R {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	int n = scan.nextInt();
    	
    	for (int i = 1; i <= n; i++)
    	{
    		int num = scan.nextInt();
    		
    		int sum = 0;
    		
    		sum = (num / 3) * 35;
    		
    		if (num % 3 == 1)
    			sum = sum + 20;
    		else if (num % 3 == 2)
    			sum = sum + 30;
    			
    		System.out.println("Captain, in " + num + " hops we will go " + sum + " light years.");
    	}
    	
    }
    
    
}