import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("A.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            String[] line = sc.readLine().split(" ");
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            int k = Integer.parseInt(line[3]);
            long val = Long.parseLong(line[4]);
            for (int x = k - 1; x >= 0; x--)
                val = (val - b) / a;
            dc.write(caseNum + " " + val + "\n");
        }

        dc.close();
        sc.close();
    }
}