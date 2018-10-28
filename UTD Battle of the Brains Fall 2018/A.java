import java.io.*;
import java.util.*;

public class A {

    private static char[][] arr;
    private static int MAX;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int p1 = 0, p2 = 0;
        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int cols = Integer.parseInt(tokens[0]);
            int rows = Integer.parseInt(tokens[1]);
            MAX = Integer.parseInt(tokens[2]);
            arr = new char[rows][cols];
            ArrayList<Point> x = new ArrayList<>();
            ArrayList<Point> o = new ArrayList<>();
            for (int r = 0, c = 0; r < rows; r++, c = 0) {
                for (char a : sc.readLine().toCharArray()) {
                    if (a == 'x') {
                        x.add(new Point(r, c));
                    } else if (a == 'o') {
                        o.add(new Point(r, c));
                    }
                    arr[r][c++] = a;
                }
            }
            boolean found1 = false;
            for (Point p : x) {
                if (find('x', p.r, p.c)) {
                    p1++;
                    found1 = true;
                    break;
                }
            }
            if (found1)
                continue;
            for (Point p : o) {
                if (find('o', p.r, p.c)) {
                    p2++;
                    break;
                }
            }
        }
        dc.write(p1 + ":" + p2);

        dc.close();
        sc.close();
    }

    private static boolean find(char c, int row, int col) {
        boolean up = generic(c, row, col, 1, -1, 0);
        if (up)
            return true;
        boolean down = generic(c, row, col, 1, 1, 0);
        if (down)
            return true;
        boolean left = generic(c, row, col, 1, 0, -1);
        if (left)
            return true;
        boolean right = generic(c, row, col, 1, 0, 1);
        if (right)
            return true;
        boolean leftDiag = generic(c, row, col, 1, 1, -1);
        if (leftDiag)
            return true;
        boolean rightDiag = generic(c, row, col, 1, 1, 1);
        if (rightDiag)
            return true;
        return false;
    }

    private static boolean generic(char c, int row, int col, int count, int rInc, int cInc) {
        if (row == arr.length || row < 0 || col < 0 || col == arr[row].length)
            return false;
        if (arr[row][col] == c) {
            if (count == MAX)
                return true;
            return generic(c, row + rInc, col + cInc, count + 1, rInc, cInc);
        }
        return false;
    }

    private static class Point {
        private int r, c;

        public Point(int row, int col) {
            r = row;
            c = col;
        }
    }
}