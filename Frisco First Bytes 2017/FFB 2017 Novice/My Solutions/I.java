import java.util.*;
import java.io.*;

public class I {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("middle.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(",");
            dc.write(tokens[1] + " " + tokens[3].substring(1).split(" ")[1] + "\n");
            dc.flush();
        }

        dc.close();
        sc.close();
    }
}