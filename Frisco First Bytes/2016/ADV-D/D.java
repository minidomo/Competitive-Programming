import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class D {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("D.txt"));
		int cur = 0;
		while (s.hasNextLine()) {
			int n = s.nextInt();
			if (n== 0) break;
			cur++;
			System.out.println("year " + cur);
			
			String alph = s.next();
			ArrayList<String> words = new ArrayList<>();
			for (int i  = 0; i < n; i++) {
				words.add(s.next());
			}
			ArrayList<String> sorted = new ArrayList<>();
			sorted.add(words.get(0));
			for (int i = 1; i < words.size(); i++) {
				String want = words.get(i);
				boolean ever = false;
				for (int k = 0; k < sorted.size(); k++) {
					String inthere = sorted.get(k);
					boolean added = false;
					for (int q = 0; q < Math.min(inthere.length(), want.length()); q++) {
						if (alph.indexOf(inthere.charAt(q)) > alph.indexOf(want.charAt(q))) {
							sorted.add(k, want);
							added = true;
							break;
						}
						if (alph.indexOf(inthere.charAt(q)) < alph.indexOf(want.charAt(q))) {
							added = false;
							break;
						}
						if (q == Math.min(inthere.length(), want.length())-1) {
							if (want.length() < inthere.length()) {
								sorted.add(k, want);
								added = true;
								break;
							}
						}
					}
					if (added) {
						ever = true;
						break;
					}
				}
				if (!ever) sorted.add(want);
			}
			for (int i = 0; i < sorted.size(); i++) {
				System.out.println(sorted.get(i));
			}
		}

	}

}