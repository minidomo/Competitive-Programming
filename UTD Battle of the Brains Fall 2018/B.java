import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] primes = new int[150000];
        for (int x = 2; x * x <= primes.length; x++)
            if (primes[x] == 0)
                for (int a = x + x; a < primes.length; a += x)
                    primes[a] = 1;

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int caseNum = Integer.parseInt(tokens[0]);
            int num = Integer.parseInt(tokens[1]);
            long sum1 = num * (num + 1) / 2;
            long sum2 = num * (1 + 1 + 2 * (num - 1)) / 2;
            long sum3 = num * (2 + 2 + 2 * (num - 1)) / 2;
            long sum4 = 0;
            if (num == 1)
                sum4 = 2;
            else if (num == 2)
                sum4 = 5;
            else {
                sum4 = 5;
                for (int x = 6, count = 2; count < num; x += 6) {
                    if (primes[x - 1] == 0) {
                        count++;
                        sum4 += x - 1;
                    }
                    if (count < num && primes[x + 1] == 0) {
                        count++;
                        sum4 += x + 1;
                    }
                }
            }
            dc.write(caseNum + " " + sum1 + " " + sum2 + " " + sum3 + " " + sum4 + "\n");
        }

        dc.close();
        sc.close();
    }
}