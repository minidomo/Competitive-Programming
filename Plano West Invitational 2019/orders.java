import java.io.*;
import java.util.*;

// Solved by Jonathan Tung
// Solved during contest
public class orders {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        while (D-- > 0) {
            int i = sc.nextInt();
            double dol = sc.nextDouble();
            int c = sc.nextInt();
            int P = i - c;
            double B = .75 * c + 1.25 * i - dol;
            double S = .25 * c - 1.25 * i + dol;
            System.out.printf("%d krabby patties, %d coral bits, %d kelp shakes\n", P, (int) B, (int) S);
        }
    }
}