import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Execption {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] A = sc.nextLine().split(",");
            if (A[0].equals("62to10")) {
                int res = 0;
                for (int x = 0; x < A[1].length(); x++) {
                    int pow = (int) Math.pow(62, A[1].length() - x - 1);
                    char c = A[1].charAt(x);
                    if (c >= '0' && c <= '9')
                        res += pow * (c - '0');
                    else if (c >= 'A' && c <= 'Z')
                        res += pow * (c - 'A' + 10);
                    else
                        res += pow * (c - 'a' + 36);
                }
                System.out.println(res);
            } else {
                String res = "";
                int a = Integer.parseInt(A[1]);
                while (a > 0) {
                    int d = a % 62;
                    char c;
                    if (d < 10)
                        c = (char) (d + '0');
                    else if (d >= 10 && d <= 35)
                        c = (char) (d - 10 + 'A');
                    else
                        c = (char) (d - 36 + 'a');
                    res = c + res;
                    a -= d;
                    a /= 62;
                }
                System.out.println(res);
            }
        }
        sc.close();
    }
}