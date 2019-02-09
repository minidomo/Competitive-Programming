import java.io.*;
import java.util.*;

// Solved by JB Ladera
// Solved during contest
public class krabbyland {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int MINAGE = sc.nextInt() * 365 + sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        while (P-- > 0) {
            sc.next();
            int val = sc.nextInt() * 365 + sc.nextInt();
            arr.add(val);
        }
        Collections.sort(arr, Collections.reverseOrder());
        int l = 0, u = arr.size() - 1;
        while (l <= u) {
            l++;
            u -= 2;
        }
        l--;
        int days = MINAGE - arr.get(l);
        int years = days / 365;
        days %= 365;
        if (days < 0 || years < 0) {
            days = 0;
            years = 0;
        }
        System.out.println(years + " year(s) and " + days + " day(s)");
    }
}