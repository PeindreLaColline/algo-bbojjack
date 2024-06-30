#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> v;
vector<bool> visited;
vector<int> pc;
queue<int> togo;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;
	v.resize(n+1);
	visited.resize(n + 1, false);
	pc.resize(n + 1);
	int a, b;
	for (int i = 0; i < n-1; i++) {
		cin >> a >> b;
		v[b].push_back(a);
		v[a].push_back(b);
	}
	int ci;
	visited[1] = true;
	togo.push(1);
	while (!togo.empty()) {
		ci = togo.front();
		togo.pop();
		for (int i = 0; i < v[ci].size(); i++) {
			if (visited[v[ci][i]]) continue;
			visited[v[ci][i]] = true;
			togo.push(v[ci][i]);
			pc[v[ci][i]] = ci;
		}
	}
	for (int i = 2; i <= n; i++) {
		cout << pc[i] << "\n";
	}
}
