#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int T;
    string N;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        cin >> N;
        cout << "Case #" << t << ": ";
        string a, b;
        bool leading = 1;
        for (int x = 0; x < N.length(); x++) {
            int c = N[x] - '0';
            if (c == 4) {
                a += to_string(3);
                b += to_string(1);
                leading = 0;
            } else {
                a += to_string(c);
                if (!leading)
                    b += to_string(0);
            }
        }
        if (leading)
            b = "0";
        cout << a + " " << b << '\n';
    }
    return 0;
}