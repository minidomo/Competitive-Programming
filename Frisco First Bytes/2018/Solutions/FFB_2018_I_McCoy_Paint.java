import java.util.*;
import java.io.*;

public class FFB_2018_I_McCoy_Paint {
	public static void main(String[] args)	throws Exception {
		Scanner input = new Scanner(new File("I.txt"));
		int numOfCases	= input.nextInt();
		for (int caseNum = 1; caseNum <= numOfCases; caseNum++) {
			input.nextLine();  
			String color =	input.nextLine();
			int walls =	input.nextInt();
			int lengthTotal =	0;
			for (int w = 0; w < walls; w++) 
				lengthTotal	+=	input.nextInt();
			double area	= lengthTotal / 12.0	* 10;	//square	feet to paint
			int cans	= (int) Math.ceil(area/400);
			System.out.println(cans	+ " gallons of " + color);
		}
	}
}
