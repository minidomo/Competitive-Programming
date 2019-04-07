#include <bits/stdc++.h>

using namespace std;

const int MOD = 1e9 + 7, MAXN = 1e6, MAXK = 50;

int T, N, K;
int dp[MAXN + 1], w[MAXK];

int ways() {
    memset(dp, 0, sizeof dp);
    dp[0] = 1;
    for (int n = 1; n <= N; n++)
        for (int k = 0; k < K; k++)
            if (w[k] <= n)
                dp[n] = (dp[n] + dp[n - w[k]]) % MOD;
    return dp[N];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> T;
    while (T--) {
        cin >> N >> K;
        for (int x = 0; x < K; x++)
            cin >> w[x];
        cout << ways() << '\n';
    }
    return 0;
}