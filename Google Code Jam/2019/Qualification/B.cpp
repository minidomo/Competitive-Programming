#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cout << "Case #" << t << ": ";
        int N;
        string P;
        cin >> N >> P;
        string s;
        for (int x = 0; x < P.length(); x++)
            s += P[x] == 'E' ? 'S' : 'E';
        cout << s << '\n';
    }
    return 0;
}