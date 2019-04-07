import java.io.*;
import java.util.*;

// Solved by Jonathan Tung
// Solved during contest
public class seashells {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0)
            System.out.println(ans(sc.nextInt(), sc.nextInt()));
    }

    private static String ans(int m, int n) {
        if (m + n < 10 || !(m % 2 == 1 && n % 2 == 0))
            return "CLOSED";
        return "OPEN";
    }
}