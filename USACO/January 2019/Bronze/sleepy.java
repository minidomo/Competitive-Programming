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
        dc.write(max + "");
        dc.close();
        sc.close();
    }
}