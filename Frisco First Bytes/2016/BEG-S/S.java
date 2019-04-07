/**
 * @(#)S.java
 *
 *
 * @author 
 * @version 1.00 2016/10/15
 */

import java.util.*;

public class S {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	
    	int finalX = scan.nextInt();
    	int finalY = scan.nextInt();
    	
    	int n = scan.nextInt();
    	
    	int x = 0;
    	int y = 0;
    	
    	for (int i = 1; i <= n; i++)
    	{
    		x = x + scan.nextInt();
    		y = y + scan.nextInt();
    	}

    	
    	int distanceX = finalX - x;
    	int distanceY = finalY - y;

		int distance = (int) Math.round(Math.sqrt(distanceX * distanceX + distanceY * distanceY));
    	
    	
    	
    	System.out.println(distance + " light-years away from destination");
    	
    }
    
    
}