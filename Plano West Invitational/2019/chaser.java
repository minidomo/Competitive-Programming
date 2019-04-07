import java.io.*;
import java.util.*;

// Solved by Jonathan Tung
// Solved during contest
public class chaser {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            double t = sc.nextDouble();
            double vp = sc.nextDouble();
            double vs = sc.nextDouble();
            double sqrt = Math.sqrt((2 * vs * vs * t - 2 * vp * vp * t) * (2 * vs * vs * t - 2 * vp * vp * t)
                    - (4 * (vp * vp - vs * vs) * (2 * vp * vp * t * t - vs * vs * t * t)));
            double top = -(2 * vs * vs * t - 2 * vp * vp * t);
            double bot = 2 * (vp * vp - vs * vs);
            double f = (top + sqrt) / bot;
            double s = (top - sqrt) / bot;
            double ans = Math.max(s, f);
            System.out.printf("%.7f\n", ans);
        }
    }
}