#include <iostream>
#include <vector>
using namespace std;

int n;
vector<int> num;

void binary(int s, int e, int tar) {
	while (true) {
		int mid = (s + e) / 2;
		int f = mid - 1;
		int b = mid + 1;
		if (num[mid] == tar) return;
		else {
			if (num[f] < tar && tar < num[mid]) {
				num[mid] = tar;
				return;
			}
			else if (num[mid] < tar && tar < num[b]) {
				num[b] = tar;
				return;
			}
			if (num[mid] > tar) e = mid - 1;
			else if (num[mid] < tar) s = mid + 1;
		}
	}
	num[0] = tar;
}

int main() {
	cin >> n;

	int tmp;
	cin >> tmp;
	num.push_back(tmp);
	for (int i = 0; i < n-1; i++) {
		cin >> tmp;
		if (num[num.size() - 1] < tmp) {
			num.push_back(tmp);
			continue;
		}
		else {
			binary(0, num.size() - 1, tmp);
		}
	}
	cout << num.size();
}
