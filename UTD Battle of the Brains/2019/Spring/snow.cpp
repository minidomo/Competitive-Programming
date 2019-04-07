#include <bits/stdc++.h>

using namespace std;

typedef long long LL;

const int MAX = 1e5;

struct quad {
    int a, b, h, t;
    bool operator<(quad a) { return t < a.t; }
    friend ostream &operator<<(ostream &out, quad &q) {
        out << "quad" << '(' << q.a << ' ' << q.b << ' ' << q.h << ' ' << q.t
            << ')';
        return out;
    }
};

struct tri {
    int x, t, idx;
    bool operator<(tri a) { return t < a.t; }
    friend ostream &operator<<(ostream &out, tri &q) {
        out << "tri" << '(' << q.x << ' ' << q.t << ' ' << q.idx << ')';
        return out;
    }
};

int N, Q;
LL arr[MAX + 1], ans[MAX];
quad A[MAX];
tri B[MAX];

void upd(int i, int val) {
    for (; i <= MAX; i += i & -i)
        arr[i] += val;
}

LL qry(int i) {
    LL sum = 0;
    for (; i > 0; i -= i & -i)
        sum += arr[i];
    return sum;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> N >> Q;
    for (int x = 0; x < N; x++)
        cin >> A[x].a >> A[x].b >> A[x].h >> A[x].t;
    sort(A, A + N);
    for (int x = 0; x < Q; x++) {
        cin >> B[x].x >> B[x].t;
        B[x].idx = x;
    }
    sort(B, B + Q);
    int a = 0, b = 0, t = 0;
    while (a < Q) {
        vector<tri> curs;
        vector<quad> times;
        t = B[a].t;
        curs.push_back(B[a++]);
        while (a < Q && B[a].t == t)
            curs.push_back(B[a++]);
        while (b < N && A[b].t <= t)
            times.push_back(A[b++]);
        for (quad q : times) {
            upd(q.a, q.h);
            upd(q.b + 1, -q.h);
        }
        for (tri q : curs)
            ans[q.idx] = qry(q.x);
    }
    for (int x = 0; x < Q; x++)
        cout << ans[x] << '\n';
    return 0;
}