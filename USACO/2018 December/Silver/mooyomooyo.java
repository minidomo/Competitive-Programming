import java.io.*;
import java.util.*;

public class mooyomooyo {
    private static int k, n, count;
    private static int[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("mooyomooyo.in")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("mooyomooyo.out")));
//        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = sc.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        map = new int[n][10];
        visit = new boolean[n][10];
        for (int r = 0, c = 0; r < n; r++, c = 0) {
            for (char a : sc.readLine().toCharArray())
                map[r][c++] = a - '0';
        }
        boolean change = true;
        while (change) {
            change = false;
            for (int c = 0; c < 10; c++) {
                for (int r = n - 1; r >= 0; r--) {
                    if (map[r][c] == 0)
                        continue;
                    visit = new boolean[n][10];
                    count = 0;
                    check(r, c, map[r][c]);
                    if (count >= k) {
                        change = true;
                        remove(r, c, map[r][c]);
                    }
                }
            }
            if (change)
                gravity();
        }
        for (int[] r : map) {
            for (int c : r)
                dc.write(c + "");
            dc.write("\n");
        }
        dc.close();
        sc.close();
    }

    private static void gravity() {
        for (int c = 0; c < 10; c++) {
            boolean change = true;
            while (change) {
                change = false;
                for (int r = n - 1; r > 0; r--) {
                    if (map[r][c] == 0 && map[r - 1][c] != 0) {
                        change = true;
                        map[r][c] = map[r - 1][c];
                        map[r - 1][c] = 0;
                    }
                }
            }
        }
    }

    private static void check(int r, int c, int prev) {
        if (r < 0 || r == map.length || c < 0 || c == 10)
            return;
        if (map[r][c] != prev)
            return;
        if (visit[r][c])
            return;
        visit[r][c] = true;
        count++;
        check(r - 1, c, prev);
        check(r + 1, c, prev);
        check(r, c - 1, prev);
        check(r, c + 1, prev);
    }

    private static void remove(int r, int c, int prev) {
        if (r < 0 || r == map.length || c < 0 || c == 10)
            return;
        if (map[r][c] != prev)
            return;
        if (!visit[r][c])
            return;
        visit[r][c] = false;
        map[r][c] = 0;
        remove(r - 1, c, prev);
        remove(r + 1, c, prev);
        remove(r, c - 1, prev);
        remove(r, c + 1, prev);
    }
}
