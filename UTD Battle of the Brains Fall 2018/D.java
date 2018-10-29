import java.io.*;
import java.util.*;

public class D {

    private static ArrayList<Pair> sol;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while (!(line = sc.readLine()).equals("0")) {
            String[] tokens = line.split(" ");
            String caseNum = tokens[0];
            long d = Long.parseLong(tokens[1]);
            long a = Long.parseLong(tokens[2]);
            long b = Long.parseLong(tokens[3]);
            long e = Long.parseLong(tokens[4]);
            long f = Long.parseLong(tokens[5]);
            sol = new ArrayList<>();
            if (hasSolutions(d, a, b)) {
                long max = Long.MAX_VALUE;
                Pair p = null;
                for (Pair w : sol) {
                    long val = w.x * e + w.y * f;
                    if (val < max) {
                        max = val;
                        p = w;
                    }
                }
                dc.write(caseNum + " " + p.x + " " + p.y + "\n");
            } else {
                dc.write(caseNum + " failed\n");
            }
        }

        dc.close();
        sc.close();
    }

    private static boolean hasSolutions(long d, long a, long b) {
        long lim = d / a;
        long lim2 = d / b;
        for (int x = 0; x <= lim; x++) {
            for (int y = 0; y <= lim2; y++) {
                if (a * x + b * y == d)
                    sol.add(new Pair(x, y));
            }
        }
        return sol.size() > 0;
    }

    private static class Pair {
        private long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}