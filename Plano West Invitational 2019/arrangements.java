import java.io.*;
import java.util.*;

// Solved by JB Ladera
// Solved during contest
public class arrangements {
    private static long[] bit = new long[100002];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int x = 1; x <= 100000; x++)
            update(x, numFact(x));
        int N = sc.nextInt();
        while (N-- > 0)
            System.out.println(sum(sc.nextInt()));
    }

    private static void update(int i, int val) {
        for (i++; i < bit.length; i += i & -i)
            bit[i] += val;
    }

    private static long sum(int i) {
        long sum = 0;
        for (i++; i > 0; i -= i & -i)
            sum += bit[i];
        return sum;
    }

    private static int numFact(int num) {
        int count = 1;
        if ((num & 1) == 0) {
            int c = 0;
            while ((num & 1) == 0) {
                num >>= 1;
                c++;
            }
            count *= c + 1;
        }
        for (int x = 3; x <= num; x += 2) {
            if (num % x == 0) {
                int c = 0;
                while (num % x == 0) {
                    num /= x;
                    c++;
                }
                count *= c + 1;
            }
        }
        return count;
    }
}