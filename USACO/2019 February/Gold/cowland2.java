import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class cowland2 {

    private static int n, q, cnt = 0;
    private static int[] val, sz, idx;
    private static ArrayList<Integer>[] nodes;
    private static BIT tree;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("cowland.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("cowland.out")), 1 << 16);
        String[] tokens = sc.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        q = Integer.parseInt(tokens[1]);
        val = new int[n];
        sz = new int[n];
        idx = new int[n];
        nodes = new ArrayList[n];
        tree = new BIT(n);
        for (int x = 0; x < n; x++)
            nodes[x] = new ArrayList<>();
        tokens = sc.readLine().split(" ");
        for (int x = 0; x < n; x++)
            val[x] = Integer.parseInt(tokens[x]);
        for (int x = 1; x < n; x++) {
            tokens = sc.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]) - 1;
            int b = Integer.parseInt(tokens[1]) - 1;
            nodes[a].add(b);
            nodes[b].add(a);
        }
        LCA lca = new LCA(nodes, n);
        dfs(0, -1);
        while (q-- > 0) {
            tokens = sc.readLine().split(" ");
            int w = Integer.parseInt(tokens[0]);
            int a = Integer.parseInt(tokens[1]) - 1;
            int b = Integer.parseInt(tokens[2]);
            if (w == 1) {
                int index = idx[a];
                tree.update(index, val[a] ^ b);
                tree.update(index + sz[index], val[a] ^ b);
                val[a] = b;
            } else {
                dc.write((tree.query(idx[a]) ^ tree.query(idx[--b]) ^ val[lca.get(a, b)]) + "\n");
            }
        }
        dc.close();
        sc.close();
    }

    private static int dfs(int cur, int par) {
        int index = cnt++;
        idx[cur] = index;
        int size = 1;
        for (int x : nodes[cur])
            if (x != par)
                size += dfs(x, cur);
        tree.update(index, val[cur]);
        tree.update(index + size, val[cur]);
        return sz[index] = size;
    }
}

class LCA {
    private int[] depth;
    private int[][] p;
    private ArrayList<Integer>[] nodes;

    public LCA(ArrayList<Integer>[] nodes, int size) {
        depth = new int[size];
        p = new int[(int) (Math.log10(size) / Math.log10(2) + 1)][size];
        this.nodes = nodes; // reference
        build(0, 0, 0);
    }

    private void build(int node, int par, int d) {
        depth[node] = d;
        p[0][node] = par;
        for (int x = 1; x < p.length; x++)
            p[x][node] = p[x - 1][p[x - 1][node]];
        for (int x : nodes[node])
            if (x != par)
                build(x, node, d + 1);
    }

    public int get(int a, int b) {
        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        }
        int c = depth[a] - depth[b];
        for (int x = 0; x < p.length; x++)
            if ((c >> x & 1) == 1)
                a = p[x][a];
        if (a == b)
            return a;
        for (int x = p.length - 1; x >= 0; x--)
            if (p[x][a] != p[x][b]) {
                a = p[x][a];
                b = p[x][b];
            }
        return p[0][a];
    }
}

class BIT {
    private int size;
    private int[] val;

    public BIT(int size) {
        this.size = size + 1;
        val = new int[this.size];
    }

    public int query(int i) {
        int sum = 0;
        for (i++; i > 0; i -= i & -i)
            sum ^= val[i];
        return sum;
    }

    public void update(int i, int v) {
        for (i++; i < size; i += i & -i)
            val[i] ^= v;
    }
}