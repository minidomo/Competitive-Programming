import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] arr = new long[30][30];
        for (int c = 0; c < arr.length; c++)
            arr[0][c] = 1;

        for (int r = 1; r < arr.length; r++)
            for (int c = r; c < arr.length; c++)
                arr[r][c] = arr[r][c - 1] + arr[r - 1][c];

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int n = Integer.parseInt(tokens[1]) - 1;
            dc.write(tokens[0] + " " + arr[n][n] + "\n");
        }

        dc.close();
        sc.close();
    }
}