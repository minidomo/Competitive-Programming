import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("B.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            int days = Integer.parseInt(sc.readLine().split(" ")[1]);
            // gauss formula with days added
            dc.write(caseNum + " " + ((days * (days + 1)) / 2 + days) + "\n");
        }

        dc.close();
        sc.close();
    }
}