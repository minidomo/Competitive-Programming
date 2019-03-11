import java.io.*;
import java.util.*;

public class candyshop {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] val = { 3, 5, 50, 100, 10 };
        while (sc.hasNextLine()) {
            int a = (int) (100 * Double.parseDouble(sc.nextLine().substring(1).trim()));
            int[] dp = new int[a + 1];
            dp[0] = 1;
            for (int x = 0; x < 5; x++)
                for (int s = 0; s <= a; s++)
                    if (s + val[x] <= a)
                        dp[s + val[x]] += dp[s];
            System.out.println(dp[a]);
        }
        sc.close();
    }
}