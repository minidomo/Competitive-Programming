import java.io.*;
import java.util.*;

// Solved by JB Ladera
// Solved during contest
public class snooze {
    private static int A = 10;
    private static char[][] arr = new char[A][A];
    private static boolean[][] visit = new boolean[A][A];
    private static int dist[][] = new int[A][A];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int[] r : dist)
            Arrays.fill(r, Integer.MAX_VALUE);
        int startR = 0, startC = 0;
        int endR = 0, endC = 0;
        for (int r = 0; r < A; r++) {
            arr[r] = sc.nextLine().toCharArray();
            for (int c = 0; c < A; c++)
                if (arr[r][c] == 'S') {
                    startR = r;
                    startC = c;
                } else if (arr[r][c] == 'K') {
                    endR = r;
                    endC = c;
                }
        }
        bfs(startR, startC);
        int time = dist[endR][endC];
        if (time < 15)
            System.out.print("On time: " + time + " minutes");
        else
            System.out.print("Late: " + (time - 15) + " minutes");
    }

    private static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int count = cur[2];
            dist[r][c] = Math.min(dist[r][c], count);
            visit[r][c] = true;
            if (isValid(r - 1, c, count))
                q.add(new int[] { r - 1, c, count + 1 });
            if (isValid(r + 1, c, count))
                q.add(new int[] { r + 1, c, count + 1 });
            if (isValid(r, c - 1, count))
                q.add(new int[] { r, c - 1, count + 1 });
            if (isValid(r, c + 1, count))
                q.add(new int[] { r, c + 1, count + 1 });
        }
    }

    private static boolean isValid(int r, int c, int count) {
        if (r < 0 || r >= A || c < 0 || c >= A || arr[r][c] == '#' || arr[r][c] == 'S')
            return false;
        if (count + 1 < dist[r][c])
            return true;
        if (visit[r][c])
            return false;
        return true;
    }
}