//자료형의 표현 범위를 잘 보자!
#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	if (n == 1 || n == 2) {
		cout << 1;
		return 0;
	}
	long long pzero = 1, pone = 0;
	long long zero, one;
	for (int i = 3; i <= n; i++) {
		zero = pzero + pone;
		one = pzero;
		pzero = zero;
		pone = one;
	}

	cout << zero + one;
}
