//https://hwan-shell.tistory.com/309
#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n, k;
	cin >> n >> k;
	vector<int> dp(k + 1, 0);
	int coin;
	for (int i = 0; i < n; i++) {
		cin >> coin;
		dp[coin]++;
		for (int j = coin+1; j <= k; j++) {
			dp[j] += dp[j - coin];
		}
	}
	cout << dp[k];
}
