import java.io.*;
import java.util.*;

// Solved by JB Ladera
// Solved after contest
public class primeshard {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean[] notPrime = new boolean[1000001];
        notPrime[0] = notPrime[1] = true;
        for (int x = 2; x * x < notPrime.length; x++)
            if (!notPrime[x])
                for (int a = x + x; a < notPrime.length; a += x)
                    notPrime[a] = true;
        int T = sc.nextInt();
        while (T-- > 0) {
            long num = sc.nextLong();
            sc.next();
            String[] arr = sc.nextLine().trim().split("\\sx\\s");
            boolean wrong = false;
            boolean[] used = new boolean[1000001];
            for (String s : arr) {
                int ar = Integer.parseInt(s);
                if (notPrime[ar]) {
                    if (wrong && !used[ar]) {
                        System.out.println(s + " is not a prime number.");
                        used[ar] = true;
                    } else if (!wrong) {
                        wrong = used[ar] = true;
                        System.out.println("WRONG!\n" + s + " is not a prime number.");
                    }
                }
            }
            StringBuilder d = new StringBuilder();
            if (wrong) {
                System.out.print(num + " = ");
                for (int x : getfact(num))
                    d.append(x + " x ");
            } else {
                System.out.print("correct!\n" + num + " = ");
                for (String s : arr)
                    d.append(s + " x ");
            }
            System.out.println(d.substring(0, d.length() - 3));
        }
    }

    private static ArrayList<Integer> getfact(long num) {
        ArrayList<Integer> facts = new ArrayList<>();
        while ((num & 1) == 0) {
            facts.add(2);
            num >>= 1;
        }
        for (int x = 3; x <= num; x += 2) {
            while (num % x == 0) {
                facts.add(x);
                num /= x;
            }
        }
        return facts;
    }
}