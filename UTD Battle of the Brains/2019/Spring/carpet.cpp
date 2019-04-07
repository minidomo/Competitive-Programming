#include <bits/stdc++.h>

using namespace std;

int T, N, M;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> T;
    while (T--) {
        cin >> N >> M;
        cout << (int)(pow(ceil(sqrt(N * M)), 2)) << '\n';
    }
    return 0;
}