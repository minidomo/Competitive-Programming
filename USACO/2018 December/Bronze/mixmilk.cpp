#include <bits/stdc++.h>

using namespace std;

int main() {
    freopen("mixmilk.in", "r", stdin);
    freopen("mixmilk.out", "w", stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int cap[3];
    int cur[3];
    for (int x = 0; x < 3; x++)
        cin >> cap[x] >> cur[x];
    for (int x = 0; x < 100; x++) {
        if (x % 3 == 0) {
            // pour 1 - 2
            int capacityAvailable = cap[1] - cur[1];
            if (cur[0] <= capacityAvailable) {
                cur[1] += cur[0];
                cur[0] = 0;
            } else {
                cur[1] = cap[1];
                cur[0] -= capacityAvailable;
            }
        } else if (x % 3 == 1) {
            // pour 2 - 3
            int capacityAvailable = cap[2] - cur[2];
            if (cur[1] <= capacityAvailable) {
                cur[2] += cur[1];
                cur[1] = 0;
            } else {
                cur[2] = cap[2];
                cur[1] -= capacityAvailable;
            }
        } else {
            // pour 3 - 1
            int capacityAvailable = cap[0] - cur[0];
            if (cur[2] <= capacityAvailable) {
                cur[0] += cur[2];
                cur[2] = 0;
            } else {
                cur[0] = cap[0];
                cur[2] -= capacityAvailable;
            }
        }
    }
    cout << cur[0] << '\n' << cur[1] << '\n' << cur[2];
    return 0;
}