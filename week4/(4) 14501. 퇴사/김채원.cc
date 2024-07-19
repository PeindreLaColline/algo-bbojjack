#include <iostream>
#include <vector>
using namespace std;

int n;
vector<int> dp;

int main() {
	cin >> n;
	dp.resize(n + 1, 0);
	int a, b;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		if (a + i <= n) dp[i + a] = max(dp[i + a], dp[i] + b);
		dp[i + 1] = max(dp[i + 1], dp[i]);
	}
	cout << dp[n];
}
