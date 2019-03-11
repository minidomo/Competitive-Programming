import java.io.*;
import java.util.*;

public class Elevator {
    private static ArrayList<Integer> a;
    private static int max;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().split(",");
            max = Integer.parseInt(arr[0]);
            a = new ArrayList<>(arr.length - 1);
            for (int x = 0; x < arr.length - 1; x++)
                a.add(Integer.parseInt(arr[x + 1]));
            Collections.sort(a, Collections.reverseOrder());
            int count = 0;
            while (!a.isEmpty()) {
                subsetSum();
                count++;
            }
            System.out.println(count);
        }
        sc.close();
    }

    private static void subsetSum() {
        boolean[][] dp = new boolean[a.size() + 1][max + 1];
        for (int r = 0; r < dp.length; r++)
            dp[r][0] = true;
        int MAX = -1;
        int[] parent = new int[max + 1];
        Arrays.fill(parent, -1);
        for (int r = 1; r < dp.length; r++) {
            int num = a.get(r - 1);
            dp[r][num] = true;
            if (parent[num] == -1)
                parent[num] = r - 1;
            for (int c = 1; c < dp[r].length; c++) {
                dp[r][c] |= dp[r - 1][c];
                if (c >= num)
                    dp[r][c] |= dp[r - 1][c - num];
                if (dp[r][c]) {
                    MAX = Math.max(MAX, c);
                    if (!dp[r - 1][c])
                        parent[c] = r - 1;
                }
            }
        }
        int i = parent[MAX];
        while (MAX > 0)
            i = parent[MAX -= a.remove(i)];
    }
}