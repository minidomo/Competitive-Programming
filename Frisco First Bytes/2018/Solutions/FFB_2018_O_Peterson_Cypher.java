
import java.io.*;
import java.util.*;

/**
 *
 * @author Christine Peterson
 * @version 2018
 */
public class FFB_2018_O_Peterson_Cypher {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("O.txt"));
        int N = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < N; i++) {
            int shift = scan.nextInt();
            String message = scan.nextLine().trim();
            String ans = "";
            for (int j = 0; j < message.length(); j++) {
                char c = message.charAt(j);
                if (c == ' ') {
                    ans += " ";
                } else {
                    c = (char)(c + shift);
                    if (shift > 0 && c > 90) {
                        c -= 26;
                    } else if (shift < 0 && c < 65) {
                        c += 26;
                    }
                    ans += (char) c;
                }
            }
            System.out.println(ans);
        }
    }
}
