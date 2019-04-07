
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//working with sample input
//working with judge's input
public class FFB_2018_P_Bunn_HappyNumbers 
{
	public static void main(String[] args) throws IOException 
	{
		//System.out.println("WORKING");

		Scanner in = new Scanner(new File("P.txt"));

		int N = in.nextInt();

		for (int i = 0; i < N; i++)
		{
			int originalNum = in.nextInt();

			int currentNum  = 0;

			Set<Integer> previous = new HashSet<>();
			previous.add(originalNum);
			
			int copy = originalNum;

			boolean isHappy = false;

			while (!isHappy)
			{
				while (copy > 0) {
					currentNum += copy % 10 * (copy % 10); 
					copy /= 10;
				}

				if (currentNum == 1) 
					isHappy = true;

				else 
				{
					if (previous.contains(currentNum)) //infinite cycle, terminate early
						break;
					else
						previous.add(currentNum);
					
					copy = currentNum;
					currentNum = 0;
				}
			}
			
			if (isHappy)
				System.out.println(originalNum + " is happy");
			else
				System.out.println(originalNum + " is sad");
		}
		in.close();
	}
}
