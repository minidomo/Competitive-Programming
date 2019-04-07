
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//working for sample input
//working for judge's input
public class FFB_2018_O_Bunn_SimpleCypher 
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("O.txt"));

		int N = in.nextInt(); in.nextLine();

		for (int i = 0; i < N; i++) 
			System.out.println(decrypt(in.nextInt(), in.nextLine()));

		in.close();
	}

	public static String decrypt(int key, String line)
	{
		char[] chars = line.trim().toCharArray();

		for (int i = 0; i < chars.length; i++) 
		{
			if (chars[i] == ' ') //skip spaces
				continue;

			chars[i] += key;

			if (chars[i] < 'A') 
				chars[i] += 26;

			if (chars[i] > 'Z') 
				chars[i] -= 26;
		}

		return String.valueOf(chars);
	}
}
