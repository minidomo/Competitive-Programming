import java.util.*;
import java.io.*;

public class P {

    private static String status = "No Bonus";

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("wander.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int[][] arr = new int[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];
            int row = 0, col = 0;
            for (int r = 0, i = 0; r < arr.length; r++, i = 0)
                for (String s : sc.readLine().split(" ")) {
                    arr[r][i++] = Integer.parseInt(s);
                    if (arr[r][i - 1] == 1) {
                        row = r;
                        col = i - 1;
                    }
                }
            recur(arr, row, col, 0);
            dc.write(status + "\n");
            status = "No Bonus";
        }

        dc.close();
        sc.close();
    }

    private static void recur(int[][] arr, int row, int col, int prev) {
        if (row >= arr.length || col >= arr[0].length || row < 0 || col < 0)
            return;
        if (arr[row][col] != prev + 1)
            return;
        if (arr[row][col] == arr.length * arr[0].length) {
            status = "Bonus";
            return;
        }
        recur(arr, row - 1, col, arr[row][col]);
        recur(arr, row + 1, col, arr[row][col]);
        recur(arr, row, col - 1, arr[row][col]);
        recur(arr, row, col + 1, arr[row][col]);
    }
}