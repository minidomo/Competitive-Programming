import java.io.*;
import java.util.*;

// Solved by JB Ladera
// Solved during contest
public class cryptopwatty {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[] arr = new char['Z' + 1];
        String key = sc.nextLine();
        for (int x = 0; x < key.length(); x++)
            arr[(int) key.charAt(x)] = (char) ('A' + x);
        while (N-- > 0) {
            String s = sc.nextLine();
            for (int x = 0; x < s.length(); x++) {
                char c = s.charAt(x);
                System.out.print(Character.isLetter(c) ? arr[(int) c] : c);
            }
            System.out.println();
        }
    }
}