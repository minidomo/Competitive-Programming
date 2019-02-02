#include <bits/stdc++.h>

typedef long long ll;

using namespace std;

int len = 0, pos = 0;

bool rec(ll size, ll cur) {
    if (cur <= 0)
        return false;
    if (cur > 0 && cur <= len) {
        pos = cur - 1;
        return true;
    }
    while (size > 0)
        if (rec(size >>= 1, cur == size + 1 ? size : cur - size - 1))
            return true;
    return false;
}

int main() {
    freopen("cowcode.in", "r", stdin);
    freopen("cowcode.out", "w", stdout);
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    string word;
    ll idx;
    cin >> word >> idx;
    len = word.length();
    ll power = ceil(log2(idx / (double)len)) + 1;
    ll MAX = (ll)(len * pow(2, power - 1));
    rec(MAX, idx);
    cout << word[pos];
    return 0;
}