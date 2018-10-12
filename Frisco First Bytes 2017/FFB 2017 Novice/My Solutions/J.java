import java.util.*;
import java.io.*;

public class J {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("direction.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("N", 0);
        map.put("NE", 45);
        map.put("E", 90);
        map.put("SE", 90 + 45);
        map.put("S", 180);
        map.put("SW", 180 + 45);
        map.put("W", 270);
        map.put("NW", 270 + 45);

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int num1 = map.get(tokens[0]), num2 = map.get(tokens[1]);
            int min = Math.min(Math.abs(num1 - num2), Math.abs(num2 - num1));
            if (min > 180)
                min = 360 - min;
            dc.write(min + "\n");
            dc.flush();
        }

        dc.close();
        sc.close();
    }
}