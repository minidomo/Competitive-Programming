import java.io.*;
import java.util.*;

public class mountains {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("mountains.in")), 1 << 16);
        BufferedWriter dc = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("mountains.out")), 1 << 16);
        int N = Integer.parseInt(sc.readLine());
        int count = 0;
        ArrayList<Mountain> arr = new ArrayList<>(N);
        while (N-- > 0) {
            String[] line = sc.readLine().split(" ");
            Mountain cur = new Mountain(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            boolean add = true;
            for (int x = 0; x < count; x++) {
                if (cur.covers(arr.get(x))) {
                    arr.remove(x--);
                    count--;
                } else if (arr.get(x).covers(cur)) {
                    add = false;
                    break;
                }
            }
            if (add) {
                count++;
                arr.add(cur);
            }
        }
        dc.write(count + "");
        dc.close();
        sc.close();
    }
}

class Mountain {
    public int x, y, b1, b2;

    public Mountain(int a, int b) {
        x = a;
        y = b;
        b1 = y - a;
        b2 = y + a;
    }

    public boolean covers(Mountain a) {
        if (a.x < x)
            return a.x + b1 >= a.y;
        else if (a.x > x)
            return -a.x + b2 >= a.y;
        else
            return y > a.y;
    }
}