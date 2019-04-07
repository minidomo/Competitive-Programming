/**
 * @(#)V.java
 *
 *
 * @author 
 * @version 1.00 2016/10/15
 */

import java.util.*;

public class V {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	int n = scan.nextInt();
    	final int janson = 46903;
    	final int chris = 45099;
    	final int alan = 60132;
    	
    	boolean jansonha = false;
    	boolean chrisha = false;
    	boolean alanha = false;
    	
    	for (int i = 1; i <= n; i++)
    	{
    		int num = scan.nextInt();
    		
    		if (num == janson)
    			jansonha = true;
    		else if (num == chris)
    			chrisha = true;
    		else if (num == alan)
    			alanha = true;
    	}
    	
    	if (jansonha)
    		System.out.println("Janson Janeway WILL be aboard.");
    	else
    		System.out.println("Janson Janeway will NOT be aboard.");
    		
    	if (chrisha)
    		System.out.println("Chris Sisko WILL be aboard.");
    	else
    		System.out.println("Chris Sisko will NOT be aboard.");
    		
    	if (alanha)
    		System.out.println("Alan Riker WILL be aboard.");
    	else
    		System.out.println("Alan Riker will NOT be aboard.");
    }
    
    
}