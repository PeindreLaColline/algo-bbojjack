#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, k;
vector<int> point;
vector<int> gap;

int main() {
	cin >> n >> k;
	//input
	point.resize(n);
	for (int i = 0; i < n; i++) {
		cin >> point[i];
	}
	sort(point.begin(), point.end());

	//get gap
	gap.resize(n);
	for (int i = 0; i < n - 1; i++) {
		gap[i] = point[i + 1] - point[i];
	}
	sort(gap.begin(), gap.end());

	//get ans
	int ans = 0;
	for (int i = 0; i < n - (k - 1); i++) {
		ans += gap[i];
	}
	cout << ans;
}
