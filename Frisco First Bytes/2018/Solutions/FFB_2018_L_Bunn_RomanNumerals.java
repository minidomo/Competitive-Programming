
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//working with sample input
//working with judge's input
public class FFB_2018_L_Bunn_RomanNumerals 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("L.txt"));

		//add intermediate numbers to make roman strings prefix-free
		final int[] NUMBERS = {  1000, 900,500, 400,100,  90, 50, 40,  10,   9,  5,   4, 1};
		final String[] LETTERS = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

		while (in.hasNextLine())
		{
			String roman = in.nextLine(); //Roman String to convert

			int result = 0; //result of conversion to decimal

			while (roman.length() > 0) //loop while there are more letters to convert
			{
				for (int i = 0; i < LETTERS.length; i++)
				{
					if (LETTERS[i].length() <= roman.length() && roman.substring(0, LETTERS[i].length()).equals(LETTERS[i]))
					{
						result += NUMBERS[i];
						roman = roman.substring(LETTERS[i].length()); //truncate the converted letters
					}
				}
			}
			System.out.println(result);
		}
		
		in.close();
	}
}
