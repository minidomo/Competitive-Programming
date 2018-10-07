import java.util.*;
import java.io.*;

public class Q {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("map.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            char[][] arr = new char[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];
            boolean[][] check = new boolean[arr.length][arr[0].length];
            int count = 0;
            for (int r = 0, c = 0; r < arr.length; r++, c = 0) {
                for (char a : sc.readLine().replace(" ", "").toCharArray()) {
                    arr[r][c] = a;
                    if (arr[r][c] == '*') {
                        if (c > 1 && r > 0 && r < arr.length - 1)
                            check[r][c - 1] = arr[r][c - 2] == '*' && arr[r][c - 1] == '-' && arr[r - 1][c - 1] == '*';
                        if (r > 1 && c > 0 && c < arr[0].length - 1 && check[r - 1][c])
                            count++;
                    }
                    c++;
                }
            }
            dc.write((count > 0 ? count + " " : "No ") + "Portals Found\n");
        }

        dc.close();
        sc.close();
    }
}