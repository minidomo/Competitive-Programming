import java.io.*;
import java.util.*;

public class shortcut {
    private static ArrayList<Edge>[] nodes;
    private static int[] parent;
    private static long[] dist, cows;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("shortcut.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("shortcut.out")), 1 << 16);
        String[] arr = sc.readLine().split(" ");
        int N, M, T;
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        T = Integer.parseInt(arr[2]);
        nodes = new ArrayList[N + 1];
        dist = new long[N + 1];
        cows = new long[N + 1];
        parent = new int[N + 1];
        arr = sc.readLine().split(" ");
        for (int x = 1; x <= N; x++) {
            nodes[x] = new ArrayList<Edge>();
            cows[x] = Long.parseLong(arr[x - 1]);
        }
        for (int x = 0; x < M; x++) {
            arr = sc.readLine().split(" ");
            int a, b;
            long t;
            a = Integer.parseInt(arr[0]);
            b = Integer.parseInt(arr[1]);
            t = Long.parseLong(arr[2]);
            nodes[a].add(new Edge(b, t));
            nodes[b].add(new Edge(a, t));
        }
        dijkstra(1);
        long[] visit = new long[N + 1];
        for (int x = 1; x <= N; x++) {
            int cur = x;
            while (cur != 0) {
                visit[cur] += cows[x];
                cur = parent[cur];
            }
        }
        long max = 0;
        for (int x = 1; x <= N; x++)
            max = Math.max(max, (dist[x] - T) * visit[x]);
        dc.write(max + "");
        dc.close();
        sc.close();

    }

    private static void dijkstra(int source) {
        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[source] = 0;
        q.add(new Edge(source, 0));
        while (!q.isEmpty()) {
            Edge cur = q.remove();
            if (cur.weight > dist[cur.to])
                continue;
            for (Edge nxt : nodes[cur.to]) {
                long d = cur.weight + nxt.weight;
                if (d < dist[nxt.to]) {
                    parent[nxt.to] = cur.to;
                    q.add(new Edge(nxt.to, dist[nxt.to] = d));
                } else if (d == dist[nxt.to] && cur.to < parent[nxt.to]) {
                    parent[nxt.to] = cur.to;
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    public int to;
    public long weight;

    public Edge(int a, long b) {
        to = a;
        weight = b;
    }

    public int compareTo(Edge a) {
        return Long.compare(weight, a.weight);
    }

    public String toString() {
        return "(" + to + ", " + weight + ")";
    }
}