import java.util.*;
import java.io.*;

public class L
{
    public static void main(String[] args) throws IOException
    {
    	Scanner input = new Scanner(new File("L.txt"));

		ArrayList<HashSet<String>> circles = new ArrayList<>();

		while(input.hasNext())
		{
			String name1 = input.next();
			String name2 = input.next();

			int name1FoundIn = -1;
			int name2FoundIn = -1;
			for(int k = 0; k < circles.size(); k++)
			{
				if(circles.get(k).contains(name1))
					name1FoundIn = k;
				if(circles.get(k).contains(name2))
					name2FoundIn = k;
			}
			if(name1FoundIn ==-1 && name2FoundIn == -1) //pair not found in any circle
			{
				//create a circle
				HashSet<String> circle = new HashSet<>();
				circle.add(name1);
				circle.add(name2);
				circles.add(circle);
			}
			else if(name1FoundIn == -1 )
			{
				circles.get(name2FoundIn).add(name1);
			}
			else if(name2FoundIn == -1)
			{
				circles.get(name1FoundIn).add(name2);
			}
			else if(name1FoundIn != name2FoundIn)
			{
				HashSet circle1 = circles.remove(name1FoundIn);
				HashSet circle2 = circles.get(name2FoundIn);
				circle2.addAll(circle1);
			}

			if(!input.hasNextLine())
				System.out.println(circles.size());
		}

    }
}
