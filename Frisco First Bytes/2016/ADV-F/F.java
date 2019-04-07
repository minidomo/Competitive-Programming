import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class F {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("F.txt"));

        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            if(n == -1) break;

            grid = new long[n][n];
            memo = new long[n][n];
//            visited = new boolean[n][n];
            for(int r = 0; r < n; r++) {
                String t = sc.next();
                for(int c = 0; c < n; c++) {
                    grid[r][c] = t.charAt(c) - '0';
                    memo[r][c] = -1;
                }
            }

            out.printf("%d\n",dp(0,0));

        }
    }
    static long[][] grid;
//    static boolean[][] visited;
    static long[][] memo;
    static long dp(int r, int c) {
        if(memo[r][c] != -1) return memo[r][c];
        if(r == grid.length-1 && c == grid.length-1) return memo[r][c] = 1;
        if(grid[r][c]==0) return memo[r][c] = 0;
        int rr = r+(int)grid[r][c];
        int cc = c;
        long ans = 0;
        if(rr >= 0 && cc >= 0 && rr < grid.length && cc < grid.length) {
            ans += dp(rr,cc);
        }
        rr = r;
        cc = c+(int)grid[r][c];
        if(rr >= 0 && cc >= 0 && rr < grid.length && cc < grid.length) {
            ans += dp(rr,cc);
        }
        return memo[r][c] = ans;
    }
//    static void dfs(long r, long c) {
//        out.prlongf("%d, %d\n",r,c);
//        if(r == grid.length-1 && c == grid.length-1) {ans++; return;}
//        if(grid[r][c] == 0) return;
//        long rr = r + grid[r][c];
//        long cc = c;
////        visited[r][c] = true;
//        if(rr >= 0 && cc >= 0 && rr < grid.length && cc < grid.length) {
//            dfs(rr,cc);
//        }
//        rr = r;
//        cc = c + grid[r][c];
//        if(rr >= 0 && cc >= 0 && rr < grid.length && cc < grid.length) {
//            dfs(rr,cc);
//        }
////        visited[r][c] = false;
//    }
}