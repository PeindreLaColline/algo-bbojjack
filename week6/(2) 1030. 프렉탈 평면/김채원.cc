#include <iostream>

using namespace std;

int s, N, K, R1, R2, C1, C2;

void input() {
    cin >> s >> N >> K >> R1 >> R2 >> C1 >> C2;
}

int solution(int len, int x, int y) {
    int border;

    if (len == 1)
        return 0;
    border = len / N;
    if (x >= border * (N - K) / 2 && x < border * (N + K) / 2 
            && y >= border * (N - K) / 2 && y < border * (N + K) / 2) {
        return 1;
    }
    return solution(border, x % border, y % border);
}

void solve() {
    int len = 1;

    input();
    while (s--) {
        len *= N;
    }

    for (int i = R1; i <= R2; ++i) {
        for (int j = C1; j <= C2; ++j) {
            cout << solution(len, i, j);
        }
        cout << '\n';
    }
}

int main() {
    solve();
}
//출처: https://noguen.com/150 [NOGUEN 블로그:티스토리]
