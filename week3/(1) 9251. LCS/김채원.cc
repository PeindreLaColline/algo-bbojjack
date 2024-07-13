#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	string s1, s2;
	cin >> s1 >> s2;

	vector<int> subset(s1.size()+1, 0);
	int prev, tmp;
	for (int i = 0; i < s2.size(); i++) {
		prev = 0;
		for (int j = 0; j < s1.size(); j++) {
			tmp = subset[j + 1];
			if (s1[j] == s2[i]) subset[j + 1] = prev + 1;
			else				subset[j + 1] = max(subset[j], subset[j + 1]);
			prev = tmp;
		}
	}
	cout << subset[subset.size() - 1];
}
