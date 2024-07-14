#include <iostream>
#include <vector>
using namespace std;

#define R 0
#define G 1
#define B 2

int main() {
    int n;
    cin >> n;
    vector<vector<int>> color(n, vector<int>(3));
    vector<vector<int>> dp(n, vector<int>(3));

    for (int i = 0; i < n; i++) {
        cin >> color[i][R] >> color[i][G] >> color[i][B];
    }

    dp[0][R] = color[0][R];
    dp[0][G] = color[0][G];
    dp[0][B] = color[0][B];

    for (int i = 1; i < n; i++) {
        dp[i][R] = color[i][R] + min(dp[i - 1][G], dp[i - 1][B]);
        dp[i][G] = color[i][G] + min(dp[i - 1][R], dp[i - 1][B]);
        dp[i][B] = color[i][B] + min(dp[i - 1][R], dp[i - 1][G]);
    }

    cout << min(dp[n - 1][R], min(dp[n - 1][G], dp[n - 1][B])) << endl;
}
