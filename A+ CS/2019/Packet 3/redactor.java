import java.io.*;
import java.util.*;

public class redactor {

    private static int pos;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> R = new TreeMap<>();
        ArrayDeque<Integer> L = new ArrayDeque<>();
        String res = "";
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (s.startsWith("*")) {
                String[] a = s.substring(1).split("-");
                R.put(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
            } else {
                res += s += " ";
                L.offer(s.length());
            }
        }
        pos = 0;
        for (int q : R.keySet()) {
            int a = q;
            int b = R.get(q);
            String s = getRep(b - a + 1);
            res = res.substring(0, a) + s + res.substring(b + 1);
        }
        while (!L.isEmpty()) {
            int cur = L.poll();
            System.out.println(res.substring(0, cur));
            res = res.substring(cur);
        }
        sc.close();
    }

    private static String getRep(int len) {
        String re = "REDACTED";
        String res = "";
        for (int x = 0; x < len; x++) {
            if (pos == 8)
                pos = 0;
            res += re.charAt(pos++);
        }
        return res;
    }
}