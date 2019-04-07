
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//working for sample input
//working for judge input
public class FFB_2018_J_Bunn_TreasureHunt 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("J.txt"));

		int N = in.nextInt();
		in.nextLine();

		for (int i = 0; i < N; i++) 
		{
			int rows = in.nextInt();
			int cols = in.nextInt();
			in.nextLine();

			int startR = 0, endR = 0, startC = 0, endC = 0; 

			for (int r = 0; r < rows; r++) 
			{
				String line = in.nextLine();

				for (int c = 0; c < cols; c++) 
				{
					if (line.charAt(c) == '*') {
						startR = r;
						startC = c;
					}
					if (line.charAt(c) == 'X') {
						endR = r;
						endC = c;
					}                                          
				}                          
			}

			String result = ""; 

			if (startR > endR)
				result += (startR - endR) + " north ";

			if (startR < endR)
				result += (endR - startR) + " south ";

			if (startC > endC)
				result += (startC - endC) + " west";

			if (startC < endC)
				result += (endC - startC) + " east";

			System.out.println(result);
		}
		in.close();
	}
}
