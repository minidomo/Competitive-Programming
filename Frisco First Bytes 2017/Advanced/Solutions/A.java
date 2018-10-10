import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("A.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int max = Integer.parseInt(tokens[0]);
            int size = Integer.parseInt(tokens[1]);
            int[][] sums = new int[size][size];
            int most = 0, r = 0, c = 0;
            for (String s : sc.readLine().split(" ")) {
                int num = Integer.parseInt(s);
                sums[r][c] = num = num <= max ? num : 0;
                if (num > 0 && 1 > most)
                    most = 1;
                while (--r >= 0 && num > 0) {
                    if (sums[r][c - 1] == 0)
                        break;
                    int val = sums[r][c - 1] + num;
                    if (val <= max) {
                        sums[r][c] = val;
                        val = c + 1 - r;
                        if (val > most)
                            most = val;
                    } else
                        break;
                }
                r = ++c;
            }
            dc.write(most + "\n");
        }
        dc.close();
        sc.close();
    }
}