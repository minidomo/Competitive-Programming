import java.util.*;
import java.io.*;

public class JTest {

    private static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("J.txt")));
        BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream("J.out")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        double fails = 0, total = 0;

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
            String myAnswer = caseNum + " " + (min == Integer.MAX_VALUE ? "No Path" : "" + min);
            String correct = check.readLine();
            boolean passed = myAnswer.equals(correct);
            if (!passed)
                fails++;
            total++;
            dc.write((passed ? "PASS" : "FAIL") + " -> " + myAnswer + " " + correct + "\n");
        }
        dc.write("Fail Rate: " + fails / total + "\n");

        dc.close();
        sc.close();
        check.close();
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