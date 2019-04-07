/**
 * @(#)U.java
 *
 *
 * @author 
 * @version 1.00 2016/10/15
 */

import java.util.*;

public class U {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	int numLines = scan.nextInt();
    	
    	int total = 0;
    	
    	for (int i = 1; i <= numLines; i++)
    	{
    		int num = scan.nextInt();
    		
    		for (int j = 1; j <= num; j++)
    		{
    			total = total + scan.nextInt();
    			
    		}
    	}
    	
    	System.out.println("Kirk changed what happened on " + total + " days.");
    }
    
    
}