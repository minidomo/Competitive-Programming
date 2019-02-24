import java.io.*;
import java.util.*;

public class sleepy {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("sleepy.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("sleepy.out")), 1 << 16);
        int N = Integer.parseInt(sc.readLine());
        int[] arr = new int[N];
        int i = 0;
        for (String s : sc.readLine().split(" "))
            arr[i++] = Integer.parseInt(s);
        int max = N - 1;
        while (max > 0 && arr[max] > arr[max - 1])
            max--;
        dc.write(max + "\n");
        BIT tree = new BIT(N + 1);
        for (int x = max; x < N; x++)
            tree.update(arr[x], 1);
        StringBuilder s = new StringBuilder();
        for (int x = 0; x < max; x++) {
            s.append(max - x - 1 + tree.sum(arr[x])).append(' ');
            tree.update(arr[x], 1);
        }
        dc.write(s.substring(0, s.length() - 1));
        dc.close();
        sc.close();
    }
}

class BIT {
    private int[] tree;
    private final int len;

    public BIT(int size) {
        len = size + 1;
        tree = new int[len];
    }

    public void update(int i, int val) {
        for (i++; i < len; i += i & -i)
            tree[i] += val;
    }

    public int sum(int i) {
        int sum = 0;
        for (i++; i > 0; i -= i & -i)
            sum += tree[i];
        return sum;
    }
}