import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * @title Solution for Frisco FirstBytes 2017 - Problem C
 * @author Team 'LEFT OUR BRAINS AT HOME' from Plano West Senior High
 */

public class C
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("C.txt"));
		int t = in.nextInt();
		loop: for (int i = 0; i < t; i++) {
			int r = in.nextInt();
			int c = in.nextInt();
			in.nextLine();
			char[][] arr = new char[r][c];
			for (int j = 0; j < r; j++)
				arr[j] = in.nextLine().toCharArray();
			boolean changed = true;
			while (changed) {
				changed = false;
				for (int j = 0; j < r - 1; j++) {
					for (int k = 0; k < c - 1; k++) {
						if (arr[j][k] == 'W' || arr[j + 1][k] == 'W' || arr[j][k + 1] == 'W' || arr[j + 1][k + 1] == 'W')
							continue;
						if (arr[j][k] == '.' && arr[j + 1][k] == '.' && arr[j][k + 1] == '.' && arr[j + 1][k + 1] == '.')
							continue;
						char now = arr[j][k];
						if (now != '.' && arr[j + 1][k] != '.' && arr[j + 1][k] != now)
							continue;
						if (now == '.' && arr[j + 1][k] != now)
							now = arr[j + 1][k];
						if (now != '.' && arr[j][k + 1] != '.' && arr[j][k + 1] != now)
							continue;
						if (now == '.' && arr[j][k + 1] != now)
							now = arr[j][k + 1];
						if (now != '.' && arr[j + 1][k + 1] != '.' && arr[j + 1][k + 1] != now)
							continue;
						arr[j][k] = '.';
						arr[j + 1][k] = '.';
						arr[j][k + 1] = '.';
						arr[j + 1][k + 1] = '.';
						changed = true;
					}
				}
			}
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (arr[j][k] != 'W' && arr[j][k] != '.') {
						System.out.println("no");
						continue loop;
					}
				}
			}
			System.out.println("yes");
		}
		in.close();
	}
}