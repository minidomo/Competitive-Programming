
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//working for sample input
//working for judge's input
public class FFB_2018_M_Bunn_Alphabetizing {

	public static void main(String[] args) throws IOException 
	{
		Scanner in = new Scanner(new File("M.txt"));

		int T = in.nextInt(); in.nextLine();

		List<Title> titles = new ArrayList<>();
		
		for (int i = 0; i < T; i++)
			titles.add(new Title(in.nextLine()));
		
		Collections.sort(titles);
		
		for (Title t : titles)
			System.out.println(t);
		
		in.close();
	}
}

class Title implements Comparable<Title>
{
	String original;
	String fixed;

	public Title(String original) {
		this.original = original;
		this.fixed    = original;
		this.fix();
	}

	/** remove punctuation, prepositions, etc. */
	private void fix()
	{
		if (this.original.substring(0, 2).equalsIgnoreCase("a ")) 
			this.fixed = this.fixed.substring(2);
		
		else if (this.original.substring(0, 3).equalsIgnoreCase("an ")) 
			this.fixed = this.fixed.substring(3);
		
		else if (this.original.substring(0, 4).equalsIgnoreCase("the ")) 
			this.fixed = this.fixed.substring(4);
		
		this.fixed = this.fixed.replaceAll("[ -'.]", "");   
	}

	@Override
	public int compareTo(Title other) {
		return this.fixed.compareTo(other.fixed);
	}
	
	@Override
	public String toString() {
		return this.original;
	}
}
