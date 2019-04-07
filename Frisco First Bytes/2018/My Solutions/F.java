import java.io.*;
import java.util.*;

// same as https://open.kattis.com/problems/pebblesolitaire
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("F.txt")));
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(sc.readLine());
        while (cases-- > 0) {
            char[] arr = sc.readLine().toCharArray();
            boolean left = false, right = false;
            while (!left) {
                left = true;
                for (int x = 0; x < arr.length - 2; x++) {
                    if (arr[x] == '-' && arr[x + 1] == 'o' && arr[x + 2] == 'o') {
                        arr[x] = 'o';
                        arr[x + 1] = arr[x + 2] = '-';
                        left = false;
                    }
                    if (arr[x] == 'o' && arr[x + 1] == 'o' && arr[x + 2] == '-') {
                        arr[x + 2] = 'o';
                        arr[x] = arr[x + 1] = '-';
                        right = false;
                    }
                }
            }
            int count = 0;
            for (char c : arr)
                count++;
            dc.write(count + "\n");
        }

        dc.close();
        sc.close();
    }
}