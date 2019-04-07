import java.io.*;
import java.util.*;

// mostly similar to https://open.kattis.com/problems/dicecup
public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("C.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        for (int caseNum = 1; (line = sc.readLine()) != null; caseNum++) {
            String[] tokens = line.split(" ");
            int a = Integer.parseInt(tokens[0]), b = Integer.parseInt(tokens[1]);
            int max = 0;
            int[] arr = new int[a + b + 1];
            for (int x = 1; x <= a; x++)
                for (int s = 1; s <= b; s++) {
                    arr[x + s]++;
                    if (arr[x + s] > max)
                        max = arr[x + s];
                }
            dc.write("Test Case " + caseNum + ":\n");
            for (int x = 1; x < arr.length; x++)
                if (arr[x] == max)
                    dc.write(x + "\n");
        }

        dc.close();
        sc.close();
    }
}