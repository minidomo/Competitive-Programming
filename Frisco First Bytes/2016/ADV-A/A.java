import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("A.txt"));
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int want = s.nextInt();
			int[] stuff = new int[want+1];
			stuff[0] = 1;
			ArrayList<Integer> cur = new ArrayList<>();
			String line = s.nextLine();
			Scanner s2 = new Scanner(line);
			while(s2.hasNextInt()) cur.add(s2.nextInt());
			for (int j = 1; j <= want; j++) {
				for (int k = 0; k < cur.size(); k++) {
					int temp = cur.get(k);
					if (j-temp >= 0) {
						if (stuff[j-temp] >= 1){
							stuff[j] = Math.min(stuff[j-temp]+1, stuff[j]);
							if (stuff[j] == 0) {
								stuff[j] = stuff[j-temp]+1;
							}
						}

					}

				}
			}
			System.out.println(stuff[want]-1);
		}

	}

}
