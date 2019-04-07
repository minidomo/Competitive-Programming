import java.util.*;
import java.io.*;

public class J {

    private static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int caseNum = 1;; caseNum++) {
            int size = Integer.parseInt(sc.readLine());
            if (size == -1)
                break;
            min = Integer.MAX_VALUE;
            int[][] arr = new int[size][size];
            boolean[][] visit = new boolean[size][size];
            for (int r = 0, c = 0; r < size; r++, c = 0)
                for (char s : sc.readLine().toCharArray())
                    arr[r][c++] = s - '0';
            findJumps(arr, visit, 0, 0, 0);
            dc.write(caseNum + " " + (min == Integer.MAX_VALUE ? "No Path" : "" + min) + "\n");
        }

        dc.close();
        sc.close();
    }

    private static void findJumps(int[][] arr, boolean[][] visit, int row, int col, int count) {
        if (row >= arr.length || col >= arr.length)
            return;
        if (row == arr.length - 1 && col == arr.length - 1 && count < min)
            min = count;
        if (visit[row][col])
            return;
        visit[row][col] = true;
        findJumps(arr, visit, row + arr[row][col], col, count + 1);
        findJumps(arr, visit, row, col + arr[row][col], count + 1);
    }
}