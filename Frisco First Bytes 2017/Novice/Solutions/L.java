import java.util.*;
import java.io.*;

public class L {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("intList.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            Arrays.sort(tokens, (a, b) -> (a + b).compareTo(b + a));
            String big = "";
            for (String s : tokens) {
                dc.write(s);
                big = s + big;
            }
            dc.write(" " + big + "\n");
            dc.flush();
        }

        dc.close();
        sc.close();
    }
}