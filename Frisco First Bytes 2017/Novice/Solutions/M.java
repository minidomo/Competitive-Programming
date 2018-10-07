import java.util.*;
import java.io.*;

public class M {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("miles.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            String[] tokens = sc.readLine().split(" ");
            int hours = Integer.parseInt(tokens[0]);
            int mins = Integer.parseInt(tokens[1]);
            int sec = Integer.parseInt(tokens[2]);
            double total = ((11 - hours) * 3600) + ((59 - mins) * 60) + (60 - sec);
            double miles = 17.74;
            int mph = (int) Math.round(miles / (total / 3600));
            int kmh = (int) Math.round(miles * 1.60934 / (total / 3600));
            dc.write("If you leave at " + String.join(" ", tokens) + " pm, you will need to go " + mph + " mph or "
                    + kmh + " km/h\n");
            dc.flush();
        }

        dc.close();
        sc.close();
    }
}