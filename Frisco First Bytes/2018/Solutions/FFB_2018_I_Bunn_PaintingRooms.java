
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//working for sample input
//working for judge input
public class FFB_2018_I_Bunn_PaintingRooms 
{
	static final int gallons = 400 * 144; //one gallon covers 400 sq ft, converted to in.

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("I.txt"));

		int C = in.nextInt(); //colors (trials)
		in.nextLine();
		
		for (int i = 0; i < C; i++)
		{
			String colorName = in.nextLine();

			int numMeasure = in.nextInt();
			
			int area = 0;
			
			for (int j = 0; j < numMeasure; j++)
				area += in.nextInt() * 120; //wall height is 10'

			System.out.println(area / gallons + 1 + " gallons of " + colorName);
			
			in.nextLine(); //so many!
		}
		in.close();
	}
}
