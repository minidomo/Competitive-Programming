#include <bits/stdc++.h>

using namespace std;

int cows[10000];
int N, MAX;

bool check(int k) {
    priority_queue<int, vector<int>, greater<int>> stage;
    int t = 0;
    for (int x = 0; x < N; x++) {
        if (stage.size() == k) {
            t = stage.top();
            stage.pop();
        }
        if (t + cows[x] > MAX)
            return false;
        stage.push(cows[x] + t);
    }
    return true;
}

int main() {
    freopen("cowdance.in", "r", stdin);
    freopen("cowdance.out", "w", stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> N >> MAX;
    for (int x = 0; x < N; x++) {
        cin >> cows[x];
    }
    int low = 0, high = 10001;
    while (low < high) {
        int mid = (low + high) / 2;
        if (check(mid))
            high = mid;
        else
            low = mid + 1;
    }
    cout << low;
    return 0;
}