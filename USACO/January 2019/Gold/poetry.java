import java.io.*;
import java.util.*;

public class poetry {
    private static int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("poetry.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("poetry.out")), 1 << 16);
        String[] arr = sc.readLine().split(" ");
        int N, M, K;
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        K = Integer.parseInt(arr[2]);
        Word[] words = new Word[N];
        for (int x = 0; x < N; x++) {
            arr = sc.readLine().split(" ");
            int c, s;
            c = Integer.parseInt(arr[0]);
            s = Integer.parseInt(arr[1]);
            words[x] = new Word(c, s);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int x = 0; x < M; x++) {
            char a = sc.readLine().charAt(0);
            map.put(a, map.containsKey(a) ? map.get(a) + 1 : 1);
        }
        long[] count = new long[K + 1];
        long[] ending = new long[N + 1];
        count[0] = 1;
        for (int x = 0; x <= K; x++)
            for (int c = 0; c < N; c++) {
                int syl = words[c].s + x;
                if (syl > K)
                    continue;
                if (syl == K)
                    ending[words[c].c] = (ending[words[c].c] + count[x]) % MOD;
                count[syl] = (count[syl] + count[x]) % MOD;
            }
        long ans = 1;
        for (int freq : map.values()) {
            long sum = 0;
            for (long num : ending)
                if (num != 0)
                    sum = (sum + fpow(num, freq)) % MOD;
            ans = ans * sum % MOD;
        }
        dc.write(ans + "");
        dc.close();
        sc.close();
    }

    private static long fpow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % MOD;
            b >>= 1;
            a = a * a % MOD;
        }
        return res;
    }
}

class Word {
    public int c, s;

    public Word(int a, int b) {
        s = a;
        c = b;
    }
}