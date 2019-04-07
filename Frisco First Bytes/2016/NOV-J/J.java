import java.util.*;
import java.io.*;

public class J {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("J.txt"));
		
		int n = input.nextInt();
		
		for(int i = 0; i < n; i++) {
			int p = input.nextInt();
			input.nextLine();
			String[] name = new String[p];
			int[] place = new int[p];
			
			for(int j = 0; j < p; j++) {
				name[j] = input.nextLine();
				place[j] = Integer.parseInt(name[j].substring(name[j].length() - 1, name[j].length()));
				name[j] = name[j].substring(0, name[j].length() - 4);
				name[j] = place[j] + " - " + name[j];
			}
			int counter = 1;
			while(counter <= p) {
				for(int j = 0; j < place.length; j++) {
					if(place[j] == counter) {
						System.out.println(name[j]);
					}
				}
				counter++;
			}
			System.out.println();
		}
		
		
		input.close();	
	}

}
