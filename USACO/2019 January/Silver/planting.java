import java.io.*;
import java.util.*;

public class planting {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("planting.out")), 1 << 16);
        int N = Integer.parseInt(sc.readLine());
        int[] arr = new int[N + 1];
        int max = 0;
        String line;
        while ((line = sc.readLine()) != null) {
            String[] s = line.split(" ");
            max = Math.max(max, Math.max(++arr[Integer.parseInt(s[0])], ++arr[Integer.parseInt(s[1])]));
        }
        dc.write(max + 1 + "");
        dc.close();
        sc.close();
    }
}