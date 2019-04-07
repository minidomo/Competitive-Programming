import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("C.txt"));
		int n = s.nextInt();
		for (int q = 0; q < n; q++) {
			int M = s.nextInt();
			int P = s.nextInt();
			int[] intersect = new int[M+1];
			for (int i = 0; i < P; i++) {
				intersect[s.nextInt()]++;
				intersect[s.nextInt()]++;
			}
			boolean poss = true;
			for (int j = 0; j < intersect.length; j++) {
				if (intersect[j] % 2 == 1) {
					poss = false;
					break;
				}
			}
			if (poss) System.out.println("yes");
			else System.out.println("no");
		}
		
	}

}