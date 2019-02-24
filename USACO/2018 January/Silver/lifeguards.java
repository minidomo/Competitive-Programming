import java.io.*;
import java.util.*;

public class lifeguards {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("lifeguards.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("lifeguards.out")));
        int n = Integer.parseInt(sc.readLine());
        Pair[] arr = new Pair[n << 1];
        for (int x = 0; x < n; x++) {
            String[] line = sc.readLine().split(" ");
            arr[x << 1] = new Pair(Integer.parseInt(line[0]), x);
            arr[(x << 1) + 1] = new Pair(Integer.parseInt(line[1]), x);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.time - b.time;
            }
        });
        int total = 0, lastTime = 0;
        int[] alone = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (Pair a : arr) {
            if (set.size() == 1)
                alone[set.first()] += a.time - lastTime;
            if (!set.isEmpty())
                total += a.time - lastTime;
            if (set.contains(a.index))
                set.remove(a.index);
            else
                set.add(a.index);
            lastTime = a.time;
        }
        int max = 0;
        for (int a : alone)
            max = Math.max(max, total - a);
        dc.write(max + "\n");
        dc.close();
        sc.close();
    }
}

class Pair {
    int time, index;

    public Pair(int t, int i) {
        time = t;
        index = i;
    }
}