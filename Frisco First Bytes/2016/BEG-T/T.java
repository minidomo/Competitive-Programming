/**
 * @(#)T.java
 *
 *
 * @author 
 * @version 1.00 2016/10/15
 */

import java.util.*;

public class T {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	double me = scan.nextDouble();
    	double him = scan.nextDouble();
    	
    	if (him > me)
    	{
    		System.out.println("Salute him");
    		System.out.println((int) (him - me));
    	}
    		
		else
		{
			System.out.println("You are senior");
    		System.out.println((int) (me - him));
		}
    		
    }
    
    
}