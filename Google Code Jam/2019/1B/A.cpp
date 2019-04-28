#include <bits/stdc++.h>

using namespace std;

const int MAX = 1e5;
int X[MAX + 1], Y[MAX + 1];
int P, Q;

void upd(int a[], int i, int val) {
    for (; i <= Q + 1; i += i & -i)
        a[i] += val;
}

int qry(int a[], int i) {
    int sum = 0;
    for (; i > 0; i -= i & -i)
        sum += a[i];
    return sum;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        memset(X, 0, sizeof X);
        memset(Y, 0, sizeof Y);
        cout << "Case #" << t << ": ";
        cin >> P >> Q;
        while (P--) {
            int x, y;
            char d;
            cin >> x >> y >> d;
            x++;
            y++;
            if (d == 'N') {
                upd(Y, y + 1, 1);
            } else if (d == 'S') {
                upd(Y, 1, 1);
                upd(Y, y, -1);
            } else if (d == 'E') {
                upd(X, x + 1, 1);
            } else {
                upd(X, 1, 1);
                upd(X, x, -1);
            }
        }
        int maxX = 0;
        int maxY = 0;
        int v1 = -MAX;
        int v2 = -MAX;
        for (int x = 0; x <= Q; x++) {
            int a = qry(X, x + 1);
            if (a > v1) {
                v1 = a;
                maxX = x;
            }
            a = qry(Y, x + 1);
            if (a > v2) {
                v2 = a;
                maxY = x;
            }
        }
        cout << maxX << ' ' << maxY << '\n';
    }
    return 0;
}