import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("B.txt"));
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int cur = s.nextInt();
			String player = s.next();
			if (cur%4==0) {
				if (player.equals("Jane")) {
					System.out.println("Joe wins");
				}
				else System.out.println("Jane wins");
			}
			else {
				if (player.equals("Jane")) {
					System.out.println("Jane wins");
				}
				else System.out.println("Joe wins");
			}
		}

	}

}