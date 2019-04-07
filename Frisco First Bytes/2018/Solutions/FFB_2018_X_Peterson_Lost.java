
import java.io.*;
import java.util.*;

/**
 *
 * @author Mrs.Peterson
 * @version Sept 2018
 */
public class FFB_2018_X_Peterson_Lost {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("X.txt"));

        int n = sc.nextInt();
        int missing = 5;
        String names[] = "Adam Bambi Calvin Deb Ernie".split(" ");
        boolean isFound[] = new boolean[5];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            for (int j = 0; j < names.length; j++) {
                if (name.equals(names[j])) {
                    missing--;
                    isFound[j] = true;
                }
            }
        }
        System.out.println("Friends missing: " + missing);
        System.out.println("Friends found:");
        for (int j = 0; j < names.length; j++) {
            if (isFound[j]) {
                System.out.println("  " + names[j]);
            }
        }

    }
}
