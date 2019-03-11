import java.io.*;
import java.util.*;

public class dishes {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("dishes.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dishes.out")), 1 << 16);

        int N = Integer.parseInt(sc.readLine());
        if (N == 1) {
            dc.write('1');
            sc.close();
            dc.close();
            return;
        }
        ArrayList<Integer> bases = new ArrayList<>();
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        int top = 0, ans = N, cur = Integer.parseInt(sc.readLine());
        bases.add(cur);
        stacks.add(new Stack<>());
        stacks.get(0).push(cur);
        for (int x = 1; x < N; x++) {
            cur = Integer.parseInt(sc.readLine());
            if (cur < top) {
                ans = x;
                break;
            }
            boolean placed = false;
            for (int s = 0; s < bases.size() && !placed; s++) {
                int base = bases.get(s);
                if (cur < base) {
                    Stack<Integer> a = stacks.get(s);
                    while (cur > a.peek())
                        top = a.pop();
                    a.push(cur);
                    placed = true;
                }
            }
            if (!placed) {
                bases.add(cur);
                stacks.add(new Stack<>());
                stacks.get(stacks.size() - 1).push(cur);
            }
        }
        dc.write(ans + "");

        dc.close();
        sc.close();
    }
}