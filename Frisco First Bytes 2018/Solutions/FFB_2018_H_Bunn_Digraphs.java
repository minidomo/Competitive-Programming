
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//working for sample input
//working for judge's input
public class FFB_2018_H_Bunn_Digraphs {

	public static void main(String[] args) throws IOException 
	{
		String[] digraphs = {"sc", "ng", "ck", "ph", "sh", "th", "wh", "qu"}; 
		
		Scanner in = new Scanner(new File("H,txt"));
		
		int N = in.nextInt();
		in.nextLine(); //tricky! mix of token / line-based reading
		
		for (int i = 0; i < N; i++)
		{
			String line = in.nextLine();

			for (String d : digraphs)
				line = line.replaceAll("(?i)" + d, "__"); //don't know if most novices will know this method / regex...
			
			System.out.println(line);
		}
		
		in.close();
	}
}
