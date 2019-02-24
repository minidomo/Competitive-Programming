#include <bits/stdc++.h>

using namespace std;

int main() {
    freopen("hps.in", "r", stdin);
    freopen("hps.out", "w", stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n, h = 0, p = 0, s = 0;
    cin >> n;
    char arr[n];
    for (int x = 0; x < n; x++) {
        char c;
        cin >> c;
        arr[x] = c;
        if (c == 'P')
            p++;
        else if (c == 'H')
            h++;
        else if (c == 'S')
            s++;
    }
    int maxg = 0;
    int beforeAfterSum[n][6];
    int countH = 0, countP = 0, countS = 0;
    memset(beforeAfterSum, 0, sizeof beforeAfterSum);
    for (int x = 0; x < n; x++) {
        char c = arr[x];
        if (c == 'P') {
            countP++;
            beforeAfterSum[x][0] = countP + h - countH;
            beforeAfterSum[x][2] = countP + s - countS;
            maxg = max(maxg, max(beforeAfterSum[x][0], beforeAfterSum[x][2]));
        } else if (c == 'H') {
            countH++;
            beforeAfterSum[x][1] = countH + p - countP;
            beforeAfterSum[x][4] = countH + s - countS;
            maxg = max(maxg, max(beforeAfterSum[x][1], beforeAfterSum[x][4]));
        } else if (c == 'S') {
            countS++;
            beforeAfterSum[x][3] = countS + p - countP;
            beforeAfterSum[x][5] = countS + h - countH;
            maxg = max(maxg, max(beforeAfterSum[x][3], beforeAfterSum[x][5]));
        }
    }
    // PH HP PS SP HS SH
    cout << maxg;
    return 0;
}