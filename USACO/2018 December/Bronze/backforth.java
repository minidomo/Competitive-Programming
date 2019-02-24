import java.io.*;
import java.util.*;

public class backforth {
    private static HashSet<Integer> values = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("backforth.in")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("backforth.out")));
        // BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> barn1 = new ArrayList<>();
        ArrayList<Integer> barn2 = new ArrayList<>();
        for (String s : sc.readLine().split(" "))
            barn1.add(Integer.parseInt(s));
        for (String s : sc.readLine().split(" "))
            barn2.add(Integer.parseInt(s));
        for (int x = 0; x < 10; x++)
            sim(1000, x, 0, new ArrayList<>(barn1), new ArrayList<>(barn2));
        dc.write(values.size() + "\n");
        dc.close();
        sc.close();
    }

    private static void sim(int currentVal, int index, int count, ArrayList<Integer> a, ArrayList<Integer> b) {
        if (count == 4) {
            values.add(currentVal);
            return;
        }
        if (count % 2 == 0) {
            b.add(a.remove(index));
            for (int x = 0; x < b.size(); x++)
                sim(currentVal - b.get(b.size() - 1), x, count + 1, new ArrayList<>(a), new ArrayList<>(b));
        } else {
            a.add(b.remove(index));
            for (int x = 0; x < a.size(); x++)
                sim(currentVal + a.get(a.size() - 1), x, count + 1, new ArrayList<>(a), new ArrayList<>(b));
        }
    }
}