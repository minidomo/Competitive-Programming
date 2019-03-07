import java.io.*;
import java.util.*;

public class cowland {
    private static HashMap<Integer, HashSet<Integer>> nodes;
    private static int[] e, parent;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("cowland.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("cowland.out")), 1 << 16);
        String[] tokens = sc.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]), Q = Integer.parseInt(tokens[1]);
        e = new int[N + 1];
        parent = new int[N + 1];
        nodes = new HashMap<>();
        tokens = sc.readLine().split(" ");
        for (int x = 1; x <= N; x++)
            e[x] = Integer.parseInt(tokens[x - 1]);
        for (int x = 1; x < N; x++) {
            tokens = sc.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]), b = Integer.parseInt(tokens[1]);
            if (!nodes.containsKey(a))
                nodes.put(a, new HashSet<>());
            if (!nodes.containsKey(b))
                nodes.put(b, new HashSet<>());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        bfs();
        while (Q-- > 0) {
            tokens = sc.readLine().split(" ");
            int q = Integer.parseInt(tokens[0]), i = Integer.parseInt(tokens[1]);
            if (q == 1) {
                e[i] = Integer.parseInt(tokens[2]);
            } else {
                int j = Integer.parseInt(tokens[2]);
                dc.write(dfs(i, j) + "\n");
            }
        }
        sc.close();
        dc.close();
    }

    private static void bfs() {
        HashSet<Integer> visit = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        visit.add(1);
        q.offer(1);
        parent[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int a : nodes.get(cur)) {
                if (visit.contains(a))
                    continue;
                parent[a] = cur;
                visit.add(a);
                q.offer(a);
            }
        }
    }

    private static int dfs(int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> dup = new HashSet<>();
        if (i == j)
            return 0;
        q.offer(i);
        q.offer(j);
        int total = 0;
        int a = -1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (a == -1 && dup.contains(cur))
                a = e[cur];
            total ^= e[cur];
            dup.add(cur);
            if (parent[cur] != 0)
                q.offer(parent[cur]);
        }
        return total ^ a;
    }
}