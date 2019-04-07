import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader sc = new BufferedReader(new InputStreamReader(new
        // FileInputStream("E.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        for (int caseNum = 1; (line = sc.readLine()) != null; caseNum++) {
            String[] tokens = line.split(" ");
            long start = Long.parseLong(tokens[1]);
            int interval = Integer.parseInt(tokens[2]);
            final long STEPS = 2L + Integer.MAX_VALUE + Integer.MAX_VALUE;
            long sum = 0;
            int count = 0;
            while (start != 3) {
                count++;
                long diff = (long) Math.ceil((STEPS - start + 3) / (double) interval);
                sum += diff;
                dc.write("\t" + start + ", " + diff + ", " + count + "\n");
                start = (start % STEPS + (((diff % STEPS) * (interval % STEPS)) % STEPS)) % STEPS;
                dc.flush();
            }
            dc.write(caseNum + " " + sum + "\n");
            dc.flush();
            // (first - (4 * (terms-1))) % interval = 3
            // terms = (-(unknown * interval) - 3 + first)/4 + 1
        }

        dc.close();
        sc.close();
    }
}