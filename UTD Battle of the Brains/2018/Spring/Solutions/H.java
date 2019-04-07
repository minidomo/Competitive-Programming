import java.util.*;
import java.io.*;

public class H {

    private static BufferedWriter dc;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            String[] line = sc.readLine().split(" ");
            int[][] arr = new int[3][];
            arr[0] = new int[Integer.parseInt(line[3])];
            arr[1] = new int[Integer.parseInt(line[2])];
            arr[2] = new int[Integer.parseInt(line[1])];
            arr[2][0] = 9;
            dc.write(arr[0].length + arr[1].length + arr[2].length - 1 + "\n");
            if (line.length == 6)
                bite(arr, 3 - Integer.parseInt(line[5]), Integer.parseInt(line[4]) - 1);
            dc.write("\n");
            printBar(arr);
            dc.write("\n");
        }

        dc.close();
        sc.close();
    }

    private static void bite(int[][] arr, int row, int col) {
        if (row < 0 || col >= arr[row].length)
            return;
        if (arr[row][col] == 1)
            return;
        arr[row][col] = 1;
        bite(arr, row, col + 1);
        bite(arr, row - 1, col);
    }

    private static void printBar(int[][] arr) throws Exception {
        for (int[] r : arr) {
            for (int c : r)
                dc.write(c + " ");
            dc.write("\n");
        }
    }
}
// 13
// 3 3 2 0
// 6 15 8 8
// 10 46 46 32
// 12 32 18 18
// 16 33 33 23
// 20 63 36 36
// 24 60 35 35
// 27 58 45 36
// 29 85 49 49
// 32 9 9 6
// 34 18 10 10
// 36 6 3 3
// 38 5 3 2