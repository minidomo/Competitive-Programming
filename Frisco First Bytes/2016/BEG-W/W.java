/**
 * @(#)W.java
 *
 *
 * @author 
 * @version 1.00 2016/10/15
 */

import java.util.*;

public class W {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	String input = scan.next();
    	String output = scan.next();
    	
    	Scanner a = new Scanner(input);
    	Scanner b = new Scanner(output);
    	
    	int length = input.length();
    	
    	int sum = 0;
    	
    	String subA = "a";
    	String subB = "b";
    	
    	for (int i = 1; i <= length; i++)
    	{    		
    		int start = i - 1;
    		int finish = i;
    		
    		subA = input.substring(i-1, i);
    		subB = output.substring(start, finish);
    		
    		if (!subA.equalsIgnoreCase(subB))
    			sum++;
    	}
    	
    	System.out.println("There are " + sum + " differences between " + input + " and " + output + ".");
    }
    
    
}