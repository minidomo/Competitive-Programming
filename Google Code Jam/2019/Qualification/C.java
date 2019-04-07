import java.io.*;
import java.util.*;
import java.math.*;

@SuppressWarnings("unchecked")
public class C {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sc.next();
            int L = sc.nextInt();
            BigInteger[] arr = new BigInteger[L];
            BigInteger[] g = new BigInteger[L + 1];
            for (int x = 0; x < L; x++)
                arr[x] = new BigInteger(sc.next());
            TreeSet<BigInteger> primes = new TreeSet();
            for (int x = 1; x < L; x++) {
                if (!arr[x].equals(arr[x - 1])) {
                    primes.add(g[x] = arr[x].gcd(arr[x - 1]));
                    primes.add(g[x - 1] = arr[x - 1].divide(g[x]));
                }
            }
            for (int x = 1; x < g.length; x++)
                if (g[x] == null && g[x - 1] != null)
                    primes.add(g[x] = arr[x - 1].divide(g[x - 1]));
            for (int x = g.length - 1; x >= 0; x--)
                if (g[x] == null && g[x + 1] != null)
                    primes.add(g[x] = arr[x].divide(g[x + 1]));
            TreeMap<BigInteger, Character> map = new TreeMap();
            int x = 0;
            for (BigInteger a : primes)
                map.put(a, (char) ('A' + x++));
            StringBuilder ans = new StringBuilder("Case #" + t + ": ");
            for (BigInteger a : g)
                ans.append(map.get(a));
            System.out.println(ans);
        }
    }
}