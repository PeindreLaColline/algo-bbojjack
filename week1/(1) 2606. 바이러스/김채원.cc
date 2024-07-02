/*
bfs
*/
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, comp;

vector<vector<bool>> map;
vector<bool> visited;
queue<int> togo;

int ans = 0;

void bfs() {
	int a;
	while (!togo.empty()) {
		a = togo.front();
		togo.pop();

		for (int i = 1;i <= n; i++) {
			if (!visited[i] && map[a][i]) {
				visited[i] = true;
				togo.push(i);
				ans++;
			}
		}
	}
}

int main() {
	cin >> n >> comp;

	vector<bool> btmp(n+1, false);
	for (int i = 0; i <= n;i++) {
		map.push_back(btmp);
	}
	visited.resize(n+1, false);

	int a, b;
	for (int i = 0; i < comp; i++) {
		cin >> a >> b;
		map[a][b] = true;
		map[b][a] = true;
	}

	togo.push(1);
	visited[1] = true;

	bfs();

	cout << ans;
}
