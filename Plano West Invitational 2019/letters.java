import java.io.*;
import java.util.*;

// Solved by Allen Wu
// Solved during contest
public class letters {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        String[] letters = new String[i];
        for (int x = 0; x < i; x++) {
            letters[x] = in.next().trim();
        }
        in.nextLine();
        String fullMessage = in.nextLine();
        int counter = 0;
        for (int y = 0; y < letters.length; y++) {
            int h = fullMessage.indexOf(letters[y]);
            if (h >= 0) {
                int end = h + letters[y].length();
                fullMessage = fullMessage.substring(0, h) + fullMessage.substring(end);
                counter++;
            }
        }
        if (counter == letters.length) {
            System.out.println("Potentially!");
        } else {
            System.out.println("No, No, No!!!");
        }
    }
}