/**
 * @(#)O.java
 *
 *
 * @author
 * @version 1.00 2016/10/15
 */

import java.util.*;

public class O {

    public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	int n = scan.nextInt();
    	final int numStrips = 17;

    	int remaining = numStrips - n;

    	System.out.println("Remaining latinum: " + remaining);
    }


}