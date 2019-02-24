#include <bits/stdc++.h>

using namespace std;

int main() {
    freopen("blist.in", "r", stdin);
    freopen("blist.out", "w", stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int N;
    cin >> N;
    int arr[N][1001];
    int minT = 1001, maxT = 0;
    memset(arr, 0, sizeof(arr[0][0]) * N * 1001);
    for (int r = 0; r < N; r++) {
        int a, b, buckets;
        cin >> a >> b >> buckets;
        minT = min(minT, a);
        maxT = max(maxT, b);
        for (int c = a; c <= b; c++)
            arr[r][c] = buckets;
    }
    int maxBuckets = 0;
    for (int c = minT; c <= maxT; c++) {
        int curBuckets = 0;
        for (int r = 0; r < N; r++)
            curBuckets += arr[r][c];
        maxBuckets = max(maxBuckets, curBuckets);
    }
    cout << maxBuckets;
    return 0;
}