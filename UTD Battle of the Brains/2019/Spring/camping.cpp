#include <bits/stdc++.h>

using namespace std;

const int MAX = 50;

int P, N, M;
char arr[MAX][MAX];
int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy[] = {1, -1, 0, 0, -1, 1, -1, 1};

string solve() {
    for (int r = 0; r < N; r++) {
        for (int c = 0; c < M; c++) {
            if (arr[r][c] == 't') {
                for (int x = 0; x < 8; x++) {
                    int a = r + dx[x];
                    int b = c + dy[x];
                    if (a < 0 || b < 0 || a >= N || b >= M)
                        continue;
                    if (arr[a][b] == 't')
                        return "Invalid";
                }
            }
        }
    }
    return "Valid";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> P;
    while (P--) {
        cin >> N >> M;
        for (int r = 0; r < N; r++)
            for (int c = 0; c < M; c++)
                cin >> arr[r][c];
        cout << solve() << '\n';
    }
    return 0;
}