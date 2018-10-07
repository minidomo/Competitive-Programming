import java.util.*;
import java.io.*;

public class O {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("fishLine.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int num = 1; num <= cases; num++) {
            int count = 0;
            String[] arr = sc.readLine().split("~");
            count += arr.length - 1;
            arr = String.join("", arr).split("<><");
            count += (arr.length - 1) * 3;
            arr = String.join("", arr).split("><>");
            count += (arr.length - 1) * 3;
            dc.write("Line #" + num + " will produce " + count + " Floatsam Fish Nuggets\n");
            dc.flush();
        }

        dc.close();
        sc.close();
    }
}