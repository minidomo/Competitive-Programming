import java.io.*;
import java.util.*;

public class perimeter {
    private static char[][] arr;
    private static boolean[][] visit;
    private static int[] res = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("perimeter.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("perimeter.out")), 1 << 16);
        int N = Integer.parseInt(sc.readLine());
        arr = new char[N][N];
        visit = new boolean[N][N];
        Queue<int[]> points = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            String line = sc.readLine();
            for (int c = 0; c < N; c++) {
                arr[r][c] = line.charAt(c);
                if (arr[r][c] == '#')
                    points.add(new int[] { r, c });
            }
        }
        while (!points.isEmpty()) {
            int[] cur = points.poll();
            if (visit[cur[0]][cur[1]])
                continue;
            res[2] = res[3] = 0;
            calc(cur[0], cur[1]);
            if (res[2] > res[0]) {
                res[0] = res[2];
                res[1] = res[3];
            } else if (res[2] == res[0])
                res[1] = Math.min(res[1], res[3]);
        }
        dc.write(res[0] + " " + res[1]);
        dc.close();
        sc.close();
    }

    private static void calc(int r, int c) {
        if (r < 0 || r >= arr.length || c < 0 || c >= arr.length || arr[r][c] == '.') {
            res[3]++;
            return;
        }
        if (visit[r][c])
            return;
        visit[r][c] = true;
        res[2]++;
        calc(r, c - 1);
        calc(r, c + 1);
        calc(r - 1, c);
        calc(r + 1, c);
    }
}