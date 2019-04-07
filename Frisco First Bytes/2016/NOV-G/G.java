import java.util.*;
import java.io.*;

public class G {

	static int ans;
	static int counter;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("G.txt"));
		
		int x = input.nextInt();
		String method;
		input.nextLine();
		
		while(x != 0) {
			
			ans = 0;
			counter = 0;
			
			for(int i = 0; i < x; i++) {
				method = input.nextLine();
				if(method.equals("touchdown")) {
					counter += 7;
					ans += counter;
				}
				else if(method.equals("field goal")) {
					counter += 3;
					ans += counter;
				}
				else {
					counter += 2;
					ans += counter;
				}
			}
			
			System.out.println("Ensign redshirt does " + ans + " pushups!");
			
			x = input.nextInt();
			if(x == 0)
				break;
			input.nextLine();
			
		}
		
		input.close();	
	}

}
