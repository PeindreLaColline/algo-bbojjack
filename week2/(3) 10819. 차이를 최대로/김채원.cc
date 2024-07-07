#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int n;
vector<int> num;
vector<bool> visited;;

int ans = -1000;
void back(int cnt, int val, int pre) {
	if (cnt == n) {
		if (ans < val) ans = val;
		return;
	}
	for (int i = 0; i < n; i++) {
		if (visited[i]) continue;
		visited[i] = true;
		back(cnt + 1, val + abs(pre-num[i]), num[i]);
		visited[i] = false;
	}
}

int main() {
	cin >> n;
	num.resize(n);
	visited.resize(n, false);
	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}
	
	for (int i = 0; i < n; i++) {
		visited[i] = true;
		back(1, 0, num[i]);
		visited[i] = false;
	}
	
	cout << ans;
}
