import java.io.*;
import java.util.*;

// Solved by JB Ladera
// Solved during contest
public class establishment {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean[] notPrime = new boolean[15000];
        notPrime[0] = notPrime[1] = true;
        for (int x = 2; x * x < notPrime.length; x++)
            if (!notPrime[x])
                for (int a = x + x; a < notPrime.length; a += x)
                    notPrime[a] = true;
        int D = sc.nextInt();
        while (D-- > 0) {
            int x = sc.nextInt() + 1;
            while (notPrime[x])
                x++;
            System.out.println(x);
        }
    }
}