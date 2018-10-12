import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @title Solution for Frisco FirstBytes 2017 - Problem E
 * @author Team 'LEFT OUR BRAINS AT HOME' from Plano West Senior High
 */

public class E
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("E.txt"));
		while (in.hasNextLine()) {
			Scanner scan = new Scanner(in.nextLine());
			scan.next();
			ArrayList<Integer> race = new ArrayList<>();
			int n = scan.nextInt();
			for (int i = 0; i < n; i++)
				race.add(scan.nextInt());
			while (true) {
				scan = new Scanner(in.nextLine());
				String x = scan.next();
				if (x.equals("DROPOUT"))
					race.remove(Integer.valueOf(scan.nextInt()));
				else if (x.equals("OVERTAKE")) {
					int num = scan.nextInt();
					int ind = race.indexOf(num);
					race.set(ind, race.get(ind - 1));
					race.set(ind - 1, num);
				}
				else if (x.equals("PITSTOP")) {
					int num = scan.nextInt();
					race.remove(Integer.valueOf(num));
				}
				else if (x.equals("PITRETURN")) {
					int num = scan.nextInt();
					race.add(scan.nextInt(), num);
				}
				else if (x.equals("CRASH"))
					while (scan.hasNextInt())
						race.remove(Integer.valueOf(scan.nextInt()));
				else if (x.equals("END"))
					break;
			}
			for (int i = 0; i < race.size(); i++)
				System.out.print(i == race.size() - 1 ? race.get(i) + "\n" : race.get(i) + " ");
		}
		in.close();
	}
}