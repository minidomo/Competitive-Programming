import java.io.*;
import java.util.*;

public class convention2 {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("convention2.in")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("convention2.out")));
//        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));
        int cows = Integer.parseInt(sc.readLine());
        Cow[] arr = new Cow[cows];
        for (int x = 0; x < cows; x++) {
            String[] line = sc.readLine().split(" ");
            arr[x] = new Cow(x, Long.parseLong(line[0]), Long.parseLong(line[1]));
        }
        Arrays.sort(arr, new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                return o1.startTime < o2.startTime ? -1 : o1.startTime > o2.startTime ? 1 : o1.id < o2.id ? -1 : o1.id > o2.id ? 1 : 0;
            }
        });
        PriorityQueue<Cow> line = new PriorityQueue<>(new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                return o1.id < o2.id ? -1 : o1.id > o2.id ? 1 : 0;
            }
        });
        long MAX = 0;
        int x = 0;
        while (x < cows || !line.isEmpty()) {
            Cow current = null;
            if (line.isEmpty()) {
                current = arr[x];
                for (x += 1; x < cows; x++)
                    if (arr[x].startTime == current.startTime) {
                        Cow c = arr[x];
                        c.startTime += c.waitTime = current.time;
                        MAX = Math.max(MAX, c.waitTime);
                        line.offer(c);
                    } else
                        break;
            } else {
                current = line.remove();
                int size = line.size();
                while (size-- > 0) {
                    Cow c = line.poll();
                    long val = current.startTime + current.time - c.startTime;
                    c.waitTime += val;
                    c.startTime += val;
                    MAX = Math.max(MAX, c.waitTime);
                    line.offer(c);
                }
            }
            for (; x < cows && arr[x].startTime < current.startTime + current.time; x++) {
                Cow c = arr[x];
                long val = current.startTime + current.time - c.startTime;
                c.waitTime += val;
                c.startTime += val;
                MAX = Math.max(MAX, c.waitTime);
                line.offer(c);
            }
        }
        dc.write(MAX + "");
        dc.close();
        sc.close();
    }

    private static class Cow {
        public long id, startTime, time, waitTime;

        public Cow(long a, long b, long c) {
            id = a;
            startTime = b;
            time = c;
            waitTime = 0;
        }

        public String toString() {
            return id + " " + startTime + " " + time;
        }
    }
}
