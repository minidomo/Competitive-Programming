import java.util.*;
import java.io.*;

public class G {
    public static void main(String[] args) throws Exception {
        // BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("G.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        for (int caseNum = 1; caseNum <= cases; caseNum++) {
            String[] line = sc.readLine().split(" ");
            int[] seq = new int[201];
            int[] modded = new int[201];
            seq[1] = Integer.parseInt(line[1]);
            seq[2] = Integer.parseInt(line[2]);
            int mod = Integer.parseInt(line[3]);
            modded[1] = seq[1] % mod;
            modded[2] = seq[2] % mod;
            Queue<Integer> lengths = new LinkedList<>();
            lengths.add(1);
            int maxLength = 1;
            for (int x = 3; x < seq.length; x++) {
                seq[x] = (seq[x - 1] % mod) + (seq[x - 2] % mod);
                modded[x] = seq[x] % mod;
                if ((x & 1) == 0) {
                    int current = checkLength(modded, x, maxLength);
                    if (current > maxLength) {
                        maxLength = current;
                        lengths.add(maxLength);
                    }
                }
            }
            lengths.add(100);
            while (!lengths.isEmpty()) {
                maxLength = lengths.poll();
                if (checkIfValid(modded, maxLength))
                    break;
            }
            dc.write(caseNum + " " + maxLength + "\n");
        }
        dc.close();
        sc.close();
    }

    private static boolean rec(int[] arr, int x, int length, int count) {
        if (count > length || x + length >= arr.length)
            return true;
        if (arr[x] != arr[x + length])
            return false;
        return rec(arr, x + 1, length, count + 1);
    }

    private static boolean checkIfValid(int[] arr, int length) {
        for (int x = 1; x < arr.length - length; x += length) {
            if (!rec(arr, x, length, 1))
                return false;
        }
        return true;
    }

    private static int checkLength(int[] arr, int lengthOfArray, int currentLength) {
        int half = lengthOfArray / 2;
        int count = 0;
        for (int x = currentLength; x < half; x++) {
            if (arr[x] == arr[half + x])
                count++;
            else
                break;
        }
        if (count + currentLength == half)
            return currentLength + count;
        return currentLength;
    }
}