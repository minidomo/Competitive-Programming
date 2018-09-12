import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("C.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            String[] line = sc.readLine().split(" ");
            int base = Integer.parseInt(line[1]);
            String num = Integer.toString(Integer.parseInt(line[2]), base);
            double sum = 0;
            for (char c : num.toCharArray()) {
                int a;
                if (c >= 'a' && c <= 'f')
                    a = c - 'a' + 10;
                else
                    a = Integer.parseInt(c + "");
                sum += Math.pow(a, 2);
            }
            dc.write(caseNum + " " + (int) sum + "\n");
        }

        dc.close();
        sc.close();
    }
}